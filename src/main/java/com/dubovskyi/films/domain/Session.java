package com.dubovskyi.films.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Session {

    @Id
    private long sessionId;

    @OneToOne
    @JoinColumn(name = "fk_film")
    private Film film;
    @OneToMany
    @JoinColumn(name = "fk_ticket")
    private List<Ticket> tickets;

    private LocalDateTime begin;
    private LocalDateTime end;

}
