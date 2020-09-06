package com.praticar.webflux.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.sql.RowSet;
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

    private String username;
    private String password;
}
