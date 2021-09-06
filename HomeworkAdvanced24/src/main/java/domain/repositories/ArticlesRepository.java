package domain.repositories;

import data.models.Article;

import java.util.List;

public interface ArticlesRepository {

    List<Article> getArticles(String inputFile);

}
