package aze.coders.spring.boot.service;

import aze.coders.spring.boot.entity.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService{
    Page<Customer> getAllCustomers(Integer page, Integer size);

    Page<Customer> getAllCustomersByName(String name);
}
