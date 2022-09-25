package de.suborskar.yoyaku.backend.persistence.entities;

import de.suborskar.yoyaku.backend.persistence.helpers.LocalizedId;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.MapsId;

@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Getter
@Setter
@MappedSuperclass
public abstract class I18NBaseEntity<E extends BaseEntity> {
    @EmbeddedId
    private LocalizedId localizedId;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id")
    private E entity;

    private String name;

    private String description;
}
