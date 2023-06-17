package com.ayrotek.servis.ayrotektaxservis.utils;

import com.ayrotek.servis.ayrotektaxservis.Repo.LogRepository;
import com.ayrotek.servis.ayrotektaxservis.domain.model.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class CustomLogger {

    private final LogRepository logRepository;

    public String info(String message) {
        Log log = new Log();
        log.setLevel("INFO");
        log.setMessage(message);
        log.setDate(new Date());
        logRepository.insert(log);
        return message;
    }

    public String debug(String message) {
        Log log = new Log();
        log.setLevel("DEBUG");
        log.setMessage(message);
        log.setDate(new Date());
        logRepository.save(log);
        return message;
    }

    public String warning(String message) {
        Log log = new Log();
        log.setLevel("WARN");
        log.setMessage(message);
        log.setDate(new Date());
        this.logRepository.save(log);
        return message;
    }


}
