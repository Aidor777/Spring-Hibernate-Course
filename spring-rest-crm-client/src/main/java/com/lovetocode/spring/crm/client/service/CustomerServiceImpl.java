package com.lovetocode.spring.crm.client.service;

import com.lovetocode.spring.crm.client.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final RestTemplate restTemplate;

    private final String customerApiUrl;

    @Autowired
    public CustomerServiceImpl(RestTemplate restTemplate, @Value("${crm.rest.api}") String apiURL) {
        this.restTemplate = restTemplate;
        this.customerApiUrl = apiURL + "/customers/";
    }

    @Override
    public List<Customer> getCustomers() {
        var responseEntity = restTemplate.exchange(customerApiUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Customer>>() {});
        return responseEntity.getBody();
    }

    @Override
    public void saveCustomer(Customer customer) {
        if (customer.getId() == 0) {
            restTemplate.postForEntity(customerApiUrl, customer, String.class);
        } else {
            restTemplate.put(customerApiUrl, customer);
        }
    }

    @Override
    public Customer getCustomer(int customerId) {
        return restTemplate.getForObject(customerApiUrl + customerId, Customer.class);
    }

    @Override
    public void deleteCustomer(int customerId) {
        restTemplate.delete(customerApiUrl + customerId);
    }
}
