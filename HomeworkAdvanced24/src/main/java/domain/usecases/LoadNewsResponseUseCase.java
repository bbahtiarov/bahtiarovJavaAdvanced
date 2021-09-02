package domain.usecases;

import data.models.Article;
import domain.repositories.ArticlesRepository;

import java.util.List;

public class LoadNewsResponseUseCase {

    private final ArticlesRepository newsResponseRepository;

    public LoadNewsResponseUseCase(ArticlesRepository newsResponseRepository) {
        this.newsResponseRepository = newsResponseRepository;
    }

    public List<Article> execute(String inputFileName) {
        return newsResponseRepository.getArticles(inputFileName);
    }

}
