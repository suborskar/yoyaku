package de.suborskar.yoyaku.backend.persistence.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "booker")
    private Set<Booking> bookings;

    public User(final String email, final String name) {
        this.email = email;
        this.name = name;
    }
}