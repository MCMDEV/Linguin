package de.mcmdev.linguin.api;

import de.mcmdev.linguin.manager.LanguageManager;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
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
     * Gets a localized item name based on a material
     *
     * @param locale The locale key to be used
     * @param material The material of which the name should be localized
     * @return The localized item name
     */
    public String getItemEntry(String locale, Material material)    {
        return getEntry(locale, material.isBlock() ? "block" : "item" + ".minecraft." + material.name().toLowerCase());
    }

    /**
     * Gets a localized entity name based on an entity type
     *
     * @param locale The locale key to be used
     * @param entityType The entity type of which the name should be localized
     * @return The localized entity name
     */
    public String getEntityEntry(String locale, EntityType entityType)  {
        return getEntry(locale, "entity.minecraft." + entityType.name().toLowerCase());
    }

    /**
     * Gets a localized effect name based on a potion effect type
     *
     * @param locale The locale key to be used
     * @param potionEffectType The potion effect type of which the name should be localized
     * @return The localized potion effect name
     */
    public String getEffectEntry(String locale, PotionEffectType potionEffectType)  {
        return getEntry(locale, "effect.minecraft." + potionEffectType.getName().toLowerCase());
    }

    /**
     * Gets a raw localized entry based on a key and player
     *
     * @param player The player whose language should be used
     * @param key The key of the entry that should be localized
     * @return The localized value
     */
    public String getEntry(Player player, String key)   {
        return getEntry(player.getLocale(), key);
    }

    /**
     * Gets a localized item name based on a material and player
     *
     * @param player The player whose language should be used
     * @param material The material of which the name should be localized
     * @return The localized item name
     */
    public String getItemEntry(Player player, Material material)    {
        return getItemEntry(player.getLocale(), material);
    }

    /**
     * Gets a localized entity name based on an entity type and player
     *
     * @param player The player whose language should be used
     * @param entityType The entity type of which the name should be localized
     * @return The localized entity name
     */
    public String getEntityEntry(Player player, EntityType entityType)  {
        return getEntityEntry(player.getLocale(), entityType);
    }

    /**
     * Gets a localized effect name based on a potion effect type and player
     *
     * @param player The player whose language should be used
     * @param potionEffectType The potion effect type of which the name should be localized
     * @return The localized potion effect name
     */
    public String getEffectEntry(Player player, PotionEffectType potionEffectType)  {
        return getEffectEntry(player.getLocale(), potionEffectType);
    }
}
