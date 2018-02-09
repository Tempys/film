package com.dubovskyi.films.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Film {
    @Id
    private long filmId;
    private String name;
    private int duration;
}
