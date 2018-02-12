package com.dubovskyi.films.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="film",schema = "films")
public class Film {
    @Id
    private long filmId;
    private String name;
    private int duration;
}
