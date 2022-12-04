package de.suborskar.yoyaku.backend.converter.entities;

import de.suborskar.yoyaku.backend.dto.BandDto;
import de.suborskar.yoyaku.backend.persistence.entities.Band;
import de.suborskar.yoyaku.backend.persistence.entities.Genre;
import de.suborskar.yoyaku.backend.persistence.entities.LocalizedBand;
import de.suborskar.yoyaku.backend.persistence.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BandConverter extends AbstractEntityConverter<Band, BandDto> {
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public void convert(final Band source, final BandDto target) {
        target.setUuid(source.getUuid());
        target.setName(source.getName());
        target.setDescription(getLocalizations(source, LocalizedBand::getDescription));
        source.getGenres().stream().map(Genre::getUuid).forEach(target.getGenres()::add);
    }

    @Override
    public void reverseConvert(final BandDto source, final Band target) {
        target.setName(source.getName());
        for (final String locale : source.getDescription().keySet()) {
            final LocalizedBand localizedBand = getLocalizedEntities(target.getLocalizations(), target, locale, LocalizedBand::new);
            localizedBand.setDescription(source.getDescription().get(locale));
        }
        source.getGenres().stream().map(genreRepository::findById).forEach(g -> g.ifPresent(target.getGenres()::add));
    }
}
