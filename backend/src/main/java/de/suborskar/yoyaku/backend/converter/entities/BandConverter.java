package de.suborskar.yoyaku.backend.converter.entities;

import de.suborskar.yoyaku.backend.dto.BandDto;
import de.suborskar.yoyaku.backend.persistence.entities.Band;
import de.suborskar.yoyaku.backend.persistence.entities.LocalizedBand;
import org.springframework.stereotype.Component;

@Component
public class BandConverter extends AbstractEntityConverter<Band, BandDto> {

    @Override
    public void convert(final Band source, final BandDto target) {
        target.setUuid(source.getUuid());
        target.setName(source.getName());
        target.setDescription(getLocalizations(source, LocalizedBand::getDescription));
    }

    @Override
    public void reverseConvert(final BandDto source, final Band target) {
    }
}
