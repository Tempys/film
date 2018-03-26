package com.dubovskyi.films.service;

import com.dubovskyi.films.dao.SessionRepository;
import com.dubovskyi.films.domain.EarnsStatisticsDto;
import com.dubovskyi.films.domain.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmStatisticsService {

  private final SessionRepository sessionRepository;

    public FilmStatisticsService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }


    public void calculateBreaks(long cinemaId, LocalDateTime from ,LocalDateTime to){

       List<Session> sessions =  sessionRepository.findByFkCinema(1);

       for(int i = 0;i<sessions.size();i++){


       }
    }


    @Transactional(propagation = Propagation.NESTED)
    public List<EarnsStatisticsDto> getStatisticsByFilmS(){
       return sessionRepository.calculatesEarnsStatistics().stream().map(i -> {
           long sum =   ((BigInteger) i[0]).longValue();
           long cinemaId  = ((Integer) i[1]);
           return new EarnsStatisticsDto(sum,cinemaId,(String) i[2]);
       })
                                                                                                    .collect(Collectors.toList());
    }
}