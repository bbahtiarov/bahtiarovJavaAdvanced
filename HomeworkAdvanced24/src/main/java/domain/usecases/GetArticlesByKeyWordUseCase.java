package domain.usecases;

import data.models.Article;
import domain.repositories.ArticlesRepository;

import java.util.ArrayList;
import java.util.List;

public class GetArticlesByKeyWordUseCase {

    private final ArticlesRepository newsResponseRepository;

    public GetArticlesByKeyWordUseCase(ArticlesRepository newsResponseRepository) {
        this.newsResponseRepository = newsResponseRepository;
    }

    public List<Article> execute(String inputFileName, String keyWord) {

        List<Article> outputArticleList = new ArrayList<>();
        List<Article> articles = newsResponseRepository
                .getArticles(inputFileName);

        for (Article article : articles) {
            for (String key : article.getKeywords()) {
                if (key.equals(keyWord)) {

                    outputArticleList.add(article);

                }
            }
        }

        return outputArticleList;

    }
}
