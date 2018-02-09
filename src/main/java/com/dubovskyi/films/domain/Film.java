package com.dubovskyi.films.domain;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Film {
    @Id
    private long filmId;
    private String name;
    private int duration;
}
