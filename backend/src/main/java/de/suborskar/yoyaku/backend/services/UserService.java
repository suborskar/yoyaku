package de.suborskar.yoyaku.backend.services;

import de.suborskar.yoyaku.backend.dto.UserDto;
import de.suborskar.yoyaku.backend.persistence.entities.User;

public interface UserService extends CrudService<User, UserDto> {
}
