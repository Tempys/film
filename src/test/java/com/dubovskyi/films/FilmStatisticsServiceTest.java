package com.dubovskyi.films;

import com.dubovskyi.films.dao.SessionRepository;
import com.dubovskyi.films.service.FilmStatisticsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class FilmStatisticsServiceTest {

    @Autowired
    private  FilmStatisticsService statisticsService;




    @Test
    public void getStatisticsByFilmTest(){
        System.out.println("statistics: " + statisticsService.getStatisticsByFilmS());

    }
}
