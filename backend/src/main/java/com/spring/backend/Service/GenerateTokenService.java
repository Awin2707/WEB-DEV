package com.spring.backend.Service;

import com.spring.backend.Interface.GenerateCodeInterface;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GenerateTokenService implements GenerateCodeInterface {
    @Override
    public String GenerateRandomToken(short key) {
        String keys = "Ayusdatu7y81238t185278162378dvavgs7a";
        String result = "";
        for (short i = 0; i < key; i++) {
            Random rand = new Random();
            short randomKes = (short) rand.nextInt(keys.length());
            result += keys.charAt(randomKes);
        }
        return result;
    }
}
