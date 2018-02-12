package com.dubovskyi.films.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="cinema",schema = "films")
public class Cinema implements Serializable{

    @Id
    private long cinemaId;
    private String name;
    private String address;

    @OneToMany(fetch= FetchType.LAZY)
    @JoinColumn(name = "fk_cinema")
    private List<Session> sessions = new ArrayList<>();

}
