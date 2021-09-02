package domain.usecases;

import data.models.Article;
import domain.repositories.ArticlesRepository;

import java.util.Comparator;
import java.util.List;

public class SortNewsResponseUseCase {

    private final ArticlesRepository newsResponseRepository;

    public SortNewsResponseUseCase(ArticlesRepository newsResponseRepository) {
        this.newsResponseRepository = newsResponseRepository;
    }

    public List<Article> execute(String inputFileName) {

        List<Article> articles = newsResponseRepository.getArticles(inputFileName);

        articles.sort(new Comparator<Article>() {
            public int compare(Article o1, Article o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });

        return articles;

    }

}
