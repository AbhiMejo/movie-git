package com.example.user.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.user.user.entity.UserView;

@Repository
public interface UserViewRepo extends CrudRepository<UserView, Long> {

}
