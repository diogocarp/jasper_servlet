package com.projects.md.enums;

import lombok.Getter;

@Getter
public enum Roles {
    USER("USER"),
    MODERATOR("MODERATOR"),
    ADMIN("ADMIN");

    private final String role;

    Roles(String role){
        this.role = role;
    }
}

