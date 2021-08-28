package domain;

import domain.models.NewsResponse;

public interface BaseParser {

    NewsResponse parse(String pathName);

}
