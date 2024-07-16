package com.example.hr.service.user;

import com.example.hr.domain.dto.UserDTO;

public interface UserService {

    UserDTO join(UserDTO user);

    UserDTO login(String userId, String password);

    UserDTO getUser(String userId);

    boolean update(UserDTO user);//비밀번호만 변경

    boolean delete(String userId);

}
