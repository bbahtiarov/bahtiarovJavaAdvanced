import data.network.NetworkDownloader;
import data.repositories.ArticlesRepositoryImpl;
import domain.usecases.GetArticlesByKeyWordUseCase;
import domain.usecases.LoadNewsResponseUseCase;
import domain.usecases.SortNewsResponseUseCase;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        NetworkDownloader networkDownloader = new NetworkDownloader();
        ArticlesRepositoryImpl repository = new ArticlesRepositoryImpl(networkDownloader);

        chooseDownloadFile();

        Scanner inputFileNameScanner = new Scanner(System.in);
        String inputFileName =  inputFileNameScanner.nextLine();

        downloadFile(inputFileName, repository);

        chooseOperation();

        Scanner inputNumberOperationScanner = new Scanner(System.in);
        String inputNumberOperation =  inputNumberOperationScanner.nextLine();

        executeOperation(inputNumberOperation, inputFileName, repository);

    }

    private static void chooseDownloadFile() {

        System.out.println(
                "Выберете какой скачать файл: " + "\n"
                        + "Наберите json, чтобы скачать json файл" + "\n"
                        + "Наберите xml, чтобы скачать xml файл"
        );

    }

    private static void downloadFile(String inputFileName, ArticlesRepositoryImpl repository) {

        LoadNewsResponseUseCase loadNewsResponseUseCase = new LoadNewsResponseUseCase(repository);
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
            String inputFileName,
            ArticlesRepositoryImpl repository
    ) {

        if (inputNumberOperation.equals("1")) {
            sortNewsResponse(inputFileName, repository);
        }

        if (inputNumberOperation.equals("2")) {

            System.out.println("Введите ключевое слово");
            Scanner searchScanner = new Scanner(System.in);
            String keyWord = searchScanner.nextLine();

            getArticleByKeyWord(inputFileName, keyWord, repository);
        }

    }

    private static void sortNewsResponse(
            String inputFileName,
            ArticlesRepositoryImpl repository
    ) {

        SortNewsResponseUseCase sortNewsResponseUseCase = new SortNewsResponseUseCase(repository);
        System.out.println(sortNewsResponseUseCase.execute(inputFileName));

    }

    private static void getArticleByKeyWord(
            String inputFileName,
            String keyWord,
            ArticlesRepositoryImpl repository
    ) {

        GetArticlesByKeyWordUseCase getArticleByKeyWordUseCase = new GetArticlesByKeyWordUseCase(repository);

        System.out.println("Новости с ключевым словом: ");
        System.out.println(getArticleByKeyWordUseCase.execute(inputFileName, keyWord));

    }

}
