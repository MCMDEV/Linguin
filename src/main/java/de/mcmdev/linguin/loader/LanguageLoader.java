package de.mcmdev.linguin.loader;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class LanguageLoader {

    private final File languageFolder;
    private final Map<String, JSONObject> languageJsonObjectMap = new HashMap<>();

    public LanguageLoader(File languageFolder) {
        this.languageFolder = languageFolder;
    }

    private File getFile(String languageName)   {
        return new File(languageFolder, languageName + ".json");
    }

    @SneakyThrows
    private JSONObject getJsonObject(File file)  {
        String s = FileUtils.readFileToString(file, Charset.defaultCharset());
        return new JSONObject(s);
    }

    public String loadEntry(String languageName, String key)    {
        JSONObject jsonObject;
        jsonObject = languageJsonObjectMap.computeIfAbsent(key, s -> {
            File file = getFile(languageName);
            return getJsonObject(file);
        });
        return jsonObject.getString(key);
    }

}
