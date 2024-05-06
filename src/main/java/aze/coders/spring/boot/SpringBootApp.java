package aze.coders.spring.boot;

import aze.coders.spring.boot.service.CustomerService;
import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
public class SpringBootApp   {
    private final CustomerService customerService;

    public SpringBootApp(CustomerService customerService) {
        this.customerService = customerService;
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootApp.class, args);
        CustomerService customerService = context.getBean(CustomerService.class);
//        System.out.println("List: ");
//        customerService.getAllCustomers().forEach(System.out::println);
    }
}
