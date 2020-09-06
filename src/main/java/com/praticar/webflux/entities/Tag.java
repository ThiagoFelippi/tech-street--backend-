package com.praticar.webflux.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


// Just admins will have access to create tags //
@Data
@Table("tags")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag {
    @Id
    private Integer id;

    @Max(value = 20, message = "tagName cannot have more than 20 characters")
    private String tagName;
}
