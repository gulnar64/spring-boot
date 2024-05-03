package aze.coders.spring.boot.controller;

import aze.coders.spring.boot.entity.Customer;
import aze.coders.spring.boot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/byName")
    public List<Customer> getCustomers(@RequestParam String name) {
        return customerService.getAllCustomersByName(name);
    }
}
