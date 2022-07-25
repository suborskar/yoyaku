package de.suborskar.yoyaku.backend.persistence.entities;


import lombok.Getter;

import javax.persistence.Column;
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
public class Band extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "genre_affiliation",
            joinColumns = @JoinColumn(name = "band_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
    private Set<Genre> genres;

    @OneToMany(mappedBy = "band", fetch = FetchType.LAZY)
    private Set<Booking> bookings;

    protected Band() {
    }

    public Band(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    public Band(final String name, final String description, final Set<Genre> genres) {
        this(name, description);
        this.genres = genres;
    }

    @Override
    public String toString() {
        return String.format(
                "Band[id=%s, name='%s']",
                getUuid().toString(), name);
    }
}