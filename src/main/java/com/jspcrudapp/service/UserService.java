package com.jspcrudapp.service;


import com.jspcrudapp.dao.UserAccountDao;
import com.jspcrudapp.model.UserAccount;

import java.util.List;

public class UserService implements IUserService {
  private final UserAccountDao userAccountDAO = new UserAccountDao();
  @Override
  public int save(UserAccount userAccount) {
    return userAccountDAO.save(userAccount);
  }

  @Override
  public int update(UserAccount userAccount) {
    return userAccountDAO.update(userAccount);
  }

  @Override
  public UserAccount getById(int id) {
    return userAccountDAO.getById(id);
  }

  @Override
  public List<UserAccount> getAll() {
    return userAccountDAO.getAll();
  }

  @Override
  public int delete(UserAccount userAccount) {
    return userAccountDAO.delete(userAccount);
  }
}
