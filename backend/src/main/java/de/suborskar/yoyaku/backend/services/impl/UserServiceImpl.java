package de.suborskar.yoyaku.backend.services.impl;

import de.suborskar.yoyaku.backend.dto.UserDto;
import de.suborskar.yoyaku.backend.persistence.entities.User;
import de.suborskar.yoyaku.backend.persistence.repositories.UserRepository;
import de.suborskar.yoyaku.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl extends AbstractCrudService<User, UserDto> implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    protected UserDto mapToDto(User entity) {
        return null;
    }

    @Override
    protected User mapToEntity(UserDto dto) {
        return null;
    }

    @Override
    protected void mapToEntity(UserDto dto, User entity) {

    }

    @Override
    protected JpaRepository<User, UUID> getRepository() {
        return userRepository;
    }

    @Override
    protected JpaSpecificationExecutor<User> getSpecificationExecutor() {
        return userRepository;
    }
}
