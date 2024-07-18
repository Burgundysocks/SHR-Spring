package com.example.hr.controller.api;

import com.example.hr.domain.dto.UserDTO;
import com.example.hr.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/api/user")
@RestController
public class UserApiController {

    @Autowired
    private UserService uservice;

    @PostMapping(value = "/join", consumes = "application/json", produces = "application/json;charset=utf-8")
    public ResponseEntity<?> join(@Valid @RequestBody UserDTO user, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        UserDTO joinedUser = uservice.join(user);
        if (joinedUser == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(joinedUser, HttpStatus.OK);
        }
    }



    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json;charset=utf-8")
    public ResponseEntity<?> login(@Valid @RequestBody UserDTO user, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        UserDTO loggedInUser = uservice.login(user.getUserId(), user.getPassword());
        if (loggedInUser == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/update", consumes = "application/json")
    public ResponseEntity<?> update(@Valid @RequestBody UserDTO user, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        boolean updateResult = uservice.update(user);
        if (updateResult) {
            return new ResponseEntity<>("Update successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Update failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{userId}")
    public ResponseEntity<String> delete(@PathVariable String userId) {
        boolean deleteResult = uservice.delete(userId);
        if (deleteResult) {
            return new ResponseEntity<>("Delete successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Delete failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
