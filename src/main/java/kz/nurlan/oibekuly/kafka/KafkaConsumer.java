package kz.nurlan.oibekuly.kafka;

import kz.nurlan.oibekuly.converter.Converter;
import kz.nurlan.oibekuly.dto.AccountDto;
import kz.nurlan.oibekuly.dto.AccountRequestDto;
import kz.nurlan.oibekuly.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@Service
@Slf4j
@EnableKafka
public class KafkaConsumer {

    private CountDownLatch latch = new CountDownLatch(1);
    private String payload = null;

    @Autowired
    public AccountService accountService;

    @Autowired
    public Converter converter;

    @KafkaListener(topics = "NewTopic", groupId = "group_id")
    public void consume (ConsumerRecord<Integer, AccountDto> record) throws IOException {

        log.info(String.format("#### -> Consumed message -> %s", record.value()));

       AccountRequestDto accountRequestDto = new AccountRequestDto
                                               (record.value().getAccountnumber(),
                                               record.value().getBalance(),
                                               record.value().getInterest());

        accountService.save(converter.dtoToAccount(accountRequestDto));
        log.info("Consumed object was added");
        latch.countDown();
    }


    public CountDownLatch getLatch() {
        return latch;
    }

    public String getPayload() {
        return payload;
    }

}