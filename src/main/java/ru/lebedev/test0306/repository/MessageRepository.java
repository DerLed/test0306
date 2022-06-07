package ru.lebedev.test0306.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lebedev.test0306.entity.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByUserId(Long id);
}
