package de.suborskar.yoyaku.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto extends BaseDto{
    private String email;

    private String name;
}
