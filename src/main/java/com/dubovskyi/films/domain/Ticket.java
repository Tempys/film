package com.dubovskyi.films.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ticket",schema = "films")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;
    private int price;
    private String client;
    @Column(name = "fk_session")
    private long fkSession;
}
