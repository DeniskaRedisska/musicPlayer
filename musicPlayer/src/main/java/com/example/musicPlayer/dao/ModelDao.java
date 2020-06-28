package com.example.musicPlayer.dao;

import com.example.musicPlayer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelDao extends CrudRepository<User, Integer> {

}
