package com.iqmsoft.services;

import lombok.val;

import java.util.UUID;

import com.iqmsoft.domain.User;
import com.iqmsoft.domain.UserList;

import static java.util.Collections.singletonList;

public class UserFactoryImpl implements UserFactory {

  @Override
  public UserList getUsers() {

    val users = singletonList(
        new User().setId(UUID.randomUUID().toString())
                  .setFirstName("Test1")
                  .setLastName("Test2"));

    return new UserList().setUsers(users);
  }
}
