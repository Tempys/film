package com.dubovskyi.films.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="session",schema = "films")
public class Session implements Serializable {

    @Id
    private long sessionId;

    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_film")
    private Film film;*/

    private long fkFilm;
    @Column(name = "fk_cinema")
    private long fkCinema;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_session")
    private List<Ticket> tickets;

    private LocalDateTime begin;
    private LocalDateTime endSession;

}
