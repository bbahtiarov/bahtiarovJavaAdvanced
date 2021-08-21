package domain.objects;

import domain.exceptions.IlluminanceTooMuchException;
import domain.exceptions.SpaceUsageTooMuchException;

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

    public int getSumLk() throws IlluminanceTooMuchException {

        int totalSumLk = 0;
        int windowsLk = getQuantityWindows() * 700;

        for (Light sumLight : lightList) {
            totalSumLk = totalSumLk + sumLight.getLk();
        }
        totalSumLk = totalSumLk + windowsLk;

        if (totalSumLk > 4000) {
            throw new IlluminanceTooMuchException();
        }

        return totalSumLk;

    }

    public String getDataSquare() throws SpaceUsageTooMuchException {

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

        if (percentOccupiedSquare > 70) {
            throw new SpaceUsageTooMuchException();
        }

        return "( занято " + sumSubjects + " м²"
                + " гарантированно свободно " + freeSquare + " м²"
                + " или " + percentFreeSquare + " % площади )";

    }

}
