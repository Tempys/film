package com.dubovskyi.films.service;


import com.dubovskyi.films.dao.CinemaRepository;
import com.dubovskyi.films.dao.SessionRepository;
import com.dubovskyi.films.dao.TicketRepository;
import com.dubovskyi.films.domain.Cinema;
import com.dubovskyi.films.domain.Session;
import com.dubovskyi.films.domain.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Service
public class ReservationService {

    private final CinemaRepository cinemaRepository;
    private final SessionRepository sessionRepository;
    private final TicketRepository ticketRepository;
    @Autowired
    private ReservationService service;

    public ReservationService(CinemaRepository repository, SessionRepository sessionRepository, TicketRepository ticketRepository) {
        this.cinemaRepository = repository;
        this.sessionRepository = sessionRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional
    public void reserveTickets(int cinemaId, int sessionId, String client) throws Exception {

        service.createTicket(client,sessionId);
        service.updateReserveCount(sessionId);

      //  throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createTicket(String client, long sessionId){
        Ticket ticket = new Ticket();
        ticket.setPrice(100);
        ticket.setClient(client);
        ticket.setFkSession(sessionId);

        ticketRepository.save(ticket);

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateReserveCount(long sessionId) throws Exception {
        Session session = sessionRepository.findOne(sessionId);

        long count = session.getReserveCount()+1;
        session.setReserveCount(count);

        sessionRepository.save(session);
       // throw new RuntimeException();

    }

}
