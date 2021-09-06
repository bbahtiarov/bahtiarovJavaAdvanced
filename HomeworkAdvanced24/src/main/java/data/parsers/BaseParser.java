package data.parsers;

import data.models.NewsResponse;

public interface BaseParser {

    NewsResponse parse(String pathName);

}
