package lesson_15.transport;

public class Car {
    private String brand;
    private String model;
    private double engineVolume;
    private String color;
    private int year;
    private String country;

    public Car(String brand, String model, double engineVolume, String color, int year, String country) {
        this.brand = brand;
        this.model=model;
        this.engineVolume = engineVolume;
        this.color = color;
        this.year = year;
        this.country = country;
    }

    public Car(){
        this.brand = "default";
        this.model = "default";
        this.engineVolume = 1.5;
        this.color = "white";
        this.year = 2000;
        this.country = "defaulte";
    }
    @Override
    public String toString() {
        return String.format("Brand: %1$8s model: %2$8s Volume: %3$.2f Color: %4$7s" +
                " Year: %5$d Country: %6$7s","'"+brand+"'","'"+model+"'",engineVolume, color, year,country);
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
    //////////////////// utility  ///////////////

    private String simpleCheckString(String str, String forDefaultValue) {
        if(str==null || str.isBlank()){
            System.out.println("Некорректный ввод. Значение будет измененено на :"+forDefaultValue);
            return  forDefaultValue;
        }
        return str.trim().replaceAll("\\s+", " ");

    }
    /////////////////////////////////////// setters /////////////////////////


    public void setBrand(String brand) {
        this.brand=simpleCheckString(brand,"Default_Brand");
    }

    public void setModel(String model) {
        this.model=simpleCheckString(model,"Default_model");
    }

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

    public void setYear(int year) {
        int defaultYear = 2000;
        if(year>1900)
            this.year=year;
        else {
            System.out.println("Некорректный ввод. Значение будет измененено на :"+defaultYear);
            this.year=defaultYear;
        }
    }
    public void setCountry(String country) {
        this.country=simpleCheckString(country,"Default_country");
    }
} // Car
