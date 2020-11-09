package com.ResultsAPI.ResultsAPI.controller;

import com.ResultsAPI.ResultsAPI.model.PollItem;
import com.ResultsAPI.ResultsAPI.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Controller
public class PollController {

    @Autowired
    SimpMessagingTemplate template;

    @Autowired
    private PollService pollService;

    @MessageMapping("/poll")
    @SendTo("/pollResults/poll")
    public void getPoll() {
        template.convertAndSend("/pollResults/poll", pollService.getAllPollItems());
    }

}
