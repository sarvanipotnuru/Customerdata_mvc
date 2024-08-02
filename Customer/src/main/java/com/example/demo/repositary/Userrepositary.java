package com.example.demo.repositary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.User;
@Repository
public interface Userrepositary extends CrudRepository<User,Integer> {

}
