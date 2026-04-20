package com.stu;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========== NHẬP THÔNG TIN HÓA ĐƠN ==========");
        System.out.print("Nhập tên khách hàng: ");
        String tenKhachHang = sc.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        String tenSanPham = sc.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double giaSanPham = sc.nextDouble();

        System.out.print("Nhập số lượng mua: ");
        int soLuong = sc.nextInt();

        System.out.print("Khách có thẻ thành viên? (true/false): ");
        boolean isThanhVien = sc.nextBoolean();

        double thanhTien = giaSanPham * soLuong;

        double giamGia = 0;
        if (isThanhVien) {
            giamGia = thanhTien * 0.1;
        }

        double tienVAT = (thanhTien - giamGia) * 0.08;

        double tongThanhToan = thanhTien - giamGia + tienVAT;

        System.out.println("==================== HÓA ĐƠN ====================");
        System.out.println("Khách hàng : " + tenKhachHang);
        System.out.println("Sản phẩm   : " + tenSanPham);
        System.out.println("Số lượng   : " + soLuong);

        System.out.printf("Đơn giá    : %,.2f VNĐ\n", giaSanPham);
        System.out.printf("Thành tiền : %,.2f VNĐ\n", thanhTien);
        System.out.printf("Giảm giá thành viên (10%%): %,.2f VNĐ\n", giamGia);
        System.out.printf("Tiền VAT (8%%): %,.2f VNĐ\n", tienVAT);
        System.out.println("-------------------------------------------------");
        System.out.printf("Tổng thanh toán: %,.2f VNĐ\n", tongThanhToan);
        System.out.println("=================================================");
        
    }
}