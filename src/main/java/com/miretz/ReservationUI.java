package com.miretz;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;

/**
 * @author Miretz
 *
 */
@SpringUI(path = "ui")
@Theme("valo")
class ReservationUI extends UI {

    private static final long serialVersionUID = -8162118213847385943L;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationUI(final ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    protected void init(final VaadinRequest request) {
        final Grid table = new Grid();
        final BeanItemContainer<Reservation> container = new BeanItemContainer<>(Reservation.class, this.reservationRepository.findAll());
        table.setContainerDataSource(container);
        table.setSizeFull();
        setContent(table);
    }
}
