package de.suborskar.yoyaku.backend.converter.entities;

import de.suborskar.yoyaku.backend.converter.Converter;
import de.suborskar.yoyaku.backend.dto.BookingDto;
import de.suborskar.yoyaku.backend.persistence.entities.Band;
import de.suborskar.yoyaku.backend.persistence.entities.Booking;
import de.suborskar.yoyaku.backend.persistence.entities.Event;
import de.suborskar.yoyaku.backend.persistence.entities.User;
import de.suborskar.yoyaku.backend.persistence.repositories.BandRepository;
import de.suborskar.yoyaku.backend.persistence.repositories.EventRepository;
import de.suborskar.yoyaku.backend.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookingConverter implements Converter<Booking, BookingDto> {
    @Autowired
    private BandRepository bandRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;
    @Override
    public void convert(final Booking source, final BookingDto target) {
        target.setUuid(source.getUuid());
        target.setContact(source.getContact());
        target.setContact(source.getContact());
        target.setFee(source.getFee());
        target.setStart(source.getStart());
        target.setDuration(source.getDuration());
        Optional.ofNullable(source.getBand()).map(Band::getUuid).ifPresent(target::setBand);
        Optional.ofNullable(source.getBooker()).map(User::getUuid).ifPresent(target::setBooker);
        Optional.ofNullable(source.getEvent()).map(Event::getUuid).ifPresent(target::setEvent);
    }

    @Override
    public void reverseConvert(final BookingDto source, final Booking target) {
        target.setContact(source.getContact());
        target.setContact(source.getContact());
        target.setFee(source.getFee());
        target.setStart(source.getStart());
        target.setDuration(source.getDuration());
        if (source.getBand() != null) {
            bandRepository.findById(source.getBand()).ifPresent(target::setBand);
        }
        if (source.getBooker() != null) {
            userRepository.findById(source.getBooker()).ifPresent(target::setBooker);
        }
        if (source.getEvent() != null) {
            eventRepository.findById(source.getEvent()).ifPresent(target::setEvent);
        }
    }
}
