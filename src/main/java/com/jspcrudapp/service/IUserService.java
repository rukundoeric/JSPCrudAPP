package com.jspcrudapp.service;


import com.jspcrudapp.model.UserAccount;

import java.util.List;

public interface IUserService {
  int save(UserAccount userAccount);
  int update(UserAccount userAccount);
  UserAccount getById(int id);
  List<UserAccount> getAll();
  int delete(UserAccount userAccount);
}
