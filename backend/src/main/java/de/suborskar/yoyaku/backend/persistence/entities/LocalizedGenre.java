package de.suborskar.yoyaku.backend.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class LocalizedGenre extends LocalizedBaseEntity<Genre>{
    private String name;
}
