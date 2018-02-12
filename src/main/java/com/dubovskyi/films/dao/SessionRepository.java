package com.dubovskyi.films.dao;

import com.dubovskyi.films.domain.Cinema;
import com.dubovskyi.films.domain.EarnsStatisticsDto;
import com.dubovskyi.films.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import java.util.List;
import java.util.stream.Stream;




public interface SessionRepository  extends JpaRepository<Session,Long> {

    @Query(value = "SELECT fk_cinema FROM films.session\n" +
            "where date_trunc('day', begin) = date_trunc('day', end_session)\n" +
            "GROUP by fk_cinema\n" +
            "HAVING count(date_trunc('day', begin)) > ?", nativeQuery = true)
   List<Long> findNumberSessionPerDay(int max);


    List<Session> findByFkCinema(long cinemaId);

    @Query(value="    SELECT\n" +
            "          sum(price),\n" +
            "          count(client),\n" +
            "          'morning' AS period\n" +
            "        FROM films.ticket\n" +
            "        WHERE fk_session IN (SELECT session_id\n" +
            "                             FROM films.session\n" +
            "                             WHERE\n" +
            "                               fk_film = 1 AND EXTRACT(HOUR FROM begin) > 9 AND EXTRACT(HOUR FROM end_session) <= 12)\n" +
            "        UNION\n" +
            "\n" +
            "        SELECT\n" +
            "          sum(price),\n" +
            "          count(client),\n" +
            "          'day' AS period\n" +
            "        FROM films.ticket\n" +
            "        WHERE fk_session IN (SELECT session_id\n" +
            "                             FROM films.session\n" +
            "                             WHERE\n" +
            "                               fk_film = 1 AND EXTRACT(HOUR FROM begin) > 12 AND EXTRACT(HOUR FROM end_session) <= 18)\n" +
            "\n" +
            "        UNION\n" +
            "\n" +
            "        SELECT\n" +
            "          sum(price),\n" +
            "          count(client),\n" +
            "          'evening' AS period\n" +
            "        FROM films.ticket\n" +
            "        WHERE fk_session IN (SELECT session_id\n" +
            "                             FROM films.session\n" +
            "                             WHERE\n" +
            "                               fk_film = 1 AND EXTRACT(HOUR FROM begin) > 18 AND EXTRACT(HOUR FROM end_session) <= 24)\n" +
            "    UNION\n" +
            "\n" +
            "    SELECT\n" +
            "      sum(price),\n" +
            "      count(client),\n" +
            "      'night' AS period\n" +
            "    FROM films.ticket\n" +
            "    WHERE fk_session IN (SELECT session_id\n" +
            "                         FROM films.session\n" +
            "                         WHERE\n" +
            "                           fk_film = 1 AND EXTRACT(HOUR FROM begin) > 24 AND EXTRACT(HOUR FROM end_session) <= 9)", nativeQuery = true)
    List<Object[]> calculatesEarnsStatistics();


}
