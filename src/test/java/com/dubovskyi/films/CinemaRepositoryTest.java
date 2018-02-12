package com.dubovskyi.films;


import com.dubovskyi.films.dao.CinemaRepository;
import com.dubovskyi.films.dao.FilmRepository;
import com.dubovskyi.films.dao.SessionRepository;
import com.dubovskyi.films.domain.Cinema;
import com.dubovskyi.films.domain.Film;
import com.dubovskyi.films.domain.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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



}
