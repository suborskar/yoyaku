package de.suborskar.yoyaku.backend.persistence.entities;


import de.suborskar.yoyaku.backend.YoyakuConstants;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Table(name = "events")
public class Event extends LocalizedBaseEntity<Event, I18NEvent> {
    @Column(name = "startdate", nullable = false)
    private LocalDate start;

    @Column(name = "enddate", nullable = false)
    private LocalDate end;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private Set<Booking> bookings;

    @Override
    public String toString() {
        return String.format(
                "Event[from='%s', till='%s']", start.format(YoyakuConstants.Time.DATE_FORMATTER), end.format(YoyakuConstants.Time.DATE_FORMATTER));
    }
}
