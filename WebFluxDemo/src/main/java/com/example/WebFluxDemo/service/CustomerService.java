package com.example.WebFluxDemo.service;

import com.example.WebFluxDemo.dao.CustomerDao;
import com.example.WebFluxDemo.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> getAllCustomers(){
        long start=System.currentTimeMillis();
        List<Customer> result=customerDao.getCustomers();
        long end=System.currentTimeMillis();
        System.out.println("Processing time= "+(end-start));
        return result;
    }


    public Flux<Customer> getAllCustomersStream(){
        long start=System.currentTimeMillis();
        Flux<Customer> result=customerDao.getCustomersStream();
        long end=System.currentTimeMillis();
        System.out.println("Processing time= "+(end-start));
        return result;
    }
    public Flux<Customer> getAllCustomersByFlux(){
        long start=System.currentTimeMillis();
        Flux<Customer> result=customerDao.getCustomersByFlux();
        long end=System.currentTimeMillis();
        System.out.println("Processing time= "+(end-start));
        return result;
    }
}
