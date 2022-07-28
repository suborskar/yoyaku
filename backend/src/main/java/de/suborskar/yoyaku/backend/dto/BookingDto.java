package de.suborskar.yoyaku.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class BookingDto extends BaseDto{
    private BigDecimal fee;

    private String accommodation;

    private String contact;

    private LocalDateTime start;

    private long duration;

    private UUID band;

    private UUID event;

    private UUID booker;
}
