package com.groupC.twitter.repository;

import com.groupC.twitter.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Messages,Long> {
    public List<Messages> findBySenderIdAndRecieverId(Long senderId,Long recieverId);
}
