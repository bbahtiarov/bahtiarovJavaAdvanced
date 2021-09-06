import data.network.NetworkDownloader;
import data.parsers.BaseParser;
import data.parsers.GsonAppParser;
import data.parsers.XmlAppParser;
import data.repositories.ArticlesRepositoryImpl;
import domain.usecases.GetArticlesByKeyWordUseCase;
import domain.usecases.LoadNewsResponseUseCase;
import domain.usecases.SortNewsResponseUseCase;

import java.util.Scanner;

public class Main {
    
    static NetworkDownloader networkDownloader = new NetworkDownloader();

    static BaseParser parser;
    static ArticlesRepositoryImpl repository;

    static LoadNewsResponseUseCase loadNewsResponseUseCase;
    static SortNewsResponseUseCase sortNewsResponseUseCase;
    static GetArticlesByKeyWordUseCase getArticleByKeyWordUseCase;


    public static void main(String[] args) {

        chooseDownloadFile();

        Scanner inputFileNameScanner = new Scanner(System.in);
        String inputFileName =  inputFileNameScanner.nextLine();

        initFields(inputFileName);
        downloadFile(inputFileName, repository);

        chooseOperation();

        Scanner inputNumberOperationScanner = new Scanner(System.in);
        String inputNumberOperation =  inputNumberOperationScanner.nextLine();

        executeOperation(inputNumberOperation, inputFileName);

    }

    private static void initFields(String inputFileName) {

        if (inputFileName.equals("json")) parser = new GsonAppParser();
        if (inputFileName.equals("xml")) parser = new XmlAppParser();

        repository = new ArticlesRepositoryImpl(networkDownloader, parser);
        loadNewsResponseUseCase = new LoadNewsResponseUseCase(repository);
        sortNewsResponseUseCase = new SortNewsResponseUseCase(repository);
        getArticleByKeyWordUseCase = new GetArticlesByKeyWordUseCase(repository);

    }

    private static void chooseDownloadFile() {

        System.out.println(
                "Выберете какой скачать файл: " + "\n"
                        + "Наберите json, чтобы скачать json файл" + "\n"
                        + "Наберите xml, чтобы скачать xml файл"
        );

    }

    private static void downloadFile(String inputFileName, ArticlesRepositoryImpl repository) {

        loadNewsResponseUseCase.execute(inputFileName);
        System.out.println("Файл скачан!");

    }

    private static void chooseOperation() {

        System.out.println(
                "Выберете возможные действия: " + "\n"
                        + "Нажмите 1, чтобы вывести список" +
                        " всех новостей отсортированных по дате" + "\n"
                        + "Нажмите 2, чтобы сделать поиск" +
                        " по ключевому слову"
        );

    }

    private static void executeOperation(
            String inputNumberOperation,
            String inputFileName
    ) {

        if (inputNumberOperation.equals("1")) {
            sortNewsResponse(inputFileName);
        }

        if (inputNumberOperation.equals("2")) {

            System.out.println("Введите ключевое слово");
            Scanner searchScanner = new Scanner(System.in);
            String keyWord = searchScanner.nextLine();

            getArticleByKeyWord(inputFileName, keyWord);
        }

    }

    private static void sortNewsResponse(String inputFileName) {

        System.out.println(sortNewsResponseUseCase.execute(inputFileName));

    }

    private static void getArticleByKeyWord(
            String inputFileName,
            String keyWord
    ) {

        System.out.println("Новости с ключевым словом: ");
        System.out.println(getArticleByKeyWordUseCase.execute(inputFileName, keyWord));

    }

}
