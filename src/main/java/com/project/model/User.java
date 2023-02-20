package com.project.model;

import lombok.Data;

/**
 * @author fajaryudi
 * @created 2023/02/20 - 10.24
 */
@Data
public class User {
    private Long id;
    private String username;
    private String fullName;
    private String email;
    private String password;
}
