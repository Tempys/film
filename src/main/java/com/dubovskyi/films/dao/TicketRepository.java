package com.dubovskyi.films.dao;

import com.dubovskyi.films.domain.Session;
import com.dubovskyi.films.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    Ticket findOne(Long aLong);
}
