package aze.coders.spring.boot.service;

import aze.coders.spring.boot.entity.Customer;

import java.util.List;

public interface CustomerService{
    List<Customer> getAllCustomers();

    List<Customer> getAllCustomersByName(String name);
}
