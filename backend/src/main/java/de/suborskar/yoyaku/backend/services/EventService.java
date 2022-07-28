package de.suborskar.yoyaku.backend.services;

import de.suborskar.yoyaku.backend.dto.EventDto;
import de.suborskar.yoyaku.backend.persistence.entities.Event;

public interface EventService extends CrudService<Event, EventDto> {
}
