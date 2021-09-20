package com.example.WebFluxDemo.controller;

import com.example.WebFluxDemo.dto.Customer;
import com.example.WebFluxDemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/traditionalApi",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value="/reactiveApi",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersByReactive(){
      return customerService.getAllCustomersByFlux();
    }
    @GetMapping(value = "/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getStream(){
        return customerService.getAllCustomersStream();
    }
}
