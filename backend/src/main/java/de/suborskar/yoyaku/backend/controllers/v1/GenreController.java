package de.suborskar.yoyaku.backend.controllers.v1;

import de.suborskar.yoyaku.backend.persistence.entities.Genre;
import de.suborskar.yoyaku.backend.services.CrudService;
import de.suborskar.yoyaku.backend.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/genres")
public class GenreController extends AbstractCrudController<Genre> {
    @Autowired
    private GenreService genreService;
    @Override
    protected CrudService<Genre> getService() {
        return genreService;
    }
}
