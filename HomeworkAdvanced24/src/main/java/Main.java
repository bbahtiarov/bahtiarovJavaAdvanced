import domain.BaseParser;
import domain.GsonAppParser;
import domain.XmlAppParser;
import domain.models.Article;
import domain.models.NewsResponse;

import java.util.Comparator;
import java.util.Scanner;

import static data.network.NetworkDownloader.downloadFile;
import static utils.Consts.*;

public class Main {

    public static void main(String[] args) {

        chooseDownloadFile();

    }

    private static void chooseDownloadFile () {

        System.out.println(
                "Выберете какой скачать файл: " + "\n"
                        + "Наберите json, чтобы скачать json файл" + "\n"
                        + "Наберите xml, чтобы скачать xml файл"
        );

        Scanner scanner = new Scanner(System.in);
        String downloadFile = scanner.nextLine();

        switch (downloadFile) {
            case "json" -> {
                downloadFile(JSON_PATH_NAME, JSON_API_URL);
                System.out.println("Файл скачан!");
                break;
            }
            case "xml" -> {
                downloadFile(XML_PATH_NAME, XML_API_URL);
                System.out.println("Файл скачан!");
                break;
            }
            default -> System.out.println("Неверный ввод, повторите еще раз") ;
        }

        chooseOperation(downloadFile);

    }

    private static void chooseOperation(String downloadFile) {

        System.out.println(
                "Выберете возможные действия: " + "\n"
                        + "Нажмите 1, чтобы вывести список" +
                        " всех новостей отсортированных по дате" + "\n"
                        + "Нажмите 2, чтобы сделать поиск" +
                        " по ключевому слову"
        );

        Scanner scanner = new Scanner(System.in);
        String  inputString = scanner.nextLine();

        executeFirstOperation(inputString, downloadFile);
        executeSecondOperation(inputString, downloadFile);

    }

    private static void executeFirstOperation (
            String inputString,
            String downloadFile
    ) {

        NewsResponse newsResponse;
        BaseParser parser;

        if (inputString.equals("1")) {

            switch (downloadFile) {
                case "json" -> {

                    parser = new GsonAppParser();
                    newsResponse = parser.parse(JSON_PATH_NAME);

                    sortNewsResponse(newsResponse);
                    System.out.println(newsResponse.getNews().toString());

                    break;
                }
                case "xml" -> {
                    parser = new XmlAppParser();
                    newsResponse = parser.parse(XML_PATH_NAME);
                    sortNewsResponse(newsResponse);
                    System.out.println(newsResponse.getNews().toString());

                    break;
                }
                default -> System.out.println("Произошла ошибка");

            }
        }
    }

    private static void executeSecondOperation (
            String inputString,
            String downloadFile
    ) {

        NewsResponse newsResponse;
        BaseParser parser;

        if (inputString.equals("2")) {
            System.out.println("Введите ключевое слово");
            Scanner searchScanner = new Scanner(System.in);
            String keyWord = searchScanner.nextLine();

            switch (downloadFile) {
                case "json" -> {
                    parser = new GsonAppParser();
                    newsResponse = parser.parse(JSON_PATH_NAME);

                    getElementOfList(newsResponse, keyWord);

                    break;
                }
                case "xml" -> {
                    parser = new XmlAppParser();
                    newsResponse = parser.parse(XML_PATH_NAME);

                    getElementOfList(newsResponse, keyWord);

                    break;
                }
                default -> System.out.println("Произошла ошибка");
            }

        }
    }

    private static void getElementOfList(NewsResponse newsResponse, String keyWord) {

        for (Article article: newsResponse.getNews()) {
            for (String key: article.getKeywords()){
                if (key.equals(keyWord)) {

                    System.out.println("Новость с этим словом: " + article);

                }
            }
        }

    }

    private static void sortNewsResponse(NewsResponse newsResponse) {

        newsResponse.getNews().sort(new Comparator<Article>() {
            public int compare(Article o1, Article o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });

    }
}
