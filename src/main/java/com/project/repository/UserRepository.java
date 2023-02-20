package com.project.repository;

import com.project.model.User;

import java.util.List;

/**
 * @author fajaryudi
 * @created 2023/02/20 - 10.25
 */
public interface UserRepository {
    int insert(User user);
    int update(User user);
    int deleteById(Long id);
    User findById(Long id);
    List<User> findAll();
}
