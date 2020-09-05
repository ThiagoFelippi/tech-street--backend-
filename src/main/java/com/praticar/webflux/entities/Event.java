package com.praticar.webflux.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@Table("post")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
    @Id
    private long id;

    private String name;
    private String description;

    private String type;
    private int capacity;
    private List<String> tags;
}
