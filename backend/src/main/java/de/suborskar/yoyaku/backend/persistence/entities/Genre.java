package de.suborskar.yoyaku.backend.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "genres")
public class Genre extends LocalizedBaseEntity<Genre, I18NGenre> {
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "genres")
    private Set<Band> bands;
}