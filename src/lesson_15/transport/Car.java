package lesson_15.transport;

public class Car {
    final private String brand;   // final
    final private String model;     // final
    private double engineVolume;
    private String color;
    final private int year;             // final
    final private String country;       // final
    ////////////////////////////////////////// new elements ////////////////////////////
    private String transmission;
    final private String bodyType;            // final
    private String registrationNumber;   // M976MM777
    final int numberSeats;                    // final
    boolean isSummerWheels;


    public Car(String brand, String model, double engineVolume, String color, int year, String country,
               String transmission, String bodyType, String registrationNumber, int numberSeats, boolean isSummerWheels) {

        String defaultBrand = "default_brand";
        this.brand = simpleCheckString(brand, defaultBrand);

        String defaultModel = "default_model";
        this.model=simpleCheckString(model,defaultModel);
        setEngineVolume(engineVolume);
        setColor(color);

        int defaultYear = 2000;
        if(year>1900){this.year = year;}
        else {this.year=defaultYear;}

        String defaultCountry = "default_country";
        this.country = simpleCheckString(country,defaultCountry);


        setTransmission(transmission);


        String defaultBodyType = "седан";
        if(bodyType==null || bodyType.isBlank())
            this.bodyType=defaultBodyType;
        else {
           bodyType=bodyType.trim().replace("\\s+","").toLowerCase();
           switch (bodyType){
               case ("седан"):
               case ("универсал"):
               case ("хэтчбек"):
               case ("лимузин"):
               case ("внедорожник"):
               case ("кроссовер"):
               case ("купе"):
               case ("микроавтобус"):
               case ("минивэн"):
               case ("кабриолет"):
               case ("пикап"):
               case ("фургон"):
                   this.bodyType=bodyType;
                   break;
               default:
                   this.bodyType=defaultBodyType;
                   break;
           }
        }



        setRegistrationNumber(registrationNumber);

        int defaultNUmberSeats = 5;
        if(numberSeats>1 && numberSeats<=7)  {this.numberSeats=numberSeats;}
        else { this.numberSeats=defaultNUmberSeats;
        }
        this.isSummerWheels=isSummerWheels;

    }

    /*public Car(){
        this.brand = "default";
        this.model = "default";
        this.engineVolume = 1.5;
        this.color = "white";
        this.year = 2000;
        this.country = "defaulte";
    }*/
    @Override
    public String toString() {
        String wheelsType = (isSummerWheels) ? "Летня резина" : "Зимняя резина";
        return String.format("Brand: %1$8s model: %2$8s Volume: %3$.2f Color: %4$7s" +
                " Year: %5$d Country: %6$7s Тип Кузова: [%8$s] Коробка передач: [%9$s] Регистрационный номер: [%10$s] Количество мест: [%11$d] [%12$s]","'"+brand+"'","'"+model+"'",
                engineVolume, color, year,country,bodyType,transmission, registrationNumber, numberSeats, wheelsType);
    }
    ///////////////// getters  ///////////

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getNumberSeats() {
        return numberSeats;
    }

    public boolean isSummerWheels() {
        return isSummerWheels;
    }


    //////////////////// utility  ///////////////

    private String simpleCheckString(String str, String forDefaultValue) {
        if(str==null || str.isBlank()){
            System.out.println("Некорректный ввод. Значение будет измененено на :"+forDefaultValue);
            return  forDefaultValue;
        }
        return str.trim().replaceAll("\\s+", " ");

    }
    /////////////////////////////////////// setters /////////////////////////

    public void setEngineVolume(double engineVolume) {
        double defaultVolume = 1.5;
        if(engineVolume>0)
            this.engineVolume=engineVolume;
        else {
            System.out.println("Некорректный ввод. Значение будет измененено на :"+defaultVolume);
            this.engineVolume=defaultVolume;
        }
    }
    public void setColor(String color) {
        this.color=simpleCheckString(color,"Default_White");
    }

    public void setTransmission(String transmission) {
        String defaultTransmission = "механическая";
        transmission = simpleCheckString(transmission, defaultTransmission).toLowerCase();
        switch(transmission) {
            case ("механическая"):
            case("гидромеханическая"):
            case("гидравлическая"):
            case("электромехнаическая"):
            case("автоматическая"):
                this.transmission=transmission;
                break;
            default:
                this.transmission=defaultTransmission;
                System.out.println("Некорректный ввод. Значение будет измененено на :"+defaultTransmission);
                break;
        }

    }

    public void setRegistrationNumber(String registrationNumber) { ///// M976MM777
        String defaultRegistrationNumber = "E000RR000";
        if(registrationNumber== null || registrationNumber.isBlank()){
            this.registrationNumber=defaultRegistrationNumber;
            System.out.println("Некорректный ввод. Значение будет измененено на :"+defaultRegistrationNumber);
            return;
        }
        registrationNumber = registrationNumber.trim().replaceAll("\\s+", "");
        if (registrationNumber.length() != 9 || !Character.isLetter(registrationNumber.charAt(0))) {
            this.registrationNumber=defaultRegistrationNumber;
            System.out.println("Некорректный ввод. Значение будет измененено на :"+defaultRegistrationNumber);
            return;
        }
        if(  Character.isDigit(registrationNumber.charAt(1)) && Character.isDigit(registrationNumber.charAt(2)) && Character.isDigit(registrationNumber.charAt(3)) &&
                Character.isLetter(registrationNumber.charAt(4)) && Character.isLetter(registrationNumber.charAt(5)) && Character.isDigit(registrationNumber.charAt(6)) &&
                Character.isDigit(registrationNumber.charAt(7)) && Character.isDigit(registrationNumber.charAt(8))) {
            this.registrationNumber = registrationNumber.toUpperCase();
        }
        else {
            this.registrationNumber=defaultRegistrationNumber;
            System.out.println("Некорректный ввод. Значение будет измененено на :"+defaultRegistrationNumber);
        }
    }

    public void setSummerWheels(boolean summerWheels) {
        isSummerWheels = summerWheels;
    }

    public void changeWheelsBySeason(int month) {
        if (month <= 0 || month > 12) {
            System.out.println("Неверный номер месяца: "+month);
            return;
        }
        switch (month) {
            case (11):
            case (12):
            case (1):
            case (2):
                this.isSummerWheels=false;
                break;
            default:
                this.isSummerWheels=true;
                break;
        }
    }
} // Car
