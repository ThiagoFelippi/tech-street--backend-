package com.praticar.webflux.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


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

    private String tagName;
}
