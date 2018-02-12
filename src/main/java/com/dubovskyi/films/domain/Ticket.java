package com.dubovskyi.films.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="ticket",schema = "films")
public class Ticket {

    @Id
    private long ticketId;
    private int price;
    private String client;
}
