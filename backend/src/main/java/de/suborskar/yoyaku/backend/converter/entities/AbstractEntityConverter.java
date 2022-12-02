package de.suborskar.yoyaku.backend.converter.entities;

import de.suborskar.yoyaku.backend.converter.Converter;
import de.suborskar.yoyaku.backend.dto.BaseDto;
import de.suborskar.yoyaku.backend.persistence.entities.Band;
import de.suborskar.yoyaku.backend.persistence.entities.BaseEntity;
import de.suborskar.yoyaku.backend.persistence.entities.LocalizedBand;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class AbstractEntityConverter<S extends BaseEntity, T extends BaseDto> implements Converter<S, T> {
    protected <L> Map<String, String> getLocalizations(final Band source, final Function<L, String > getter) {
        final Map<String, String> result = new HashMap<>();
        final Map<String, LocalizedBand> localizations = source.getLocalizations();
        for (final String locale : localizations.keySet()) {
            final String value = getter.apply((L) localizations.get(locale));
            result.put(locale, value);
        }
        return  result;
    }
}
