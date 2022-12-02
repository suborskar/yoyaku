package de.suborskar.yoyaku.backend.services.impl;

import de.suborskar.yoyaku.backend.converter.Converter;
import de.suborskar.yoyaku.backend.dto.EventDto;
import de.suborskar.yoyaku.backend.persistence.entities.Event;
import de.suborskar.yoyaku.backend.persistence.repositories.EventRepository;
import de.suborskar.yoyaku.backend.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EventServiceImpl extends AbstractCrudService<Event, EventDto> implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    protected JpaRepository<Event, UUID> getRepository() {
        return eventRepository;
    }

    @Override
    protected JpaSpecificationExecutor<Event> getSpecificationExecutor() {
        return eventRepository;
    }

    @Override
    protected Converter<Event, EventDto> getConverter() {
        return null;
    }

    @Override
    protected EventDto createDto() {
        return new EventDto();
    }

    @Override
    protected Event createEntity() {
        return new Event();
    }
}
