package com.example.WebFluxDemo.dao;

import com.example.WebFluxDemo.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    private static void sleepExec() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public List<Customer> getCustomers(){
        return IntStream.rangeClosed(1,50)
                .peek(j-> sleepExec())
                .peek(i->System.out.println("processing count "+i))
                .mapToObj(i->new Customer(i,"customer"+i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomersByFlux(){
        return Flux.range(1,50)
             .delayElements(Duration.ofSeconds(1))
                .doOnNext(i->System.out.println("processing count in flux: "+i))
                .map(i->new Customer(i,"FluxCustomer "+i));
    }
    public Flux<Customer> getCustomersStream(){
        return Flux.range(1,50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i-> System.out.println("processing Stream Count: " +i))
                .map(i->new Customer(i,"Customer Stream "+i));
    }


}
