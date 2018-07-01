package org.js.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.js.exception.BeanCreationException;
import org.js.exception.BeanDefinitionException;
import org.js.model.BeanDefinition;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by JiaShun on 2018/7/1.
 */

public class ClassPathXmlApplicationContext implements BeanFactory {
    private Map<String,BeanDefinition> beans = new ConcurrentHashMap<>();
    private static final String ID = "id";
    private static final String CLASS = "class";
    public ClassPathXmlApplicationContext(String configFile){
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(new File(configFile));
        } catch (DocumentException e) {
            throw new BeanDefinitionException("IOException parsing XML document",e);
        }
        Element root = document.getRootElement();
        List<Element> list = root.elements("bean");
        Iterator<Element> iterator = root.elementIterator();
        while (iterator.hasNext()){
            Element element = iterator.next();
            String id = element.attributeValue(ID);
            String className = element.attributeValue(CLASS);
            BeanDefinition bd = new BeanDefinition(id,className);
            beans.put(id,bd);
        }
    }
    @Override
    public Object getBean(String beanId) {
        ClassLoader cl = this.getClass().getClassLoader();
        Class<?> clz = null;
        try {
            BeanDefinition bd = beans.get(beanId);
            clz = cl.loadClass(bd.getBeanClassName());
            return clz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("create bean for " + beanId + "failed" , e);
        }
    }
}
