package de.suborskar.yoyaku.backend.converter.entities;

import de.suborskar.yoyaku.backend.converter.Converter;
import de.suborskar.yoyaku.backend.dto.UserDto;
import de.suborskar.yoyaku.backend.persistence.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<User, UserDto> {
    @Override
    public void convert(User source, UserDto target) {

    }

    @Override
    public void reverseConvert(UserDto source, User target) {

    }
}
