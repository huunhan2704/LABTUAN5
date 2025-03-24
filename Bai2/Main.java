import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong hinh: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Xóa bộ đệm sau khi nhập số

        Hinh[] ds = new Hinh[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Chon loai hinh se nhap: ");
            System.out.println("1: Hinh vuong");
            System.out.println("2: Hinh chu nhat");
            System.out.println("3: Hinh tron");
            int chon = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm sau khi nhập số

            switch (chon) {
                case 1:
                    ds[i] = new HinhVuong();
                    ds[i].nhap(scanner);
                    break;
                case 2:
                    ds[i] = new HinhChuNhat();
                    ds[i].nhap(scanner);
                    break;
                case 3:
                    ds[i] = new HinhTron();
                    ds[i].nhap(scanner);
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
                    i--; // Lặp lại lần nhập này
                    break;
            }
        }

        System.out.println("\nDanh sach cac hinh:");
        for (Hinh hinh : ds) {
            hinh.xuat();
        }

        Hinh hinhDienTichLonNhat = ds[0];
        for (Hinh hinh : ds) {
            if (hinh.dienTich() > hinhDienTichLonNhat.dienTich()) {
                hinhDienTichLonNhat = hinh;
            }
        }

        System.out.println("\nHinh co dien tich lon nhat:");
        hinhDienTichLonNhat.xuat();

        scanner.close();
    }
}

interface Hinh {
    float pi = 3.14f;

    void nhap(Scanner scanner);

    void xuat();

    float dienTich();
}

class HinhVuong implements Hinh {
    private float canh;

    public HinhVuong() {
        this.canh = 0;
    }

    public HinhVuong(float canh) {
        this.canh = canh;
    }

    @Override
    public void nhap(Scanner scanner) {
        System.out.print("Nhap canh cua hinh vuong: ");
        this.canh = scanner.nextFloat();
    }

    @Override
    public void xuat() {
        System.out.println("Hinh vuong - Canh: " + canh + ", Dien tich: " + dienTich());
    }

    @Override
    public float dienTich() {
        return canh * canh;
    }
}

class HinhChuNhat implements Hinh {
    private float dai;
    private float rong;

    public HinhChuNhat() {
        this.dai = 0;
        this.rong = 0;
    }

    public HinhChuNhat(float dai, float rong) {
        this.dai = dai;
        this.rong = rong;
    }

    @Override
    public void nhap(Scanner scanner) {
        System.out.print("Nhap chieu dai cua hinh chu nhat: ");
        this.dai = scanner.nextFloat();
        System.out.print("Nhap chieu rong cua hinh chu nhat: ");
        this.rong = scanner.nextFloat();
    }

    @Override
    public void xuat() {
        System.out.println("Hinh chu nhat - Dai: " + dai + ", Rong: " + rong + ", Dien tich: " + dienTich());
    }

    @Override
    public float dienTich() {
        return dai * rong;
    }
}

class HinhTron implements Hinh {
    private float banKinh;

    public HinhTron() {
        this.banKinh = 0;
    }

    public HinhTron(float banKinh) {
        this.banKinh = banKinh;
    }

    @Override
    public void nhap(Scanner scanner) {
        System.out.print("Nhap ban kinh cua hinh tron: ");
        this.banKinh = scanner.nextFloat();
    }

    @Override
    public void xuat() {
        System.out.println("Hinh tron - Ban kinh: " + banKinh + ", Dien tich: " + dienTich());
    }

    @Override
    public float dienTich() {
        return pi * banKinh * banKinh;
    }
}