package com.ef.services;


import com.ef.entities.Log;
import com.ef.repositories.LogRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class LogServiceTest {

//    @Mock
//    private LogRepository logRepository;
//
//    @Autowired
//    private LogService logService;
//
//    @Before
//    public void setUp() throws Exception {
//        BDDMockito.given(this.logRepository.count()).willReturn((long) 1);
//        BDDMockito.given(this.logRepository.save(Mockito.any(Log.class))).willReturn(new Log());
//    }
//
//    @Test
//    public void testTrue(){
//        assertTrue(true);
//    }
//
//    @Test
//    public void testConvertLineToLogObject() {
//        try {
//            String logLine = "2017-01-01 00:00:11.763|192.168.234.82|\"GET / HTTP/1.1\"|200|\"swcd (unknown version) CFNetwork/808.2.16 Darwin/15.6.0";
//            Log log = logService.convertLineToLogObject(logLine);
//            assertEquals("192.168.234.82", log.getIp());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }

}
