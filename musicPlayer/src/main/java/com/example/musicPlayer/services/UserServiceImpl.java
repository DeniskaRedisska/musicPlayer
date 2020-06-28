package com.example.musicPlayer.services;

import com.example.musicPlayer.dao.ModelDao;
import com.example.musicPlayer.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private ModelDao modelDao;

    @Autowired
    public void setModelDao(ModelDao modelDao) {
        this.modelDao = modelDao;
    }


    @Override
    public Iterable<User> getUsers() {
        return modelDao.findAll();
    }

    @Override
    public void addUser(User user) {
        modelDao.save(user);
    }

    @Override
    public void deleteUser(User user) {
        modelDao.delete(user);
    }

    @Override
    public Optional<User> findById(int id) {
       return modelDao.findById(id);
    }

    @Override
    public void edit(User user) {
        modelDao.save(user);
    }


}
