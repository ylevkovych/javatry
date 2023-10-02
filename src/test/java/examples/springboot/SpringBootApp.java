package examples.springboot;

import org.examples.springboot.ContextConfig;
import org.examples.springboot.CustomerService;
import org.examples.springboot.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = ContextConfig.class)
@SpringBootTest
public class SpringBootApp {

    @Autowired
    private BeanFactory beanFactory;

    @Test
    public void checkSingletonCustomerService() {
        final String BEAN_NAME = "customerService";

        Assertions.assertNotNull(beanFactory.containsBean(BEAN_NAME));

        CustomerService customerService1 = beanFactory.getBean(CustomerService.class);
        Assertions.assertNotNull(customerService1);

        Object customerService2 = beanFactory.getBean(BEAN_NAME);
        Assertions.assertNotNull(customerService2);

        Assertions.assertTrue(customerService1 == customerService2);
    }

    @Test
    public void checkPrototypePersonService() {
        final String BEAN_NAME = "personService";

        Assertions.assertNotNull(beanFactory.containsBean(BEAN_NAME));

        PersonService personService1 = beanFactory.getBean(PersonService.class);
        Assertions.assertNotNull(personService1);

        Object personService2 = beanFactory.getBean(BEAN_NAME);
        Assertions.assertNotNull(personService2);

        Assertions.assertFalse(personService1 == personService2);
    }


}
