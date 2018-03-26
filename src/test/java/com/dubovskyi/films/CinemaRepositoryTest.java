package com.dubovskyi.films;


import com.dubovskyi.films.dao.CinemaRepository;
import com.dubovskyi.films.dao.FilmRepository;
import com.dubovskyi.films.dao.SessionRepository;
import com.dubovskyi.films.dao.TicketRepository;
import com.dubovskyi.films.domain.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
//@DataJpaTest(showSql=true)
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class CinemaRepositoryTest {

    @Autowired
    private CinemaRepository repository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private TicketRepository ticketRepository;

    private long beginTime;
    private long endTime;

    @Before
    public void setUp () {
        beginTime = Timestamp.valueOf("2017-01-01 00:00:00").getTime();
        endTime = Timestamp.valueOf("2018-02-12 00:58:00").getTime();
    }


    @Test
    @Transactional(readOnly = true)
    public void cinemaTest(){
       List<Cinema> cinemas = repository.findAll();
      // List<Film> films = filmRepository.findAll();
        System.out.println("cinemas: " +
                ""+cinemas);
       // System.out.println("as"+films);
    }


    @Test
    public void selectMaxBySession(){
      List<Long> sessions = sessionRepository.findNumberSessionPerDay(1);
        System.out.println(sessions);
    }

    @Test
    @Transactional(readOnly = true)
    public void selectSessions(){
       List<Session> sessions  = sessionRepository.findByFkCinema(1);

        System.out.println("sessions: "+ sessions);
    }

    @Test
    @Transactional(readOnly = true)
    public void calculateStatistics(){

        List<Object[]> sessions  = sessionRepository.calculatesEarnsStatistics();

        System.out.println("dtos : "+ sessions);
    }

    @Test
    @Ignore
    //@Transactional
    public void generateCinemas(){

        for(int i =2;i<=10;i++){
               Cinema cinema = new Cinema();
               cinema.setAddress("veshenki"+i);
               cinema.setName("royal"+i);
               cinema.setCinemaId(i);

               repository.save(cinema);
        }


    }

    @Test
    //@Transactional
    public void generateFilms(){

        for(int i =2;i<=10;i++){
           Film film = new Film();
           film.setDuration(100);
           film.setFilmId(i);
           film.setName("fight"+i);

           filmRepository.save(film);
        }


    }

    @Test
    @Ignore
    public void generateSession(){
        for(int i =11;i<=10_000;i++){
           Session session = new Session();


            Instant instant = Instant.ofEpochMilli(getRandomTimeBetweenTwoDates());


            //System.out.println(Instant.ofEpochMilli(Timestamp.valueOf("2017-01-01 00:00:00").getTime()));
            LocalDateTime randomDate = LocalDateTime.ofInstant(instant, ZoneId.of("UTC+03:00"));

           // System.out.println(randomDate);
            System.out.println(randomDate);

            session.setSessionId(i);
            session.setBegin(randomDate);
            session.setEndSession(randomDate.plusHours(2));
            session.setFkCinema(generateRandom(1,10));
            session.setFkFilm(generateRandom(1,10));
            // session.setFkCinema();

            sessionRepository.save(session);

        }


    }

    @Test
    public void generateTicket(){
        for(long i =11;i<=100_000;i++){
            Ticket ticket = new Ticket();
            ticket.setClient("Hanry"+i);
            ticket.setPrice(50);
            ticket.setTicketId(i);
            ticket.setFkSession(generateRandom(1,10_000));

            ticketRepository.save(ticket);


        }
    }



    private long getRandomTimeBetweenTwoDates () {
        long diff = endTime - beginTime + 1;
        return beginTime + (long) (Math.random() * diff);
    }


    private int generateRandom(int min,int max){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min ;
    }





}
