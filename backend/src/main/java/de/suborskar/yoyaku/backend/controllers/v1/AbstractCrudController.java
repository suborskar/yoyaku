package de.suborskar.yoyaku.backend.controllers.v1;

import com.turkraft.springfilter.boot.Filter;
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

public abstract class AbstractCrudController<E extends BaseEntity>{
    @GetMapping
    public ResponseEntity<Page<E>> search(
            @Filter final Specification<E> spec,
            final Pageable pageable
    ) {
        final Page<E> list = getService().getAll(spec, pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<E> get(@PathVariable("uuid") final UUID uuid) {
        final E entity = getService().getById(uuid);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<E> save(@RequestBody final E entity) {
        final E savedEntity = getService().insert(entity);
        return new ResponseEntity<>(savedEntity,HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<E> update(@RequestBody final E entity) {
        getService().update(entity);
        return new ResponseEntity<>(getService().getById(entity.getUuid()), HttpStatus.OK);
    }

    @DeleteMapping({"/{uuid}"})
    public ResponseEntity<E> delete(@PathVariable("uuid") final UUID uuid) {
        getService().delete(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    protected abstract CrudService<E> getService();
}
