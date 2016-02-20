package com.miretz;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Miretz
 *
 */
@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    private String reservationName;

    public Reservation(final String reservationName) {
        super();
        this.reservationName = reservationName;
    }

    Reservation() {
        // Empty
    }

    public Long getId() {
        return id;
    }

    public String getReservationName() {
        return reservationName;
    }

}
