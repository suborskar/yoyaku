package de.suborskar.yoyaku.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
public class EventDto extends BaseDto{
    private Map<String, String> name;

    private Map<String, String> description;

    private LocalDate start;

    private LocalDate end;
}
