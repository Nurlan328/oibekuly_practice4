/*
package kz.iitu.itse1910.nurlan.oibekuly.kafka;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.kafka.clients.admin.NewTopic;
import org.junit.jupiter.api.Test;

class KafkaTopicConfigTest {
    @Test
    void testTopic() {
        NewTopic actualTopicResult = (new KafkaTopicConfig()).topic();
        assertEquals(1, actualTopicResult.configs().size());
        assertNull(actualTopicResult.replicasAssignments());
        assertNull(actualTopicResult.name());
    }

    @Test
    void testTopic1() {
        NewTopic actualTopic1Result = (new KafkaTopicConfig()).topic1();
        assertNull(actualTopic1Result.configs());
        assertEquals("(name=null, numPartitions=1, replicationFactor=1, replicasAssignments=null, configs=null)",
                actualTopic1Result.toString());
        assertNull(actualTopic1Result.replicasAssignments());
        assertNull(actualTopic1Result.name());
    }

    @Test
    void testTopic2() {
        NewTopic actualTopic2Result = (new KafkaTopicConfig()).topic2();
        assertNull(actualTopic2Result.configs());
        assertEquals("(name=null, numPartitions=6, replicationFactor=1, replicasAssignments=null, configs=null)",
                actualTopic2Result.toString());
        assertNull(actualTopic2Result.replicasAssignments());
        assertNull(actualTopic2Result.name());
    }

    @Test
    void testTopic3() {
        NewTopic actualTopic3Result = (new KafkaTopicConfig()).topic3();
        assertNull(actualTopic3Result.configs());
        assertEquals("(name=null, numPartitions=1, replicationFactor=1, replicasAssignments=null, configs=null)",
                actualTopic3Result.toString());
        assertNull(actualTopic3Result.replicasAssignments());
        assertNull(actualTopic3Result.name());
    }

    @Test
    void testTopic4() {
        NewTopic actualTopic4Result = (new KafkaTopicConfig()).topic4();
        assertNull(actualTopic4Result.configs());
        assertEquals("(name=null, numPartitions=1, replicationFactor=1, replicasAssignments=null, configs=null)",
                actualTopic4Result.toString());
        assertNull(actualTopic4Result.replicasAssignments());
        assertNull(actualTopic4Result.name());
    }
}

*/
