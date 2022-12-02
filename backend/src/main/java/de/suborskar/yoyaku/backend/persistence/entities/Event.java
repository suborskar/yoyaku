package de.suborskar.yoyaku.backend.persistence.entities;


import de.suborskar.yoyaku.backend.YoyakuConstants;
import lombok.Getter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Table(name = "events")
public class Event extends BaseEntity {
    @OneToMany(mappedBy = "entity", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = true)
    @MapKey(name = "localizedId.locale")
    @Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
    private Map<String, LocalizedEvent> localizations = new HashMap<>();

    @Column(name = "startdate", nullable = false)
    private LocalDate start;

    @Column(name = "enddate", nullable = false)
    private LocalDate end;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private Set<Booking> bookings;

    public String getName(final Locale locale) {
        return localizations.get(locale.getLanguage()).getName();
    }

    public String getDescription(final Locale locale) {
        return localizations.get(locale.getLanguage()).getDescription();
    }

    @Override
    public String toString() {
        return String.format(
                "Event[from='%s', till='%s']", start.format(YoyakuConstants.Time.DATE_FORMATTER), end.format(YoyakuConstants.Time.DATE_FORMATTER));
    }
}
