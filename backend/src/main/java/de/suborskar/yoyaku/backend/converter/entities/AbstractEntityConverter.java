package de.suborskar.yoyaku.backend.converter.entities;

import de.suborskar.yoyaku.backend.converter.Converter;
import de.suborskar.yoyaku.backend.dto.BaseDto;
import de.suborskar.yoyaku.backend.persistence.entities.Band;
import de.suborskar.yoyaku.backend.persistence.entities.BaseEntity;
import de.suborskar.yoyaku.backend.persistence.entities.LocalizedBand;
import de.suborskar.yoyaku.backend.persistence.entities.LocalizedBaseEntity;
import de.suborskar.yoyaku.backend.persistence.helpers.LocalizedId;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class AbstractEntityConverter<S extends BaseEntity, T extends BaseDto> implements Converter<S, T> {
    protected <L extends LocalizedBaseEntity<S>> Map<String, String> getLocalizations(final Band source, final Function<L, String > getter) {
        final Map<String, String> result = new HashMap<>();
        final Map<String, LocalizedBand> localizations = source.getLocalizations();
        for (final String locale : localizations.keySet()) {
            final String value = getter.apply((L) localizations.get(locale));
            result.put(locale, value);
        }
        return  result;
    }

    protected <L extends LocalizedBaseEntity<S>> L getLocalizedEntities(Map<String, L> localizedMap, S entity, String locale, Supplier<L> ctor) {
        L localizedEntity;
        if (localizedMap.containsKey(locale)) {
            localizedEntity = localizedMap.get(locale);
        } else {
            localizedEntity = ctor.get();
            localizedEntity.setLocalizedId(new LocalizedId(locale));
            localizedEntity.setEntity(entity);
            localizedMap.put(locale, localizedEntity);
        }
        return localizedEntity;
    }
}
