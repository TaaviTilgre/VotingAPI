package com.ResultsAPI.ResultsAPI.socketConfig;

import com.ResultsAPI.ResultsAPI.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@EnableScheduling
@Configuration
public class SchedulerConfig {

    @Autowired
    SimpMessagingTemplate template;

    @Autowired
    private PollService pollService;

    @CrossOrigin
    @Scheduled(fixedDelay = 3000)
    public void sendPollDataMessages() {
        template.convertAndSend("/pollResults/poll", pollService.getAllPollItems());
    }
}