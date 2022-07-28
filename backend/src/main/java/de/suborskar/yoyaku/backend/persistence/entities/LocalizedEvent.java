package de.suborskar.yoyaku.backend.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class LocalizedEvent extends LocalizedBaseEntity<Event>{
    private String name;
}
