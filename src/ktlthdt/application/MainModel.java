package ktlthdt.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ktlthdt.model.BanhXe;
import ktlthdt.model.DongCo;
import ktlthdt.model.LapTop;
import ktlthdt.model.SanPham;
import ktlthdt.model.XeHoi;

public class MainModel {

    public static void main(String[] args) throws CloneNotSupportedException {
        List<XeHoi> cars = new ArrayList<>();
        cars.add(new XeHoi(1, "Toyota", 100, 1250000, new DongCo("Dong co xang", 147)));
        cars.add(new XeHoi(2, "Chevrolet", 1000, 3890000, new DongCo("Dong co xang", 107)));
        cars.add(new XeHoi(3, "Mitsubishi", 100, 6500000, new DongCo("Dong co xang", 105)));
        cars.add(new XeHoi(4, "Isuzu", 100, 6180000, new DongCo("Dong co xang", 110)));
        cars.add(new XeHoi(5, "Porsche Taycan", 100, 1013950, new DongCo("Dong co dien", 560)));
        cars.add(new XeHoi(6, "VinFast", 100, 2620000, new DongCo("Dong co dien", 300)));
        cars.add(new XeHoi(7, "Hyundai", 100, 8500000, new DongCo("Dong co dien", 160)));

        List<LapTop> lt = new ArrayList<>();
        lt.add(new LapTop(1, "Dell", 123, 15000, 4, "16GB DDR4"));
        lt.add(new LapTop(2, "Macbook", 1234, 14670, 8, "8GB DDR4"));
        lt.add(new LapTop(3, "Lenovor", 231, 13290, 4, "16GB DDR4"));
        lt.add(new LapTop(4, "Toshiba", 101, 8200, 4, "8GB DDR3"));
        lt.add(new LapTop(5, "Asus", 120, 12490, 4, "8GB DDR4"));
        lt.add(new LapTop(6, "Hewlett-Packard", 1500, 13490, 4, "16GB DDR4"));
        lt.add(new LapTop(7, "Acer", 100, 26490, 4, "8GB DDR4"));

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline left-over
            switch (choice) {
                case 1:
                    hienthidanhsachbanhxe(cars);
                    break;
                case 2:
                    hienthidanhsachlaptop(lt);
                    break;
                case 3:
                    xapsepxetheogia(cars);
                    break;
                case 4:
                    timkiem(lt, sc);
                    break;
                case 5:
                    xoa(lt, sc);
                    break;
                case 6:
                    timkiemXe(cars, sc);
                    break;
                case 7:
                    xoaXe(cars, sc);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        } while (choice != 0);
        sc.close();
    }

    private static void suathongtinsanpham(List<LapTop> lt, Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	private static void themmoixe(List<XeHoi> cars, Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	public static void showMenu() {
		 System.out.println("\n|-------------------------------------- |");
	        System.out.println("|                 Menu:                 |");
	        System.out.println("|1. Hiển thị danh sách xe hơi           |");
	        System.out.println("|2. Hiển thị danh sách laptop           |");
	        System.out.println("|3. Xắp sếp xe theo giá cả              |");
	        System.out.println("|4. Tìm kiếm laptop                     |");
	        System.out.println("|5. Xóa laptop                          |");
	        System.out.println("|6. Tìm kiếm xe hơi                     |");
	        System.out.println("|7. Xóa xe hơi                          |");
	        System.out.println("|0. Thoát Chương Trình                  |");
	        System.out.println("|-------------------------------------- |");
	        System.out.print("Mời bạn chọn: ");
    }

    public static void hienthidanhsachbanhxe(List<XeHoi> cars) {
        System.out.println("\nDanh sách bánh xe của các xe hơi:");
        System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("| %-3s | %-15s | %-8s | %-12s | %-30s | %-100s |\n", "ID", "Tên", "Số Lượng", "Giá Cả", "Động Cơ", "Bánh Xe");
        System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        for (XeHoi car : cars) {
            System.out.printf("| %-3d | %-15s | %-8d | %-12.3f | %-30s | %-100s |\n",
                    car.getMaSP(), car.getTenSP(), car.getSoluong(), car.getGiaca(), car.getDongco(), car.getDsbx());
        }
        System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
    }

    public static void hienthidanhsachlaptop(List<LapTop> lt) {
        System.out.println("\nDanh sách laptop:");
        System.out.println("|-------------------------------------------------------------------------|");
        System.out.printf("| %-3s | %-15s | %-8s | %-10s | %-5s | %-15s |\n", "ID", "Tên", "Số Lượng", "Giá Cả", "RAM", "CPU");
        System.out.println("|-------------------------------------------------------------------------|");
        for (LapTop item : lt) {
            System.out.printf("| %-3d | %-15s | %-8d | %-10.3f | %-5d | %-15s |\n",
                    item.getMaSP(), item.getTenSP(), item.getSoluong(), item.getGiaca(), item.getRam(), item.getCpu());
        }
        System.out.println("|-------------------------------------------------------------------------|");
    }

    public static void xapsepxetheogia(List<XeHoi> cars) {
        Collections.sort(cars, Comparator.comparingDouble(XeHoi::getGiaca));

        System.out.println("\nDanh sách xe hơi được sắp xếp theo giá cả:");
        System.out.println("|----------------------------------------------------------------|");
        System.out.printf("| %-10s | %-15s | %-20s | %-8s |\n", "Giá cả", "Mã SP", "Tên SP", "Số lượng");
        System.out.println("|----------------------------------------------------------------|");
        for (XeHoi car : cars) {
            System.out.printf("| %-10.2f | %-15d | %-20s | %-8d |\n",
                    car.getGiaca(), car.getMaSP(), car.getTenSP(), car.getSoluong());
        }
        System.out.println("|----------------------------------------------------------------|");
    }

    public static void timkiem(List<LapTop> lt, Scanner sc) {
        System.out.print("\nNhập tên laptop cần tìm: ");
        String name = sc.nextLine().trim();

        Collections.sort(lt, Comparator.comparing(LapTop::getTenSP));

        int vitri = Collections.binarySearch(lt, new LapTop(0, name, 0, 0, 0, null), Comparator.comparing(LapTop::getTenSP));

        if (vitri < 0) {
            System.out.println("Không tìm thấy laptop '" + name + "'.");
        } else {
            System.out.println("Laptop '" + name + "' có vị trí: " + vitri);
            System.out.println("|-------------------------------------------------------------------------|");
            System.out.printf("| %-3s | %-15s | %-8s | %-10s | %-5s | %-15s |\n", "ID", "Tên", "Số Lượng", "Giá Cả", "RAM", "CPU");
            System.out.println("|-------------------------------------------------------------------------|");
            LapTop foundLaptop = lt.get(vitri);
            System.out.printf("| %-3d | %-15s | %-8d | %-10.3f | %-5d | %-15s |\n",
                    foundLaptop.getMaSP(), foundLaptop.getTenSP(), foundLaptop.getSoluong(),
                    foundLaptop.getGiaca(), foundLaptop.getRam(), foundLaptop.getCpu());
            System.out.println("|-------------------------------------------------------------------------|");
        }
    }
    public static void xoa(List<LapTop> lt, Scanner sc) {
        System.out.print("\nNhập tên laptop cần xóa: ");
        String name = sc.nextLine().trim();

        Iterator<LapTop> iterator = lt.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            LapTop laptop = iterator.next();
            if (laptop.getTenSP().trim().equalsIgnoreCase(name)) {
                iterator.remove();
                found = true;
                System.out.println("Laptop '" + name + "' đã được xóa.");
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy laptop '" + name + "'.");
        } else {
            System.out.println("\nDanh sách laptop sau khi xóa:");
            hienthidanhsachlaptop(lt);
        }
    }
    public static void timkiemXe(List<XeHoi> cars, Scanner sc) {
        System.out.print("\nNhập tên xe hơi cần tìm: ");
        String name = sc.nextLine().trim();

        Collections.sort(cars, Comparator.comparing(XeHoi::getTenSP));

        int vitri = Collections.binarySearch(cars, new XeHoi(0, name, 0, 0, null), Comparator.comparing(XeHoi::getTenSP));

        if (vitri < 0) {
            System.out.println("Không tìm thấy xe hơi '" + name + "'.");
        } else {
            System.out.println("Xe hơi '" + name + "' có vị trí: " + vitri);
            System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
            System.out.printf("| %-3s | %-15s | %-8s | %-12s | %-30s | %-100s |\n", "ID", "Tên", "Số Lượng", "Giá Cả", "Động Cơ", "Bánh Xe");
            System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
            XeHoi foundCar = cars.get(vitri);
            System.out.printf("| %-3d | %-15s | %-8d | %-12.3f | %-30s | %-100s |\n",
                    foundCar.getMaSP(), foundCar.getTenSP(), foundCar.getSoluong(), foundCar.getGiaca(), foundCar.getDongco(), foundCar.getDsbx());
            System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        }
    }
    public static void xoaXe(List<XeHoi> cars, Scanner sc) {
        System.out.print("\nNhập tên xe hơi cần xóa: ");
        String name = sc.nextLine().trim();

        Iterator<XeHoi> iterator = cars.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            XeHoi car = iterator.next();
            if (car.getTenSP().trim().equalsIgnoreCase(name)) {
                iterator.remove();
                found = true;
                System.out.println("Xe hơi '" + name + "' đã được xóa.");
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy xe hơi '" + name + "'.");
        } else {
            System.out.println("\nDanh sách xe hơi sau khi xóa:");
            hienthidanhsachbanhxe(cars);
        }
    }
}