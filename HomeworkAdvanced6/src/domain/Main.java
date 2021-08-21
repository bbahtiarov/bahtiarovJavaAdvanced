package domain;

import domain.exceptions.IlluminanceTooMuchException;
import domain.exceptions.SpaceUsageTooMuchException;
import domain.objects.Building;
import domain.objects.Light;
import domain.objects.Room;
import domain.objects.Subject;

public class Main {

    public static void main(String[] args) throws SpaceUsageTooMuchException, IlluminanceTooMuchException {

        Light light1 = new Light(50);
        Light light2 = new Light(50);

        Subject subject1 = new Subject("Стол письменный", 3);
        Subject subject2 = new Subject("Кресло мягкое", 10);

        Room room1 = new Room("Комната 1", 3, 100);

        room1.addLight(light1);
        room1.addLight(light2);
        room1.addSubject(subject1);
        room1.addSubject(subject2);

        Room room2 = new Room("Комната 2", 2, 90);

        room2.addLight(light1);
        room2.addLight(light2);
        room2.addSubject(subject1);
        room2.addSubject(subject2);

        Building building = new Building("Здание 1");
        building.addRoom(room1);
        building.addRoom(room2);
        building.describe();

    }

}
