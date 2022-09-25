package de.suborskar.yoyaku.backend.persistence.entities;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Getter
@Table(name = "bands")
public class Band extends LocalizedBaseEntity<Band, I18NBand> {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "genre_affiliation",
            joinColumns = @JoinColumn(name = "band_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
    private Set<Genre> genres;

    @OneToMany(mappedBy = "band", fetch = FetchType.LAZY)
    private Set<Booking> bookings;

    @Override
    public String toString() {
        return String.format(
                "Band[id=%s']",
                getUuid().toString());
    }
}