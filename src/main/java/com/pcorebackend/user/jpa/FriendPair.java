package com.pcorebackend.user.jpa;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "friend_pairs")
public class FriendPair {

    @EmbeddedId
    private Key key;

    @ManyToOne
    @MapsId("user1Id")
    @JoinColumn(name = "user1_id", nullable = false)
    private User user1;

    @ManyToOne
    @MapsId("user2Id")
    @JoinColumn(name = "user2_id", nullable = false)
    private User user2;

    protected FriendPair() {
    }

    public FriendPair(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    @Embeddable
    public static class Key implements Serializable {
        @Column(name = "user1_id")
        private UUID user1Id;
        @Column(name = "user2_id")
        private UUID user2Id;

        protected Key() {
        }

        public Key(UUID user1Id, UUID user2Id) {
            this.user1Id = user1Id;
            this.user2Id = user2Id;
        }

        public UUID getUser1Id() {
            return user1Id;
        }

        public void setUser1Id(UUID user1Id) {
            this.user1Id = user1Id;
        }

        public UUID getUser2Id() {
            return user2Id;
        }

        public void setUser2Id(UUID user2Id) {
            this.user2Id = user2Id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return (Objects.equals(user1Id, key.user1Id) && Objects.equals(user2Id, key.user2Id)) ||
                    (Objects.equals(user1Id, key.user2Id) && Objects.equals(user2Id, key.user1Id));
        }

        @Override
        public int hashCode() {
            return Objects.hash(user1Id, user2Id);
        }
    }
}
