package com.stu;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> danhSachDiem = new ArrayList<>();
        int luaChon;

        do {
            System.out.println("\n***************** MENU NHẬP ĐIỂM *****************");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            luaChon = sc.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.println("\n--- Nhập điểm học viên (nhập -1 để dừng) ---");
                    while (true) {
                        System.out.print("Nhập điểm: ");
                        double diem = sc.nextDouble();

                        if (diem == -1) break;

                        if (diem < 0 || diem > 10) {
                            System.err.println("Điểm không hợp lệ. Nhập lại.");
                        } else {
                            danhSachDiem.add(diem);
                            System.out.println("Học lực: " + xepLoai(diem));
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- KẾT QUẢ THỐNG KÊ ---");
                    if (danhSachDiem.isEmpty()) {
                        System.out.println("Chưa có dữ liệu!");
                    } else {
                        double tong = 0;
                        double max = danhSachDiem.get(0);
                        double min = danhSachDiem.get(0);

                        for (double d : danhSachDiem) {
                            tong += d;
                            if (d > max) max = d;
                            if (d < min) min = d;
                        }

                        System.out.println("Số học viên đã nhập: " + danhSachDiem.size());
                        System.out.printf("Điểm trung bình: %.2f\n", (tong / danhSachDiem.size()));
                        System.out.printf("Điểm cao nhất  : %.2f\n", max);
                        System.out.printf("Điểm thấp nhất : %.2f\n", min);
                    }
                    break;

                case 3:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChon != 3);


    }

    public static String xepLoai(double diem) {
        if (diem < 5) return "Yếu";
        if (diem < 7) return "Trung bình";
        if (diem < 8) return "Khá";
        if (diem < 9) return "Giỏi";
        return "Xuất sắc";
    }
}