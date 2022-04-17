package kz.nurlan.oibekuly.aop;

import kz.nurlan.oibekuly.aop.BankAspect;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = {BankAspect.class})
@ExtendWith(SpringExtension.class)
class BankAspectTest {

    @Test
    void testBankDetails() {
        assertEquals("Bank id: 0\n Bank name: null\n Number of customer account null", this.bankAspect.bankDetails());
    }

    @Autowired
    private BankAspect bankAspect;
}

