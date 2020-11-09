package com.ResultsAPI.ResultsAPI.service;

import com.ResultsAPI.ResultsAPI.model.PollItem;

import java.util.List;

public interface PollService {
    PollItem createPollItem(PollItem pollItem);
    PollItem createPollItemIfNotExsists(PollItem pollItem);

    PollItem updatePollItem(PollItem pollItem);

    PollItem vote(long id);

    List<PollItem> getAllPollItems();
}
