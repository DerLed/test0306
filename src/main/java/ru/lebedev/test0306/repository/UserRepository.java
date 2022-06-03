package ru.lebedev.test0306.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lebedev.test0306.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

}