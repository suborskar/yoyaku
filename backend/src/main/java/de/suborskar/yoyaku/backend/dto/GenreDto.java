package de.suborskar.yoyaku.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreDto extends BaseDto{
    private String name;

    private String description;
}
