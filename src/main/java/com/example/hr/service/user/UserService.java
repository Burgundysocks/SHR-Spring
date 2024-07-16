package com.example.hr.service.user;

import com.example.hr.domain.dto.UserDTO;

public interface UserService {

    boolean join(UserDTO user);

    boolean login(String userId, String password);

    boolean update(UserDTO user);//비밀번호만 변경

    boolean delete(String userId);

}
