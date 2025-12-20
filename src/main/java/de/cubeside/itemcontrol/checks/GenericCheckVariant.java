package de.cubeside.itemcontrol.checks;

import de.cubeside.itemcontrol.util.ConfigUtil;
import java.util.function.Supplier;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;

public class GenericCheckVariant extends GenericSimpleCheck {
    protected GenericCheckVariant(NamespacedKey key) {
        super(key, true);
    }

    public static Supplier<GenericCheckVariant> createFor(String key) {
        return () -> new GenericCheckVariant(NamespacedKey.fromString(key));
    }

    @Override
    public void loadConfig(ConfigurationSection section) {
        ConfigurationSection data = ConfigUtil.getOrCreateSection(section, "variants");
        allow = ConfigUtil.getOrCreate(data, "allow", defaultValue);
    }
}
