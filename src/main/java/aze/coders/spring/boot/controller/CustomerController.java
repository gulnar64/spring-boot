package aze.coders.spring.boot.controller;

import aze.coders.spring.boot.entity.Customer;
import aze.coders.spring.boot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public Page<Customer> getCustomers(@RequestParam Integer page, @RequestParam Integer size) {
        return customerService.getAllCustomers(page, size);
    }

    @GetMapping("/byName")
    public Page<Customer> getCustomers(@RequestParam String name) {
        return customerService.getAllCustomersByName(name);
    }
}
