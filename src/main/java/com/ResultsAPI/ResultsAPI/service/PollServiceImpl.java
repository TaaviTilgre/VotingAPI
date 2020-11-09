package com.ResultsAPI.ResultsAPI.service;

import com.ResultsAPI.ResultsAPI.model.PollItem;
import com.ResultsAPI.ResultsAPI.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PollServiceImpl  implements PollService{

    @Autowired
    private PollRepository pollRepository;

    @Override
    public PollItem createPollItem(PollItem pollItem) {
        return pollRepository.save(pollItem);
    }

    @Override
    public PollItem createPollItemIfNotExsists(PollItem pollItem){
        Optional<PollItem> pollItemDb = this.pollRepository.findById(pollItem.getId());

        if(!pollItemDb.isPresent()) {
            return pollRepository.save(pollItem);
        }else {
            return pollItem;
        }
    }

    @Override
    public PollItem updatePollItem(PollItem pollItem) {
        Optional<PollItem> pollItemDb = this.pollRepository.findById(pollItem.getId());

        PollItem pollItemUpdate = pollItemDb.get();
        pollItemUpdate.setId(pollItem.getId());
        pollItemUpdate.setName(pollItem.getName());
        pollItemUpdate.setVotes(pollItem.getVotes());
        pollRepository.save(pollItemUpdate);
        return pollItemUpdate;
    }

    @Override
    public PollItem vote(long id) {
        Optional<PollItem> pollItemDb = this.pollRepository.findById(id);

        if(pollItemDb.isPresent()) {
            PollItem pollItemUpdate = pollItemDb.get();
            pollItemUpdate.setVotes(pollItemUpdate.getVotes() + 1);
            pollRepository.save(pollItemUpdate);
            return pollItemUpdate;
        }else {
            throw new RuntimeException("Vote item not found");
        }
    }

    @Override
    public List<PollItem> getAllPollItems() {
        return this.pollRepository.findAll();
    }

}
