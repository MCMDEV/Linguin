package de.mcmdev.linguin.api;

import de.mcmdev.linguin.manager.LanguageManager;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffectType;

public class LinguinAPI {

    private final LanguageManager languageManager;

    public LinguinAPI(LanguageManager languageManager) {
        this.languageManager = languageManager;
    }

    /**
     * Gets a raw localized entry based on a key
     *
     * @param locale The locale key to be used
     * @param key The key of the entry that should be localized
     * @return The localized value
     */
    public String getEntry(String locale, String key)   {
        return languageManager.getLocalizedEntry(locale, key);
    }

    /**
     *
     * @param locale The locale key to be used
     * @param material The material of which the name should be localized
     * @return The localized item name
     */
    public String getItemEntry(String locale, Material material)    {
        return getEntry(locale, material.isBlock() ? "block" : "item" + ".minecraft." + material.name().toLowerCase());
    }

    public String getEntityEntry(String locale, EntityType entityType)  {
        return getEntry(locale, "entity.minecraft." + entityType.name().toLowerCase());
    }

    public String getEffectEntry(String locale, PotionEffectType potionEffectType)  {
        return getEntry(locale, "effect.minecraft." + potionEffectType.getName().toLowerCase());
    }
}
