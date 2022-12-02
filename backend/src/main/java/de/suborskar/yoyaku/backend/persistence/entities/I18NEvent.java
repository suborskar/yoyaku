package de.suborskar.yoyaku.backend.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class I18NEvent extends I18NBaseEntity<Event> {
}
