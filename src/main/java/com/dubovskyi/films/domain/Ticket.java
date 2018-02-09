package com.dubovskyi.films.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Ticket {

    @Id
    private long ticketId;
    private int price;
    private String client;
}
