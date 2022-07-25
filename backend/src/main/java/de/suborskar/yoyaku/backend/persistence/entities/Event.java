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
public class Event extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "startdate", nullable = false)
    private LocalDate start;

    @Column(name = "enddate", nullable = false)
    private LocalDate end;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private Set<Booking> bookings;

    protected Event() {
    }

    public Event(final String name, final String description, final LocalDate start, final LocalDate end) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return String.format(
                "Event[name='%s', from='%s', till='%s']", name, start.format(YoyakuConstants.Time.DATE_FORMATTER), end.format(YoyakuConstants.Time.DATE_FORMATTER));
    }
}
