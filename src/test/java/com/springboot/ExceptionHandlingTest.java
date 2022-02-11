package com.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.exception.InvalidFieldException;
import com.springboot.exception.InvalidHeaderFieldException;
import com.springboot.handler.ExceptionHandling;

@RunWith(SpringJUnit4ClassRunner.class)
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
