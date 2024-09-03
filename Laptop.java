package hw_Sat;

import java.util.Objects;

public class Laptop {
    private String brand; // Марка ноутбука
    private String model; // Модель ноутбука
    private int ram; // Объем оперативной памяти (в ГБ)
    private int storage; // Объем накопителя (в ГБ)
    private String cpu; // Модель процессора
    private String gpu; // Модель видеокарты
    private double screenSize; // Размер экрана (в дюймах)
    private String os; // Операционная система
    private String color; // Цвет
    private double price; // Цена ноутбука

    // Конструктор
    public Laptop(String brand, String model, int ram, int storage, String cpu, String gpu, double screenSize,
            String os, String color, double price) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.cpu = cpu;
        this.gpu = gpu;
        this.screenSize = screenSize;
        this.os = os;
        this.color = color;
        this.price = price;
    }

    // Геттеры для всех полей
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getCpu() {
        return cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", screenSize=" + screenSize +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Laptop Laptop = (Laptop) o;
        return ram == Laptop.ram && storage == Laptop.storage
                && Double.compare(Laptop.screenSize, screenSize) == 0 && Double.compare(Laptop.price, price) == 0
                && Objects.equals(brand, Laptop.brand) && Objects.equals(model, Laptop.model)
                && Objects.equals(cpu, Laptop.cpu) && Objects.equals(gpu, Laptop.gpu)
                && Objects.equals(os, Laptop.os) && Objects.equals(color, Laptop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, ram, storage, cpu, gpu, screenSize, os, color, price);
    }
}