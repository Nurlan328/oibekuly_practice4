//package kz.nurlan.oibekuly.kafka;
//
//
//import kz.nurlan.oibekuly.dto.AccountRequestDto;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.stereotype.Service;
//import org.springframework.util.concurrent.ListenableFuture;
//import org.springframework.util.concurrent.ListenableFutureCallback;
//
//@Service
//@Slf4j
//public class KafkaProducer {
//
//    @Autowired
//    private KafkaTemplate<Long, AccountRequestDto> kafkaTemplate;
//
//    public void sendOrder(Long msgId, AccountRequestDto msg) {
//        ListenableFuture<SendResult<Long, AccountRequestDto>> future = kafkaTemplate.send("NewTopic", msgId, msg);
//        future.addCallback(new ListenableFutureCallback<SendResult<Long, AccountRequestDto>>() {
//
//            @Override
//            public void onSuccess(SendResult<Long, AccountRequestDto> result) {
//                System.out.println("Sent message=[" + msg +
//                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
//            }
//
//            @Override
//            public void onFailure(Throwable ex) {
//                System.out.println("Unable to send message=["
//                        + msg + "] due to : " + ex.getMessage());
//            }
//        });
//        kafkaTemplate.flush();
//    }
//}
