package de.suborskar.yoyaku.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EventDto extends BaseDto{
    private String name;

    private String description;

    private LocalDate start;

    private LocalDate end;
}
