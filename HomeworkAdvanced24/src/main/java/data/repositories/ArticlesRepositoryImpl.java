package data.repositories;

import data.models.Article;
import data.models.NewsResponse;
import data.network.NetworkDownloader;
import data.parsers.BaseParser;
import data.parsers.GsonAppParser;
import data.parsers.XmlAppParser;
import domain.repositories.ArticlesRepository;

import java.util.List;

import static data.utils.Consts.*;

public class ArticlesRepositoryImpl implements ArticlesRepository {

    private final NetworkDownloader downloader;
    private List<Article> listData;

    public ArticlesRepositoryImpl(NetworkDownloader downloader) {
        this.downloader = downloader;

    }

    @Override
    public List<Article> getArticles(String inputFile) {

        BaseParser parser;
        NewsResponse newsResponse;

        switch (inputFile) {
            case "json" -> {

                downloader.downloadFile(JSON_PATH_NAME, JSON_API_URL);
                parser = new GsonAppParser();
                newsResponse = parser.parse(JSON_PATH_NAME);

                listData = newsResponse.getNews();

                return listData;

            }
            case "xml" -> {

                downloader.downloadFile(XML_PATH_NAME, XML_API_URL);
                parser = new XmlAppParser();
                newsResponse = parser.parse(XML_PATH_NAME);

                listData = newsResponse.getNews();

                return listData;

            }
            default -> System.out.println("Неверный ввод, повторите еще раз");
        }

        return listData;
    }

}
