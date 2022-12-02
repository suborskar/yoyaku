package de.suborskar.yoyaku.backend.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "genres")
public class Genre extends BaseEntity {
    @OneToMany(mappedBy = "entity", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = true)
    @MapKey(name = "localizedId.locale")
    @Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
    private Map<String, LocalizedGenre> localizations = new HashMap<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "genres")
    private Set<Band> bands;

    public String getName(final Locale locale) {
        return localizations.get(locale.getLanguage()).getName();
    }

    public String getDescription(final Locale locale) {
        return localizations.get(locale.getLanguage()).getDescription();
    }
}