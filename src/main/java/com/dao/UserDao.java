package com.dao;

import com.model.User;

import java.util.List;

public interface UserDao {

    public List<User> getAll();

    public void save(User user);

    public User get(int id);

    public void update(User user);

    public void delete(int id);

    public List<User> getAll(String firstName);

    public List<User> sort(String sortKey);
}
