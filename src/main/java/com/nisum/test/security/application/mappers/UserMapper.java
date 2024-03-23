package com.nisum.test.security.application.mappers;

import com.nisum.test.security.application.dto.UserBasicDTO;
import com.nisum.test.security.application.dto.UserDTO;
import com.nisum.test.security.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;


@Component
public class UserMapper {

   @Autowired
    private PhoneMapper phoneMapper;

   public User convertFromDTO(UserDTO userDTO){
       User user = new User();
       user.setId(userDTO.getId());
       user.setName(userDTO.getName());
       user.setEmail(userDTO.getEmail());
       user.setPassword(userDTO.getPassword());
       user.setActive(userDTO.isActive());
       user.setLastLogin(new Date());
       user.setCreatedAt(new Date());
       user.setUpdatedAt(new Date());
       user.setToken(userDTO.getToken());
       if(userDTO.getPhones() != null){
       user.setPhones(phoneMapper.convertFromDTO(userDTO.getPhones()));
         }
       return user;
   }

   public UserDTO convertToDTO(User user){
       UserDTO userDTO = new UserDTO();
       userDTO.setId(user.getId());
       userDTO.setName(user.getName());
       userDTO.setEmail(user.getEmail());
       userDTO.setPassword(user.getPassword());
       userDTO.setActive(user.isActive());
       if(user.getPhones() != null){
       userDTO.setPhones(phoneMapper.convertToDTO(user.getPhones()));
       }
       return userDTO;
   }

   public UserBasicDTO convertToBasicDTO(User user){
       UserBasicDTO userDTO = new UserBasicDTO();
       userDTO.setId(user.getId());
       userDTO.setCreatedAt(user.getCreatedAt());
       userDTO.setUpdatedAt(user.getUpdatedAt());
       userDTO.setLastLogin(user.getLastLogin());
       userDTO.setToken(user.getToken());
       userDTO.setActive(user.isActive());
       return userDTO;
   }




}
