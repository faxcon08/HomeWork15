package lesson_15;
import lesson_15.transport.Car;

public class Main {

    public static void main(String[] args) {

        //  public Car(String brand, String model, double engineVolume, String color, int year, String country, String transmission, String bodyType, String registrationNumber, int numberSeats, boolean isSummerWheels)
        Car simpleCar1 = new Car("Lada", "Granta", 1.7, "Желтый", 2015, "Россия", "ручная", "седан", "Н666СР777", 4, true );
        Car simpleCar2 = new Car("Audi", "A8 50 L TDI quattro", 3.0, "Черный", 2020, "Германия", "автоматическая", "седан", "О626СР347", 5, true);
        Car simpleCar3 = new Car("BMW", "Z8", 3.0, "Красный", 2021, "Германия", "автоматическая", "родстер", "С333СР341", 5, false);



        System.out.println(simpleCar1);
        System.out.println(simpleCar2);
        System.out.println(simpleCar3);

        Car.Key carKey1 = simpleCar1.new Key(false,false);
        System.out.println(carKey1);


        Car.Key carKey2 = simpleCar2.new Key(true, true);
        System.out.println(carKey2);
        carKey2.startKey();
        carKey2.stopKey();


    }// main
}// Main