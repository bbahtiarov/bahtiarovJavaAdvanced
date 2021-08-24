package domain;

import domain.exceptions.IlluminanceTooMuchException;
import domain.exceptions.SpaceUsageTooMuchException;
import domain.objects.Building;
import domain.objects.Light;
import domain.objects.Room;
import domain.objects.Subject;
import domain.utils.Const;

public class Main {

    public static void main(String[] args) {

        Light light1 = new Light(50);
        Light light2 = new Light(50);

        Subject subject1 = new Subject("Стол письменный", 3);
        Subject subject2 = new Subject("Кресло мягкое", 5);

        Room room1 = new Room("Комната 1", 3, 100);
        Room room2 = new Room("Комната 2", 20, 90);

        try {

            room1.addLight(light1);
            room1.addLight(light2);

            room2.addLight(light1);
            room2.addLight(light2);

            if (
                    room1.getSumLk() > Const.ROOM_LK_LIMIT
                    || room2.getSumLk() > Const.ROOM_LK_LIMIT
            ) {

                throw  new IlluminanceTooMuchException();

            }

        } catch (IlluminanceTooMuchException e) {
            e.printStackTrace();
        }
        try {

            room1.addSubject(subject1);
            room1.addSubject(subject2);

            room2.addSubject(subject1);
            room2.addSubject(subject2);

            if (
                    room1.getPercentOccupiedSquare() > Const.SQUARE_LIMIT
                    || room2.getPercentOccupiedSquare() > Const.SQUARE_LIMIT
            ) {

                throw new SpaceUsageTooMuchException();

            }


        } catch (SpaceUsageTooMuchException e) {
            e.printStackTrace();
        }

        Building building = new Building("Здание 1");
        building.addRoom(room1);
        building.addRoom(room2);
        building.describe();

    }

}
