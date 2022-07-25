package de.suborskar.yoyaku.backend.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public abstract class BaseDto {
    private UUID uuid;

    private LocalDateTime createDateTime;

    private LocalDateTime updateDateTime;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BaseDto that = (BaseDto) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return "BaseDto{" +
                "id=" + uuid +
                '}';
    }
}
