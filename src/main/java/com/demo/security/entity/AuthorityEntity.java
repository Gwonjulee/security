package com.demo.security.entity;

import com.demo.security.domain.AuthorityDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "authorities")
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "userEntity")
    @ManyToOne
    private UserEntity userEntity;

    public AuthorityEntity(String name, UserEntity userEntity) {
        this.name = name;
        this.userEntity = userEntity;
    }

    public AuthorityDto toAuthority() {
        return AuthorityDto.builder()
                .name(this.name)
                .build();
    }
}
