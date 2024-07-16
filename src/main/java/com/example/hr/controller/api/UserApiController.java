package com.example.hr.controller.api;

import com.example.hr.domain.dto.UserDTO;
import com.example.hr.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/user")
@RestController
public class UserApiController {

    @Autowired
    private UserService uservice;

    @PostMapping(value = "/join", consumes = "application/json", produces = "application/json;charset=utf-8")
    public ResponseEntity<UserDTO> join(@RequestBody UserDTO user) {
        UserDTO result = uservice.join(user);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json;charset=utf-8")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO user) {
        UserDTO result = uservice.login(user.getUserId(), user.getPassword());
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    // 비밀번호 변경
    @PutMapping(value = "/update", consumes = "application/json")
    public ResponseEntity<String> update(@RequestBody UserDTO user) {
        boolean result = uservice.update(user);
        if (result) {
            return new ResponseEntity<>("update", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 사용자 삭제
    @DeleteMapping(value = "/delete/{userId}")
    public ResponseEntity<String> delete(@PathVariable String userId) {
        boolean result = uservice.delete(userId);
        if (result) {
            return new ResponseEntity<>("Delete successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Delete failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
