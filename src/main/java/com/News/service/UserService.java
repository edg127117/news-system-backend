package com.News.service;

import com.News.pojo.User;

public interface UserService {

    User findByUsername(final String username);

    void register(final String username, final String password);

    void update(final User user);

    void updateAvatar(final String url);

    void updatePwd(final String newPwd);
}
