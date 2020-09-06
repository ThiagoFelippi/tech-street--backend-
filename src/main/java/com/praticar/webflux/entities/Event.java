package com.praticar.webflux.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Table("events")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
    @Id
    private Long id;

    @Min(value = 10, message = "Name cannot have less than 10 characters")
    @Max(value = 35, message = "Name cannot have more than 35 characters")
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 10, message = "Description cannot have less than 10 characters")
    @Max(value = 255, message = "Description cannot have more than 255 characters")
    @NotNull(message = "Description cannot be null")
    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotNull(message = "Type cannot be null")
    @NotBlank(message = "Type cannot be blank")
    private String type;

    private int capacity;
    private Tag tags;
}
