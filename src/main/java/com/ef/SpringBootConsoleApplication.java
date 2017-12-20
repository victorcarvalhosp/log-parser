package com.ef;

import com.ef.entities.SearchLog;
import com.ef.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.exit;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

//    @Autowired
//    private HelloMessageService helloService;

    @Autowired
    private LogService logService;

    public static void main(String[] args) throws Exception {

        //disabled banner, don't want to see the spring logo
        SpringApplication app = new SpringApplication(SpringBootConsoleApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

        //SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        logService.importAllLogToDatabase();

        if (args.length > 0 ) {
           // System.out.println(helloService.getMessage(args[0].toString()));
            SearchLog searchLog = new SearchLog();
            for (String arg: args   ) {
                String[] properties = arg.split("=");

                if(properties[0].contains("startDate")){
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");
                    Date startDate = dateFormat.parse(properties[1]);
                    searchLog.setStartDate(startDate);
                }
                System.out.println(properties[0] + " " + properties[1]);
            }

        }else{
        }

        exit(0);
    }
}