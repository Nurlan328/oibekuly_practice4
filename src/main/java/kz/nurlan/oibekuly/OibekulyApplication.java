package kz.nurlan.oibekuly;
import kz.nurlan.oibekuly.model.Customers;
import kz.nurlan.oibekuly.repository.CustomersRepository;
import kz.nurlan.oibekuly.repository.impl.CustomersRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.JmsException;
import org.springframework.kafka.annotation.EnableKafka;

import javax.jms.JMSException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
@EnableKafka
public class OibekulyApplication {

    @Autowired
    public static CustomersRepositoryImpl customersRepositoryimpl;

    public static void main(String[] args) {

        SpringApplication.run(OibekulyApplication.class, args);

        CustomersRepositoryImpl customersRepositoryimpl = new CustomersRepositoryImpl();

        Optional<Customers> customersByAddress = customersRepositoryimpl.findByAddress("Almaty");
        System.out.println(customersByAddress);

        LocalDateTime date = LocalDate.of(1970, 1, 1).atStartOfDay();
        String lastNamesByDate = customersRepositoryimpl.lastNamesByDate(LocalDate.from(date));
        System.out.println(lastNamesByDate);
    }
}


















