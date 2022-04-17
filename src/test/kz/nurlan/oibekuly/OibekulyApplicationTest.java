package kz.nurlan.oibekuly;

import kz.nurlan.oibekuly.OibekulyApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;

class OibekulyApplicationTest {
    @Mock
    ApplicationContext applicationContext;
    @InjectMocks
    OibekulyApplication oibekulyApplication;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testMain() {
//        OibekulyApplication.main(new String[]{"args"});
    }
}

