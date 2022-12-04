package de.suborskar.yoyaku.backend.persistence.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "bookings")
public class Booking extends BaseEntity {
    @Column(name = "fee")
    private BigDecimal fee;

    @Column(name = "accommodation")
    private String accommodation;

    @Column(name = "contact")
    private String contact;

    @Column(name = "start")
    private LocalDateTime start;

    @Column(name = "duration")
    private long duration;

    @ManyToOne
    @JoinColumn(name = "uuid", nullable = false, insertable = false, updatable = false)
    private Band band;

    @ManyToOne
    @JoinColumn(name = "uuid", nullable = false, insertable = false, updatable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "uuid", nullable = false, insertable = false, updatable = false)
    private User booker;

    public Booking(final BigDecimal fee, final String accommodation, final String contact, final LocalDateTime start, final long duration, final Band band, final Event event, final User booker) {
        this.fee = fee;
        this.accommodation = accommodation;
        this.contact = contact;
        this.start = start;
        this.duration = duration;
        this.band = band;
        this.event = event;
        this.booker = booker;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Booking that = (Booking) o;
        return Objects.equals(getUuid(), that.getUuid())
                && Objects.equals(band, that.band)
                && Objects.equals(event, that.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), band, event);
    }
}