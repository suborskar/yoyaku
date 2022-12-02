package de.suborskar.yoyaku.backend.services.impl;

import de.suborskar.yoyaku.backend.converter.Converter;
import de.suborskar.yoyaku.backend.dto.BookingDto;
import de.suborskar.yoyaku.backend.persistence.entities.Booking;
import de.suborskar.yoyaku.backend.persistence.repositories.BookingRepository;
import de.suborskar.yoyaku.backend.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingServiceImpl extends AbstractCrudService<Booking, BookingDto> implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    protected JpaRepository<Booking, UUID> getRepository() {
        return bookingRepository;
    }

    @Override
    protected JpaSpecificationExecutor<Booking> getSpecificationExecutor() {
        return bookingRepository;
    }

    @Override
    protected Converter<Booking, BookingDto> getConverter() {
        return null;
    }

    @Override
    protected BookingDto createDto() {
        return new BookingDto();
    }

    @Override
    protected Booking createEntity() {
        return new Booking();
    }
}
