package de.suborskar.yoyaku.backend.controllers.v1;

import com.turkraft.springfilter.boot.Filter;
import de.suborskar.yoyaku.backend.dto.BaseDto;
import de.suborskar.yoyaku.backend.persistence.entities.BaseEntity;
import de.suborskar.yoyaku.backend.services.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public abstract class AbstractCrudController<E extends BaseEntity, D extends BaseDto>{
    @GetMapping
    public ResponseEntity<Page<D>> search(
            @Filter final Specification<E> spec,
            final Pageable pageable
    ) {
        final Page<D> list = getService().getAll(spec, pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<D> get(@PathVariable("uuid") final UUID uuid) {
        final D dto = getService().getById(uuid);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<D> save(@RequestBody final D dto) {
        final D savedEntity = getService().insert(dto);
        return new ResponseEntity<>(savedEntity,HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<D> update(@RequestBody final D dto) {
        getService().update(dto);
        return new ResponseEntity<>(getService().getById(dto.getUuid()), HttpStatus.OK);
    }

    @DeleteMapping({"/{uuid}"})
    public ResponseEntity<D> delete(@PathVariable("uuid") final UUID uuid) {
        getService().delete(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    protected abstract CrudService<E, D> getService();
}
