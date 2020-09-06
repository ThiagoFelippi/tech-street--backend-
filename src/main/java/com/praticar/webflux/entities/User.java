package com.praticar.webflux.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

<<<<<<< HEAD
import javax.sql.RowSet;
=======
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
>>>>>>> master
import java.io.Serializable;

@Data
@Table("users")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {
    @Id
    private Long id;


    @Min(value = 4, message = "username cannot have less than 4 characters")
    @Max(value = 15, message = "username cannot have more than 15 characters")
    @NotNull(message = "username cannot be null")
    @NotBlank(message = "username cannot be blank")
    private String username;

    @Min(value = 5, message = "password cannot have less than 5 characters")
    @NotNull(message = "password cannot be null")
    @NotBlank(message = "password cannot be blank")
    private String password;
}
