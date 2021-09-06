package data.parsers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.models.NewsResponse;
import data.dateAdapters.DateJsonDeserializer;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class GsonAppParser implements BaseParser {

    @Override
    public NewsResponse parse(String pathName) {

        DateJsonDeserializer dateDeserializer = new DateJsonDeserializer();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, dateDeserializer).create();

        try (FileReader fileReader = new FileReader(pathName)){

            return gson.fromJson(fileReader, NewsResponse.class);

        } catch (IOException e) {
            System.out.println("Parsing error: " + e.toString());
        }

        return null;
    }

}
