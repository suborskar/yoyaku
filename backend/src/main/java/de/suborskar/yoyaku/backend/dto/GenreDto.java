package de.suborskar.yoyaku.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class GenreDto extends BaseDto{
    private Map<String, String> name;

    private Map<String, String> description;
}
