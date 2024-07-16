package com.example.hr.service.user;

import com.example.hr.domain.dto.UserDTO;
import com.example.hr.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper umapper;

    @Override
    public boolean join(UserDTO user) {
        return umapper.insertUser(user) == 1;
    }

    @Override
    public boolean login(String userId, String password) {
        UserDTO user = umapper.getUser(userId);
        if(user!=null) {
            if(password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(UserDTO user) {
        return umapper.updateUser(user) == 1;
    }

    @Override
    public boolean delete(String userId) {
        return umapper.deleteUser(userId) == 1;
    }

}
