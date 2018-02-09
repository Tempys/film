package com.dubovskyi.films.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Session {

    @Id
    private long sessionId;

    @ManyToOne
    private Cinema cinema;

    @OneToOne
    @JoinColumn(name = "fk_film")
    private Film film;
    @OneToMany
   // @JoinColumn(name = "fk_ticket")
    private List<Ticket> tickets;

    private LocalDateTime begin;
    private LocalDateTime end;

}
