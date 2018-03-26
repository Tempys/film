package com.dubovskyi.films.web;


import com.dubovskyi.films.service.ReservationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping("/reserve")
    public void reserve() throws Exception {
        reservationService.reserveTickets(1,1,"Stnasas");
    }
}
