package com.ef;

import com.ef.services.LogService;
import com.ef.services.SearchLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

//    @Autowired
//    private HelloMessageService helloService;

    @Autowired
    private LogService logService;

    @Autowired
    private SearchLogService searchLogService;

    public static void main(String[] args) throws Exception {

        //disabled banner, don't want to see the spring logo
        SpringApplication app = new SpringApplication(SpringBootConsoleApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

        //SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        if (args.length > 0 ) {
            logService.importAllLogToDatabase(args);
            searchLogService.searchLogsByArgs(args);
        }

        exit(0);
    }
}