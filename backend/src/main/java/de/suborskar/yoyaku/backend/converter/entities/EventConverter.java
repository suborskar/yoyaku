package de.suborskar.yoyaku.backend.converter.entities;

import de.suborskar.yoyaku.backend.converter.Converter;
import de.suborskar.yoyaku.backend.dto.EventDto;
import de.suborskar.yoyaku.backend.persistence.entities.Event;
import org.springframework.stereotype.Component;

@Component
public class EventConverter implements Converter<Event, EventDto> {
    @Override
    public void convert(Event source, EventDto target) {

    }

    @Override
    public void reverseConvert(EventDto source, Event target) {

    }
}
