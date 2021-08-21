package domain.objects;

import domain.exceptions.IlluminanceTooMuchException;
import domain.exceptions.SpaceUsageTooMuchException;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private String buildingName;
    private List<Room> roomList = new ArrayList<>();

    public Building(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void addRoom(Room room) {

        roomList.add(room);

    }

    public void describe() throws IlluminanceTooMuchException, SpaceUsageTooMuchException {

        System.out.println(getBuildingName() + "\n");

        for (Room room : roomList) {

            System.out.println(
                    room.getNameRoom() + "\n"
                            + "Освещенность = " + room.getSumLk()
                            + " ( " + room.getQuantityWindows()
                            + " окна по 700 лк, лампочки: "
            );

            for (Light light : room.getLightList()) {
                System.out.print(
                        light.getLk() + "лк "
                );
            }

            System.out.println(
                    ")" + "\n" +
                            "Площадь = " + room.getSquare() + " м²"
                            + room.getDataSquare() + "\n"
                            + "Мебель: "
            );

            for (Subject subject : room.getSubjectList()) {
                System.out.println(subject.getNameSubject() + " ( площадь "
                        + subject.getSquare() + " м² )");
            }

            System.out.println("\n");

        }

    }
}


