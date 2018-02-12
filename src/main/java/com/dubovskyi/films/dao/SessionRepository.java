package com.dubovskyi.films.dao;

import com.dubovskyi.films.domain.Cinema;
import com.dubovskyi.films.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SessionRepository  extends JpaRepository<Session,Long> {

    @Query(value = "SELECT fk_cinema FROM films.session\n" +
            "where date_trunc('day', begin) = date_trunc('day', end_session)\n" +
            "GROUP by fk_cinema\n" +
            "HAVING count(date_trunc('day', begin)) > ?", nativeQuery = true)
   List<Long> findNumberSessionPerDay(int max);


    List<Session> findByFkCinema(long cinemaId);
}
