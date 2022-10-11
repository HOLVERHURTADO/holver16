package com.holverReto3.reto3.repository.crud;

import org.springframework.data.repository.CrudRepository;

import com.holverReto3.reto3.model.Reservation;

public interface ReservationCrudRepository extends CrudRepository <Reservation, Integer>{
    
}
