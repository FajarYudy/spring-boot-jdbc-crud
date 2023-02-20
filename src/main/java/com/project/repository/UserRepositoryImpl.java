package com.project.repository;

import com.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fajaryudi
 * @created 2023/02/20 - 10.28
 */
@Repository
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insert(User user) {
        return jdbcTemplate.update("INSERT INTO user (username, full_name, email, password) VALUES(?,?,?,?)",
                new Object[] { user.getUsername(), user.getFullName(), user.getEmail(), user.getPassword() });
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("UPDATE user SET username=?, full_name=?, email=?, password=?  WHERE id=?",
                new Object[] { user.getUsername(), user.getFullName(), user.getEmail(), user.getPassword(), user.getId() });
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM user WHERE id=?", id);
    }

    @Override
    public User findById(Long id) {
        try {
            User user = jdbcTemplate.queryForObject("SELECT * FROM user WHERE id=?",
                    BeanPropertyRowMapper.newInstance(User.class), id);

            return user;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * from user", BeanPropertyRowMapper.newInstance(User.class));
    }
}
