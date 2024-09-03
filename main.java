package hw_Set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class main {

        public static void main(String[] args) {
                // Создаем множество ноутбуков
                Set<Laptop> Laptop = new HashSet<>();
                Laptop.add(new Laptop("Dell", "XPS 13", 16, 512, "Intel i7", "Intel Iris Xe", 13.3, "Windows 10",
                                "grey",
                                1200.00));
                Laptop.add(
                                new Laptop("Apple", "MacBook Air", 8, 256, "Apple M1", "Integrated", 13.3, "macOS",
                                                "silver", 999.99));
                Laptop.add(
                                new Laptop("HP", "Pavilion 15", 16, 1024, "AMD Ryzen 5", "NVIDIA GTX 1650", 15.6,
                                                "Windows 11", "grey",
                                                850.00));
                Laptop.add(new Laptop("Asus", "ZenBook 14", 8, 512, "Intel i5", "Intel Iris Xe", 14.0, "Windows 10",
                                "black",
                                1100.00));

                // Запрос критериев у пользователя и фильтрация ноутбуков
                filterLaptop(Laptop);
        }

        public static void filterLaptop(Set<Laptop> Laptops) {
                Scanner scanner = new Scanner(System.in);
                Map<String, String> criteria = new HashMap<>();

                // Запрос критериев у пользователя
                System.out.println("Введите критерии фильтрации (оставьте пустым, если не хотите учитывать критерий):");
                System.out.print("Бренд: ");
                criteria.put("brand", scanner.nextLine());
                System.out.print("Минимальная оперативная память (ГБ): ");
                criteria.put("ram", scanner.nextLine());
                System.out.print("Минимальный объем накопителя (ГБ): ");
                criteria.put("storage", scanner.nextLine());
                System.out.print("Операционная система: ");
                criteria.put("os", scanner.nextLine());
                System.out.print("Цвет: ");
                criteria.put("color", scanner.nextLine());
                System.out.print("Максимальная цена ($): ");
                criteria.put("price", scanner.nextLine());

                // Фильтрация ноутбуков
                Set<Laptop> filteredLaptops = Laptops.stream()
                                .filter(Laptop -> criteria.get("brand").isEmpty()
                                                || Laptop.getBrand().equalsIgnoreCase(criteria.get("brand")))
                                .filter(Laptop -> criteria.get("ram").isEmpty()
                                                || Laptop.getRam() >= Integer.parseInt(criteria.get("ram")))
                                .filter(Laptop -> criteria.get("storage").isEmpty()
                                                || Laptop.getStorage() >= Integer.parseInt(criteria.get("storage")))
                                .filter(Laptop -> criteria.get("os").isEmpty()
                                                || Laptop.getOs().equalsIgnoreCase(criteria.get("os")))
                                .filter(Laptop -> criteria.get("color").isEmpty()
                                                || Laptop.getColor().equalsIgnoreCase(criteria.get("color")))
                                .filter(Laptop -> criteria.get("price").isEmpty()
                                                || Laptop.getPrice() <= Double.parseDouble(criteria.get("price")))
                                .collect(Collectors.toSet());

                // Вывод отфильтрованных ноутбуков
                if (filteredLaptops.isEmpty()) {
                        System.out.println("Ноутбуков, соответствующих заданным критериям, не найдено.");
                } else {
                        System.out.println("Результаты фильтрации:");
                        filteredLaptops.forEach(System.out::println);
                }
        }
}
