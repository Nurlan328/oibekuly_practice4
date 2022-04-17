//package kz.iitu.itse1910.nurlan.oibekuly.model;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.util.Date;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ContextConfiguration(classes = {Customers.class})
//@ExtendWith(SpringExtension.class)
//class CustomersTest {
//
//    Labels labels = new Labels(0, "name", "category", "description");
//
//    @Test
//    void testToString() {
//        String result = labels.toString();
//        Assertions.assertEquals("Name='name', category='category', description='description'", result);
//    }
//
//    @Test
//    void testSetLabel_id() {
//        labels.setLabel_id(0);
//    }
//
//    @Test
//    void testSetName() {
//        labels.setName("name");
//    }
//
//    @Test
//    void testSetCategory() {
//        labels.setCategory("category");
//    }
//
//    @Test
//    void testSetDescription() {
//        labels.setDescription("description");
//    }
//
//    @Test
//    void testEquals() {
//        boolean result = labels.equals("o");
//        Assertions.assertEquals(false, result);
//    }
//
//    @Test
//    void testCanEqual() {
//        boolean result = labels.canEqual("other");
//        Assertions.assertEquals(false, result);
//    }
//
//    @Autowired
//    private Customers customers;
//
////    @Test
////    void testIsCountryCustomer() {
////        assertFalse((new Customers()).isCountryCustomer());
////    }
//
////    @Test
////    void testIsCountryCustomer2() {
////        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
////        assertTrue((new Customers(1, "Jane", "Doe", 1, "42 Main St", "https://example.org/example", true,
////                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()))).isCountryCustomer());
////    }
//}
//
