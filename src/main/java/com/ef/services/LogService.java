package com.ef.services;

import com.ef.entities.Log;
import com.ef.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LogService {

    private static final int LOG_DATE_POSITION = 0;
    private static final int LOG_IP_POSITION = 1;
    private static final int LOG_REQUEST_POSITION = 2;
    private static final int LOG_STATUS_POSITION = 3;
    private static final int LOG_USER_AGENT_POSITION = 4;

    private static final String  LOG_FILE_LOCATION = "src/main/resources/access.log";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @Autowired
    private LogRepository logRepository;

    public void importAllLogToDatabase(){
        //read file into stream, try-with-resources
        try {

            BufferedReader b = new BufferedReader(new FileReader(LOG_FILE_LOCATION));

            String readLine = "";

            System.out.println("Reading file using Buffered Reader");

            while ((readLine = b.readLine()) != null) {
                populateAndSaveLog(readLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void populateAndSaveLog(String readLine) throws ParseException {
        Log log = new Log();
        //System.out.println(readLine);
        String[] properties = readLine.split("\\|");
        Date startDate = dateFormat.parse(properties[LOG_DATE_POSITION]);
        log.setDate(startDate);
        log.setIp(properties[LOG_IP_POSITION]);
        log.setRequest(properties[LOG_REQUEST_POSITION]);
        log.setStatus(Integer.parseInt(properties[LOG_STATUS_POSITION]));
        log.setUserAgent(properties[LOG_USER_AGENT_POSITION]);

        logRepository.save(log);
    }

    @Value("${name:unknown}")
    private String name;

    public String getMessage() {
        return getMessage(name);
    }

    public String getMessage(String name) {
        return "Hello " + name;
    }

}
