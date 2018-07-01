package org.js;

import org.js.dao.UserDAO;
import org.js.factory.BeanFactory;
import org.js.factory.ClassPathXmlApplicationContext;
import org.js.service.UserService;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void testGetBean(){
        String configFile = "src\\test\\resources\\beans.xml";
        BeanFactory factory = new ClassPathXmlApplicationContext(configFile);
        UserDAO userDAO = (UserDAO)factory.getBean("userDao");
        UserService userService = (UserService)factory.getBean("userService");
        Assert.assertNotNull(userDAO);
        Assert.assertNotNull(userService);
    }

    @Test
    public void testGetBeanDefinition(){
        String configFile = "src\\test\\resources\\beans.xml";
        BeanFactory factory = new ClassPathXmlApplicationContext(configFile);

    }
}
