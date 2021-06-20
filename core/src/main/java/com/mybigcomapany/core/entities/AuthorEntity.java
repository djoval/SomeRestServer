package com.mybigcomapany.core.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mybigcomapany.core.Constants;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "authors")
@EqualsAndHashCode(of = {"id"})
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "day_of_birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_FORMAT)
    private LocalDateTime dayOfBirth;
}
