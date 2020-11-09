package com.ResultsAPI.ResultsAPI.repository;

import com.ResultsAPI.ResultsAPI.model.PollItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<PollItem, Long> {
}
