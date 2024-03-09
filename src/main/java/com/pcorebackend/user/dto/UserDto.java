package com.pcorebackend.user.dto;

import java.time.Instant;
import java.util.UUID;

public record UserDto(UUID id, String username, Instant joinedAt) {
}
