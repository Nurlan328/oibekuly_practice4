/*
package kz.iitu.itse1910.nurlan.oibekuly.kafka;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import kz.iitu.itse1910.nurlan.oibekuly.model.Account;
import org.apache.kafka.common.serialization.Deserializer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.LogIfLevelEnabled;
import org.springframework.kafka.support.mapping.DefaultJackson2JavaTypeMapper;
import org.springframework.kafka.support.mapping.Jackson2JavaTypeMapper;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {KafkaConsumerConfig.class, String.class})
@ExtendWith(SpringExtension.class)
class KafkaConsumerConfigTest {
    @Autowired
    private KafkaConsumerConfig kafkaConsumerConfig;

    @Test
    void testConsumerFactory() {
        ConsumerFactory<String, String> actualConsumerFactoryResult = this.kafkaConsumerConfig.consumerFactory("42");
        assertEquals(6, actualConsumerFactoryResult.getConfigurationProperties().size());
        assertNull(actualConsumerFactoryResult.getValueDeserializer());
        assertNull(actualConsumerFactoryResult.getKeyDeserializer());
        assertTrue(actualConsumerFactoryResult.getPostProcessors().isEmpty());
        assertTrue(actualConsumerFactoryResult.getListeners().isEmpty());
    }

    @Test
    void testKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> actualKafkaListenerContainerFactoryResult = this.kafkaConsumerConfig
                .kafkaListenerContainerFactory("42");
        ConsumerFactory<? super String, ? super String> consumerFactory = actualKafkaListenerContainerFactoryResult
                .getConsumerFactory();
        assertTrue(consumerFactory instanceof org.springframework.kafka.core.DefaultKafkaConsumerFactory);
        assertNull(consumerFactory.getValueDeserializer());
        ContainerProperties containerProperties = actualKafkaListenerContainerFactoryResult.getContainerProperties();
        assertNull(containerProperties.getTopics());
        assertNull(containerProperties.getTopicPattern());
        assertNull(containerProperties.getTopicPartitions());
        assertEquals(10000L, containerProperties.getShutdownTimeout());
        assertEquals(5000L, containerProperties.getPollTimeout());
        assertEquals(3.0f, containerProperties.getNoPollThreshold());
        assertEquals(30, containerProperties.getMonitorInterval());
        assertEquals(5.0, containerProperties.getIdleBeforeDataMultiplier());
        assertEquals(ContainerProperties.EOSMode.V2, containerProperties.getEosMode());
        Duration expectedConsumerStartTimeout = containerProperties.getConsumerStartTimout();
        assertSame(expectedConsumerStartTimeout, containerProperties.getConsumerStartTimeout());
        assertEquals(3, containerProperties.getCommitRetries());
        assertEquals(LogIfLevelEnabled.Level.DEBUG, containerProperties.getCommitLogLevel());
        assertEquals("", containerProperties.getClientId());
        assertEquals(ContainerProperties.AssignmentCommitOption.LATEST_ONLY_NO_TX,
                containerProperties.getAssignmentCommitOption());
        assertEquals(0, containerProperties.getAdviceChain().length);
        assertEquals(5000L, containerProperties.getAckTime());
        assertEquals(ContainerProperties.AckMode.BATCH, containerProperties.getAckMode());
        assertEquals(1, containerProperties.getAckCount());
        assertNull(consumerFactory.getKeyDeserializer());
    }

    @Test
    void testGreetingConsumerFactory() {
        ConsumerFactory<String, Account> actualGreetingConsumerFactoryResult = this.kafkaConsumerConfig
                .greetingConsumerFactory();
        assertEquals(2, actualGreetingConsumerFactoryResult.getConfigurationProperties().size());
        Deserializer<Account> valueDeserializer = actualGreetingConsumerFactoryResult.getValueDeserializer();
        assertTrue(valueDeserializer instanceof JsonDeserializer);
        assertTrue(actualGreetingConsumerFactoryResult
                .getKeyDeserializer() instanceof org.apache.kafka.common.serialization.StringDeserializer);
        assertTrue(actualGreetingConsumerFactoryResult.getPostProcessors().isEmpty());
        assertTrue(actualGreetingConsumerFactoryResult.getListeners().isEmpty());
        Jackson2JavaTypeMapper typeMapper = ((JsonDeserializer<Account>) valueDeserializer).getTypeMapper();
        assertTrue(typeMapper instanceof DefaultJackson2JavaTypeMapper);
        assertEquals("__TypeId__", ((DefaultJackson2JavaTypeMapper) typeMapper).getClassIdFieldName());
        assertEquals(Jackson2JavaTypeMapper.TypePrecedence.TYPE_ID, typeMapper.getTypePrecedence());
        assertEquals("__KeyTypeId__", ((DefaultJackson2JavaTypeMapper) typeMapper).getKeyClassIdFieldName());
        assertTrue(((DefaultJackson2JavaTypeMapper) typeMapper).getIdClassMapping().isEmpty());
        assertEquals("__ContentTypeId__", ((DefaultJackson2JavaTypeMapper) typeMapper).getContentClassIdFieldName());
    }

    @Test
    void testGreetingKafkaListenerContainerFactory() {

        this.kafkaConsumerConfig.greetingKafkaListenerContainerFactory();
    }

    @Test
    void testFooKafkaListenerContainerFactory() {
        this.kafkaConsumerConfig.fooKafkaListenerContainerFactory();
    }

    @Test
    void testBarKafkaListenerContainerFactory() {
        this.kafkaConsumerConfig.barKafkaListenerContainerFactory();
    }

    @Test
    void testHeadersKafkaListenerContainerFactory() {
        this.kafkaConsumerConfig.headersKafkaListenerContainerFactory();
    }

    @Test
    void testPartitionsKafkaListenerContainerFactory() {
        this.kafkaConsumerConfig.partitionsKafkaListenerContainerFactory();
    }

    @Test
    void testLongMessageKafkaListenerContainerFactory() {
        this.kafkaConsumerConfig.longMessageKafkaListenerContainerFactory();
    }

    @Test
    void testFilterKafkaListenerContainerFactory() {
        this.kafkaConsumerConfig.filterKafkaListenerContainerFactory();
    }
}

*/
