package de.suborskar.yoyaku.backend.converter.entities;

import de.suborskar.yoyaku.backend.converter.Converter;
import de.suborskar.yoyaku.backend.dto.BookingDto;
import de.suborskar.yoyaku.backend.persistence.entities.Booking;
import org.springframework.stereotype.Component;

@Component
public class BookingConverter implements Converter<Booking, BookingDto> {
    @Override
    public void convert(Booking source, BookingDto target) {

    }

    @Override
    public void reverseConvert(BookingDto source, Booking target) {

    }
}
