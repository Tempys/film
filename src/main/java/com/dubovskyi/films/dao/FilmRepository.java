package com.dubovskyi.films.dao;

import com.dubovskyi.films.domain.Cinema;
import com.dubovskyi.films.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,Long> {


}
