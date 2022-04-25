package kz.nurlan.oibekuly.repository.impl;

import kz.nurlan.oibekuly.model.Customers;
import kz.nurlan.oibekuly.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomersRepositoryImpl {

    @Autowired
    public CustomersRepository customersRepository;

    public List<Customers> listOfCustomers () {
        return customersRepository.findAll();
    }

    public Optional<Customers> findByAddress(String address) {
        return listOfCustomers()
                .stream()
                .filter(s->s.getAddress()
                        .equals(address))
                .findFirst();
    }

    public Optional<Customers> findCustomerById(Integer id) {
        return listOfCustomers()
                .stream()
                .filter(s -> s.getCustomer_id()
                        .equals(id))
                .findFirst();
    }

    public Optional<Customers> findByLastName(String lastName) {
        return listOfCustomers()
                .stream()
                .filter(s -> s.getLastname()
                        .equals(lastName)).findFirst();
    }

    public Optional<Customers> findByFirstName(String firstName) {
        return listOfCustomers()
                .stream()
                .filter(s->s.getFirstname()
                        .equals(firstName))
                .findFirst();
    }

    public String lastNamesByDate(LocalDate date) {
        String customersBeforeDate =
            listOfCustomers()
            .stream()
            .filter(
            customer -> customer.getDateOfBirth()
            .isBefore(date))
            .map(Customers::getLastname)
            .collect(Collectors.joining(", "));
        return customersBeforeDate;
    }






}













