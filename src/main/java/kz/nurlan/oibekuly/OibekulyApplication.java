package kz.nurlan.oibekuly;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.JmsException;
import org.springframework.kafka.annotation.EnableKafka;

import javax.jms.JMSException;


@SpringBootApplication
@EnableKafka
public class OibekulyApplication {

    public static void main(String[] args) throws JmsException, JMSException  {
        SpringApplication.run(OibekulyApplication.class, args);

//        Customers customers = new Customers(30,"James", "Johnson", 29,
//    "Texas","93642851537", true, new Date(1993, Calendar.JUNE, 1));
//        System.out.println(customers.getDateOfBirth());

/*        ConfigurableApplicationContext context = SpringApplication.run(OibekulyApplication.class, args);
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        Account account = new Account(2, 1234L, 200000d, 0.02d);
        CustomerReceiver customerReceiver = new CustomerReceiver();
        customerReceiver.notifyWithdrawing(20000d);*/
    }
}


















