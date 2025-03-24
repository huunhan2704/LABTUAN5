import java.util.ArrayList;
import java.util.Scanner;

abstract class NhanVien {
    protected String maNhanVien;
    protected String tenNhanVien;
    protected String trinhDo;
    protected double luongCoBan;

    public NhanVien() {
        this.maNhanVien = "";
        this.tenNhanVien = "";
        this.trinhDo = "";
        this.luongCoBan = 0.0;
    }

    public NhanVien(String maNhanVien, String tenNhanVien, String trinhDo) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.trinhDo = trinhDo;
        this.luongCoBan = 0.0;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien: ");
        this.maNhanVien = scanner.nextLine();
        System.out.print("Nhap ten nhan vien: ");
        this.tenNhanVien = scanner.nextLine();
        System.out.print("Nhap trinh do: ");
        this.trinhDo = scanner.nextLine();
        System.out.print("Nhap luong co ban: ");
        while (true) {
            try {
                this.luongCoBan = scanner.nextDouble();
                scanner.nextLine(); // Xóa bộ đệm
                break;
            } catch (Exception e) {
                System.out.println("Vui long nhap so hop le!");
                scanner.nextLine(); // Xóa bộ đệm lỗi
            }
        }
    }

    public void xuat() {
        System.out.println("Ma nhan vien: " + maNhanVien + ", Ten nhan vien: " + tenNhanVien +
                ", Trinh do: " + trinhDo + ", Luong co ban: " + luongCoBan);
    }

    public abstract double tinhLuong();
}

class QuanLy extends NhanVien {
    private String chuyenMon;
    private double phuCapChucVu;

    public QuanLy() {
        super();
        this.chuyenMon = "";
        this.phuCapChucVu = 0.0;
    }

    public QuanLy(String maNhanVien, String tenNhanVien, String trinhDo, String chuyenMon, double phuCapChucVu) {
        super(maNhanVien, tenNhanVien, trinhDo);
        this.chuyenMon = chuyenMon;
        this.phuCapChucVu = phuCapChucVu;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public double getPhuCapChucVu() {
        return phuCapChucVu;
    }

    public void setPhuCapChucVu(double phuCapChucVu) {
        this.phuCapChucVu = phuCapChucVu;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chuyen mon: ");
        this.chuyenMon = scanner.nextLine();
        System.out.print("Nhap phu cap chuc vu: ");
        while (true) {
            try {
                this.phuCapChucVu = scanner.nextDouble();
                scanner.nextLine(); // Xóa bộ đệm
                break;
            } catch (Exception e) {
                System.out.println("Vui long nhap so hop le!");
                scanner.nextLine(); // Xóa bộ đệm lỗi
            }
        }
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Chuyen mon: " + chuyenMon + ", Phu cap chuc vu: " + phuCapChucVu);
    }

    @Override
    public double tinhLuong() {
        return luongCoBan + phuCapChucVu;
    }
}

class NghienCuu extends NhanVien {
    private String chuyenMon;
    private double phuCapDocHai;

    public NghienCuu() {
        super();
        this.chuyenMon = "";
        this.phuCapDocHai = 0.0;
    }

    public NghienCuu(String maNhanVien, String tenNhanVien, String trinhDo, String chuyenMon, double phuCapDocHai) {
        super(maNhanVien, tenNhanVien, trinhDo);
        this.chuyenMon = chuyenMon;
        this.phuCapDocHai = phuCapDocHai;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public double getPhuCapDocHai() {
        return phuCapDocHai;
    }

    public void setPhuCapDocHai(double phuCapDocHai) {
        this.phuCapDocHai = phuCapDocHai;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chuyen mon: ");
        this.chuyenMon = scanner.nextLine();
        System.out.print("Nhap phu cap doc hai: ");
        while (true) {
            try {
                this.phuCapDocHai = scanner.nextDouble();
                scanner.nextLine(); // Xóa bộ đệm
                break;
            } catch (Exception e) {
                System.out.println("Vui long nhap so hop le!");
                scanner.nextLine(); // Xóa bộ đệm lỗi
            }
        }
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Chuyen mon: " + chuyenMon + ", Phu cap doc hai: " + phuCapDocHai);
    }

    @Override
    public double tinhLuong() {
        return luongCoBan + phuCapDocHai;
    }
}

class PhucVu extends NhanVien {
    public PhucVu() {
        super();
    }

    public PhucVu(String maNhanVien, String tenNhanVien, String trinhDo) {
        super(maNhanVien, tenNhanVien, trinhDo);
    }

    @Override
    public double tinhLuong() {
        return luongCoBan;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<NhanVien> danhSachNhanVien = new ArrayList<>();

        QuanLy quanLy = new QuanLy("QL001", "Nguyen Van A", "Dai hoc", "Quan tri", 2000000);
        quanLy.nhap();
        danhSachNhanVien.add(quanLy);

        NghienCuu nghienCuu = new NghienCuu("NC001", "Tran Thi B", "Thac si", "Hoa hoc", 1500000);
        nghienCuu.nhap();
        danhSachNhanVien.add(nghienCuu);

        PhucVu phucVu = new PhucVu("PV001", "Le Van C", "Trung cap");
        phucVu.nhap();
        danhSachNhanVien.add(phucVu);

        System.out.println("\nDanh sach nhan vien:");
        for (NhanVien nv : danhSachNhanVien) {
            nv.xuat();
            System.out.println("Luong: " + nv.tinhLuong());
        }
    }
}