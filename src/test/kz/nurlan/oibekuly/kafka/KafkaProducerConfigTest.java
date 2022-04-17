/*
package kz.iitu.itse1910.nurlan.oibekuly.kafka;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {KafkaProducerConfig.class, String.class})
@ExtendWith(SpringExtension.class)
class KafkaProducerConfigTest {
    @Autowired
    private KafkaProducerConfig kafkaProducerConfig;

    @Test
    void testProducerFactory() {
        assertTrue(this.kafkaProducerConfig
                .producerFactory() instanceof org.springframework.kafka.core.DefaultKafkaProducerFactory);
    }

    @Test
    void testKafkaTemplate() {
        this.kafkaProducerConfig.kafkaTemplate();
    }

    @Test
    void testGreetingProducerFactory() {
        assertTrue(this.kafkaProducerConfig
                .greetingProducerFactory() instanceof org.springframework.kafka.core.DefaultKafkaProducerFactory);
    }

    @Test
    void testGreetingKafkaTemplate() {
        this.kafkaProducerConfig.greetingKafkaTemplate();
    }
}

*/
