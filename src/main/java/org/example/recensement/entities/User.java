package org.example.recensement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import org.jspecify.annotations.Nullable;
import org.yaml.snakeyaml.Yaml;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @ManyToOne
    private Role role;

    public @Nullable String getPassword() {
        return null;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    public void setUsername(String username) {
    }

    public void setPassword(@Nullable String encode) {
    }

    public void setRole(Role role) {
    }
    // getters/setters
}

