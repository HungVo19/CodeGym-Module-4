package com.example.registerform.repository;

import com.example.registerform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IRegisterRepository extends JpaRepository<User,Long> {
}
