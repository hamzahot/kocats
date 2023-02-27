package com.academy.kocats.security.services;


import com.academy.kocats.dto.user.command.UserCreateDTO;
import com.academy.kocats.entities.User;
import com.academy.kocats.mappers.UserMapper;
import com.academy.kocats.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;



    public void save(UserCreateDTO userCreateDTO) {

        User user = userMapper.toEntity(userCreateDTO);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

    }

}
