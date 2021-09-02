package domain.objects;

public class Subject {

    private String nameSubject;
    private int square;

    public String getNameSubject() {
        return nameSubject;
    }

    public int getSquare() {
        return square;
    }

    public Subject(String nameSubject, int square) {
        this.nameSubject = nameSubject;
        this.square = square;
    }

}
