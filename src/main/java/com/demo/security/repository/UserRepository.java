package com.demo.security.repository;

import com.demo.security.domain.CreateUserDto;
import com.demo.security.domain.UserDto;
import com.demo.security.entity.AuthorityEntity;
import com.demo.security.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class UserRepository{
    private final UserJpaRepository userJpaRepository;
    private final AuthorityJpaRepository authorityJpaRepository;

    @Transactional(readOnly = true)
    public Boolean userExits(String username) {
        return userJpaRepository.findByUsername(username).isPresent();
    }

    @Transactional
    public UserDto createUser(CreateUserDto createUserDto) {
        UserEntity userEntity = userJpaRepository.save(UserEntity.newUser(createUserDto));
        AuthorityEntity authorityEntity = authorityJpaRepository.save(new AuthorityEntity("READ", userEntity));
        userEntity.replaceAuthority(List.of(authorityEntity));

        return userEntity.toUser();
    }

    @Transactional(readOnly = true)
    public UserDto getUserByUsername(String username) {
        return userJpaRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username))
                .toUser();
    }

}
