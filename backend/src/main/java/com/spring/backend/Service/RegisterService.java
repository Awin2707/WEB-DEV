package com.spring.backend.Service;

import com.spring.backend.Entity.UserEntity;
import com.spring.backend.Exception.UserException;
import com.spring.backend.Interface.RegisterInterface;
import com.spring.backend.Modal.RegisterModal;
import com.spring.backend.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService implements RegisterInterface {

    @Autowired private UserRepo userRepo;
    @Autowired private GenerateTokenService tokenService;


    @Override
    public String register(RegisterModal registerModal) {
        String result = "";
        UserEntity user = userRepo.findByEmail(registerModal.getEmail());
        if (user != null){
            throw new UserException("this email id already exists !");
        }else {
            String token = tokenService.GenerateRandomToken((short) 12);
            UserEntity users = new UserEntity(null, registerModal.getEmail(), registerModal.getPass(), token, null,null, false);
            userRepo.save(users);
            return token;
        }
    }
}
