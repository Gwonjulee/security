package com.demo.security.entity;

import com.demo.security.domain.CreateUserDto;
import com.demo.security.domain.EncryptionAlgorithm;
import com.demo.security.domain.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", length = 100, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "algorithm")
    @Enumerated(EnumType.STRING)
    private EncryptionAlgorithm algorithm;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.EAGER) //LAZY
    private List<AuthorityEntity> authorities;

    public UserEntity(String username, String password, EncryptionAlgorithm algorithm) {
        this.username = username;
        this.password = password;
        this.algorithm = algorithm;
    }

    public UserDto toUser() {
        return UserDto.builder()
                .username(this.username)
                .password(this.password)
                .algorithm(this.algorithm)
                .authorities(this.authorities.stream().map(AuthorityEntity::toAuthority).toList())
                .build();
    }

    public void replaceAuthority (List<AuthorityEntity> authorities) {
        this.authorities = authorities;
    }

    public static UserEntity newUser(CreateUserDto createUser) {
        return new UserEntity(
                createUser.getUsername(),
                createUser.getPassword(),
                EncryptionAlgorithm.BCRYPT
        );
    }
}
