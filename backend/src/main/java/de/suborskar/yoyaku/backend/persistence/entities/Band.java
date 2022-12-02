package de.suborskar.yoyaku.backend.persistence.entities;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "bands")
public class Band extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "entity", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = true)
    @MapKey(name = "localizedId.locale")
    @Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
    private Map<String, LocalizedBand> localizations = new HashMap<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "genre_affiliation",
            joinColumns = @JoinColumn(name = "band_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
    private Set<Genre> genres;

    @OneToMany(mappedBy = "band", fetch = FetchType.LAZY)
    private Set<Booking> bookings;

    public String getDescription(final Locale locale) {
        return localizations.get(locale.getLanguage()).getDescription();
    }

    @Override
    public String toString() {
        return String.format(
                "Band[id=%s, name='%s']",
                getUuid().toString(), name);
    }
}