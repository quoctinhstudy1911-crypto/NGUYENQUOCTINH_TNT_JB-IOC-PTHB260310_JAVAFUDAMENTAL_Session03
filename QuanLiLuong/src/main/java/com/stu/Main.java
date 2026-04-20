package com.stu;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> dsLuong = new ArrayList<>();
        int luaChon;

        do {
            System.out.println("\n**************** MENU NHẬP LƯƠNG ****************");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng số tiền thưởng cho nhân viên");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            luaChon = sc.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.println("\n--- Nhập lương (nhập -1 để kết thúc) ---");
                    while (true) {
                        System.out.print("Nhập lương: ");
                        double luong = sc.nextDouble();

                        if (luong == -1) break;

                        if (luong < 0 || luong > 500000000) {
                            System.out.println("Lương không hợp lệ. Nhập lại.");
                        } else {
                            dsLuong.add(luong);
                            System.out.println("-> Phân loại: " + phanLoaiThuNhap(luong));
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- Thống kê ---");
                    if (dsLuong.isEmpty()) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        double tongLuong = 0;
                        double max = dsLuong.get(0);
                        double min = dsLuong.get(0);

                        for (double l : dsLuong) {
                            tongLuong += l;
                            if (l > max) max = l;
                            if (l < min) min = l;
                        }

                        System.out.println("Số nhân viên đã nhập: " + dsLuong.size());
                        System.out.printf("Tổng lương: %,.0f VND\n", tongLuong);
                        System.out.printf("Lương trung bình: %,.0f VND\n", (tongLuong / dsLuong.size()));
                        System.out.printf("Lương cao nhất: %,.0f VND\n", max);
                        System.out.printf("Lương thấp nhất: %,.0f VND\n", min);
                    }
                    break;

                case 3:
                    System.out.println("\n--- Tính tổng tiền thưởng ---");
                    double tongThuong = 0;
                    for (double l : dsLuong) {
                        tongThuong += tinhTienThuong(l);
                    }
                    System.out.printf("Tổng tiền thưởng cho nhân viên: %,.0f VND\n", tongThuong);
                    break;

                case 4:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChon != 4);
    }

    public static String phanLoaiThuNhap(double luong) {
        if (luong < 5000000) return "Thu nhập thấp";
        if (luong <= 15000000) return "Thu nhập trung bình";
        if (luong <= 50000000) return "Thu nhập khá";
        return "Thu nhập cao";
    }

    public static double tinhTienThuong(double luong) {
        if (luong < 5000000) return luong * 0.05;
        if (luong <= 15000000) return luong * 0.10;
        if (luong <= 50000000) return luong * 0.15;
        if (luong <= 100000000) return luong * 0.20;
        return luong * 0.25;
    }
}