package org.examples.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class ContextConfig {


    @Bean(name = "customerService")
    @Scope(scopeName = "singletone")
    public CustomerService getCustomerService() {
        return new CustomerService();
    }


    @Bean(name = "personService")
    @Scope(scopeName = "prototype")
    public PersonService getPersonService() {
        return new PersonService();
    }

}
