package aze.coders.spring.boot.service.impl;

import aze.coders.spring.boot.entity.Customer;
import aze.coders.spring.boot.repository.CustomerRepository;
import aze.coders.spring.boot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getAllCustomersByName(String name) {
        customerRepository.deleteNameByLength(15);
        return customerRepository.findAll();
    }
}
