package com.jdlm.web.app.webapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class RoleDto {
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Size(max = 15)
    private String name;

    public RoleDto() {
    } 

    public RoleDto(@NotBlank @Size(max = 15) String name) {
        this.name = name;
    }  

}
