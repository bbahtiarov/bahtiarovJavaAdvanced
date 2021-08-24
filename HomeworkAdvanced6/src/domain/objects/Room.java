package domain.objects;

import domain.utils.Const;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String nameRoom;
    private int quantityWindows;
    private int square;

    private List<Subject> subjectList = new ArrayList<>();
    private List<Light> lightList = new ArrayList<>();

    public Room(String nameRoom, int quantityWindows, int square) {
        this.nameRoom = nameRoom;
        this.quantityWindows = quantityWindows;
        this.square = square;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public List<Light> getLightList() {
        return lightList;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public int getQuantityWindows() {
        return quantityWindows;
    }

    public int getSquare() {
        return square;
    }

    public void addLight(Light light) {

        lightList.add(light);

    }

    public void addSubject(Subject subject) {

        subjectList.add(subject);

    }

    public int getSumLk() {

        int totalSumLk = 0;
        int windowsLk = getQuantityWindows() * Const.WINDOW_LK;

        for (Light sumLight : lightList) {
            totalSumLk = totalSumLk + sumLight.getLk();
        }
        totalSumLk = totalSumLk + windowsLk;

        return totalSumLk;

    }

    public int getPercentOccupiedSquare() {
        int sumSubjects = 0;
        int percentOccupiedSquare;

        for (Subject subject : subjectList) {
            sumSubjects += subject.getSquare();
        }

        percentOccupiedSquare = (sumSubjects * 100) / getSquare();

        return percentOccupiedSquare;
    }

    public String getDataSquare() {

        int sumSubjects = 0;
        int freeSquare;
        int percentOccupiedSquare;
        int percentFreeSquare;

        for (Subject subject : subjectList) {
            sumSubjects += subject.getSquare();
        }

        freeSquare = getSquare() - sumSubjects;
        percentOccupiedSquare = (sumSubjects * 100) / getSquare();
        percentFreeSquare = 100 - percentOccupiedSquare;

        return "( занято " + sumSubjects + " м²"
                + " гарантированно свободно " + freeSquare + " м²"
                + " или " + percentFreeSquare + " % площади )";

    }

}
