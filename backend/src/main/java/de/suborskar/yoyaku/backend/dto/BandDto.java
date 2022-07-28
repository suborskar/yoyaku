package de.suborskar.yoyaku.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class BandDto extends BaseDto {
    private String name;

    private String description;

    private List<UUID> genres;
}
