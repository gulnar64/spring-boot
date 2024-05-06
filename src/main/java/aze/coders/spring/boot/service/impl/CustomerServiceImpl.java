package aze.coders.spring.boot.service.impl;

import aze.coders.spring.boot.entity.Customer;
import aze.coders.spring.boot.repository.CustomerRepository;
import aze.coders.spring.boot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public Page<Customer> getAllCustomers(Integer page, Integer size) {
        return customerRepository.findAllByOrderById(PageRequest.of(page,size));
    }

    @Override
    public Page<Customer> getAllCustomersByName(String name) {
        customerRepository.deleteNameByLength(15);
        return customerRepository.findAll(PageRequest.of(1,2));
    }
}
