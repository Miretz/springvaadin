package com.miretz;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * @author Miretz
 *
 */

@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @RestResource(path = "by-name", rel = "by-name")
    Collection<Reservation> findByReservationName(@Param("rn") String rn);

}
