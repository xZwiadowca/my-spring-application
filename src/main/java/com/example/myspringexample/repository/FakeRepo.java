package com.example.myspringexample.repository;

import com.example.myspringexample.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class FakeRepo implements UserAccess{

    @Override
    public List<User> readAllUsers() {

        return Arrays.asList(
                new User("admin", "admin"),
                new User("zenon", "123"),
                new User("olaf", "321")
        );
    }
}
