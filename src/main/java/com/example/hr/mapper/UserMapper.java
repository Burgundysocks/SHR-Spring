package com.example.hr.mapper;

import com.example.hr.domain.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    // Create (insert)
    int insertUser(UserDTO user);
    // Read (select)
    UserDTO getUser(String userId);
    // Update
    int updateUser(UserDTO user);
    // Delete
    int deleteUser(String userId);

}

