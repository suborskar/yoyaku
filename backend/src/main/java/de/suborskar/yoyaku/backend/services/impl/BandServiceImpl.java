package de.suborskar.yoyaku.backend.services.impl;

import de.suborskar.yoyaku.backend.dto.BandDto;
import de.suborskar.yoyaku.backend.dto.BaseDto;
import de.suborskar.yoyaku.backend.persistence.entities.Band;
import de.suborskar.yoyaku.backend.persistence.entities.BaseEntity;
import de.suborskar.yoyaku.backend.persistence.repositories.BandRepository;
import de.suborskar.yoyaku.backend.services.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BandServiceImpl extends AbstractCrudService<Band, BandDto> implements BandService {
    @Autowired
    private BandRepository bandRepository;

    @Override
    protected BandDto mapToDto(final Band entity) {
        return null;
    }

    @Override
    protected Band mapToEntity(final BandDto dto) {
        return null;
    }

    @Override
    protected void mapToEntity(final BandDto dto, final Band entity) {

    }

    @Override
    protected JpaRepository<Band, UUID> getRepository() {
        return bandRepository;
    }

    @Override
    protected JpaSpecificationExecutor<Band> getSpecificationExecutor() {
        return bandRepository;
    }
}
