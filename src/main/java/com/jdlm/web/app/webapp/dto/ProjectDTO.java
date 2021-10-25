package com.jdlm.web.app.webapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class ProjectDTO {
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Size(max = 15)
    private String name;

    public ProjectDTO() {
    }

    public ProjectDTO(@NotBlank @Size(max = 15) String name) {
        this.name = name;
    }
    
}
