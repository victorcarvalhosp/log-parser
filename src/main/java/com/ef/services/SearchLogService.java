package com.ef.services;

import com.ef.entities.BloquedIp;
import com.ef.entities.SearchLog;
import com.ef.enums.DurationEnum;
import com.ef.repositories.SearchLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class SearchLogService {

    @Autowired
    private LogService logService;

    @Autowired
    private SearchLogRepository repository;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");
    private static final String START_DATE_PARAM = "startDate";
    private static final String DURATION_PARAM = "duration";
    private static final String THRESHOLD_PARAM = "threshold";

    private Date calculateFinalDateBasedOnDurationParam(Date startDate, DurationEnum duration) {
        LocalDateTime ldt = LocalDateTime.ofInstant(startDate.toInstant(), ZoneId.systemDefault());
        if (DurationEnum.HOURLY.equals(duration)) {
            ldt = ldt.plusHours(1);
        } else {
            //Get daily by default
            ldt = ldt.plusHours(24);
        }
        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }


    public void searchLogsByArgs(String[] args) {
        SearchLog searchLog = new SearchLog();
        try {
            for (String arg : args) {
                String[] properties = arg.split("=");
                if (properties[0].toLowerCase().contains(START_DATE_PARAM.toLowerCase())) {
                    Date startDate = dateFormat.parse(properties[1]);
                    searchLog.setStartDate(startDate);
                }else if (properties[0].toLowerCase().contains(DURATION_PARAM.toLowerCase())) {
                    searchLog.setDuration(DurationEnum.valueOf(properties[1].toUpperCase()));
                }else if (properties[0].toLowerCase().contains(THRESHOLD_PARAM.toLowerCase())) {
                    searchLog.setThreshold(Integer.parseInt(properties[1]));
                }
            }
            searchLog.setFinalDate(calculateFinalDateBasedOnDurationParam(searchLog.getStartDate(), searchLog.getDuration()));

            List<BloquedIp> bloquedIps = logService.findBloquedIpsByDateAndThreshold(searchLog);
            for (BloquedIp bloquedIp: bloquedIps) {
                bloquedIp.setSearchLog(searchLog);
                bloquedIp.setComments("Ip " + bloquedIp.getIp() + " blocked because has mora than " + searchLog.getThreshold() + " requests between " + dateFormat.format(searchLog.getStartDate()) + " and " + dateFormat.format(searchLog.getFinalDate()));
                System.out.println(bloquedIp.getComments());
            }
            searchLog.setBloquedIps(bloquedIps);
            repository.save(searchLog);

            System.out.println(searchLog);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
