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
    public UserDTO join(UserDTO user) {
        if(umapper.insertUser(user) == 1){
            return umapper.getUser(user.getUserId());
        }
        return null;
    }

    @Override
    public UserDTO login(String userId, String password) {
        UserDTO user = umapper.getUser(userId);
        if(user!=null) {
            if(password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public UserDTO getUser(String userId) {
        return umapper.getUser(userId);
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
