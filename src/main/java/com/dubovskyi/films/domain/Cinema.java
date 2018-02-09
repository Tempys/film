package com.dubovskyi.films.domain;

import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class Cinema {

    @Id
    private long cinemaId;

    private String name;
    private String address;

    @OneToMany(fetch= FetchType.LAZY)
    @JoinColumn(name = "fk_film")
    private List<Session> sessions;
}
