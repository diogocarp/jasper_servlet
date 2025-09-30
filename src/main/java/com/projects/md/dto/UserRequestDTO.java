package com.projects.md.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {

    private String name;
    private String email;
    private String password;
    private String role;
    private Boolean active;
}
