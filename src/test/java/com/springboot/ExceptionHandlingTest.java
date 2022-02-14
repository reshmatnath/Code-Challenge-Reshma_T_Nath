package com.springboot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.springboot.exception.InvalidFieldException;
import com.springboot.exception.InvalidHeaderFieldException;
import com.springboot.handler.ExceptionHandling;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ExceptionHandlingTest {

    @InjectMocks
    private ExceptionHandling exceptionHandling;
    
    private InvalidFieldException invalidFieldException =new  InvalidFieldException("test");;
    private InvalidHeaderFieldException invalidHeaderFieldException = new InvalidHeaderFieldException("test");
    @Test
    public void testhandleInvalidFieldException() throws Exception {
    	exceptionHandling.handleInvalidFieldException(invalidFieldException);
    }
    
    @Test
    public void testhandleInvalidHeaderFieldException() throws Exception {
    	exceptionHandling.handleInvalidHeaderFieldException(invalidHeaderFieldException);
    }

}
