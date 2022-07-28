package de.suborskar.yoyaku.backend.services;

import de.suborskar.yoyaku.backend.dto.BookingDto;
import de.suborskar.yoyaku.backend.persistence.entities.Booking;

public interface BookingService extends CrudService<Booking, BookingDto> {
}
