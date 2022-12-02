package de.suborskar.yoyaku.backend.persistence.entities;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.CascadeType;
import javax.persistence.MapKey;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@MappedSuperclass
public class LocalizedBaseEntity<E extends BaseEntity, I extends I18NBaseEntity<E>> extends BaseEntity {
    @OneToMany(mappedBy = "entity", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = true)
    @MapKey(name = "localizedId.locale")
    @Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
    private Map<String, I> localizations = new HashMap<>();

    public String getName(final Locale locale) {
        return localizations.get(locale.getLanguage()).getName();
    }

    public Map<String, String> getName() {
        return localizations.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().getName()));
    }

    public String getDescription(final Locale locale) {
        return localizations.get(locale.getLanguage()).getDescription();
    }

    public Map<String, String> getDescription() {
        return localizations.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().getDescription()));
    }

    public Map<String, I> getLocalizations() {
        return localizations;
    }
}
