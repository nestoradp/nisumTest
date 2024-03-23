package com.nisum.test.security.application.controller;


import com.nisum.test.common.dto.ErrorCode;
import com.nisum.test.security.application.dto.UserDTO;
import com.nisum.test.security.application.interfaces.IUserService;
import com.nisum.test.security.domain.exception.UserAlreadyExistsException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="security-web/user")
public class UserRestService {

      @Autowired
    private IUserService userService;

     @PostMapping
     public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO) {
         try {
             return ResponseEntity.ok( userService.createUser(userDTO));
         }catch (UserAlreadyExistsException error){
             return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorCode(error.getMessage()));
         }catch (Exception error){
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorCode(error.getMessage()));
         }

     }

}
