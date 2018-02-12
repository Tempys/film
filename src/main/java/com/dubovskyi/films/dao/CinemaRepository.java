package com.dubovskyi.films.dao;

import com.dubovskyi.films.domain.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository  extends JpaRepository<Cinema,Long> {


}
