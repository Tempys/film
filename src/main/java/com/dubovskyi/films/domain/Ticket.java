package com.dubovskyi.films.domain;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Ticket {

    @Id
    private long ticketId;
    private Session session;
    private int price;
    private String client;
}
