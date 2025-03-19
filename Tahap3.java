import java.text.NumberFormat;
import java.util.Locale;

class Util {
    public static String formatRupiah(double amount) {
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        return formatRupiah.format(amount);
    }
}

class Perusahaan {
    private final String namaPerusahaan;

    public Perusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }
}

class Karyawan {
    private String nama;
    private double gajiPokok;
    private Perusahaan perusahaan;

    public Karyawan(String nama, double gajiPokok, Perusahaan perusahaan) {
        setNama(nama);
        this.gajiPokok = gajiPokok;
        this.perusahaan = perusahaan;
    }

    public void setNama(String nama) {
        if (nama.length() < 4) {
            System.out.println("Nama karyawan harus lebih dari 4 karakter");
            return;
        }
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public double hitungGaji() {
        return gajiPokok;
    }

    public void info() {
        System.out.println("Nama Karyawan: " + nama);
        System.out.println("Gaji Pokok: " + Util.formatRupiah(gajiPokok));
        System.out.println("Perusahaan: " + perusahaan.getNamaPerusahaan());
    }

    public void infoGaji() {
        System.out.println("Nama: " + nama + ", Total Gaji: " + Util.formatRupiah(hitungGaji()));
    }
}

class Programmer extends Karyawan {
    private double bonus;

    public Programmer(String nama, double gajiPokok, double bonus, Perusahaan perusahaan) {
        super(nama, gajiPokok, perusahaan);
        this.bonus = bonus;
    }

    @Override
    public double hitungGaji() {
        return super.hitungGaji() + bonus;
    }
}

class Manager extends Karyawan {
    private double insentif;

    public Manager(String nama, double gajiPokok, double insentif, Perusahaan perusahaan) {
        super(nama, gajiPokok, perusahaan);
        this.insentif = insentif;
    }

    @Override
    public double hitungGaji() {
        return super.hitungGaji() + insentif;
    }
}

public class Tahap3 {
    public static void main(String[] args) {
        Perusahaan perusahaan = new Perusahaan("PT. Sistem Informasi");

        Karyawan karyawan1 = new Karyawan("Icaa", 5000000, perusahaan);
        Programmer programmer1 = new Programmer("Ecaa", 6000000, 1500000, perusahaan);
        Manager manager1 = new Manager("Nanda", 7000000, 2000000, perusahaan);

        karyawan1.info();
        karyawan1.infoGaji();
        System.out.println();

        programmer1.info();
        programmer1.infoGaji();
        System.out.println();

        manager1.info();
        manager1.infoGaji();
    }
}

