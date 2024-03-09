package com.pcorebackend.user.jpa;

import com.pcorebackend.user.dto.UserDto;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "users", indexes = {
        @Index(name = "users__index_name", columnList = "username")
})
public class User {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Column(name = "id")
    private UUID id;

    @Column(name = "username")
    private String username;

    @Column(name = "joined_at")
    @CreationTimestamp
    private Instant joinedAt;

    protected User() {
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public UUID getId() {
        return id;
    }

    public Instant getJoinedAt() {
        return joinedAt;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserDto toDto() {
        return new UserDto(id, username, joinedAt);
    }
}
