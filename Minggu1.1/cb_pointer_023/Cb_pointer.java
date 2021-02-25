package cb_pointer_023;

public class Cb_pointer {
    public static void UbahInt(int nilai) {
        nilai = 55;
    }

    public static void UbahRefObjek(Tanggal ref) {
        ref = new Tanggal(22, 2, 2021);
    }

    public static void UbahAttObjek(Tanggal ref) {
        ref.setTgl(23);
    }

    public static void main(String[] args) {
        Tanggal tanggalku;
        int val;
        val = 11;
        UbahInt(val);
        System.out.println("Nilai Integer :" + val);
        tanggalku = new Tanggal(1, 1, 2020);
        UbahRefObjek(tanggalku);
        tanggalku.cetak();
        UbahAttObjek(tanggalku);
        tanggalku.cetak();
    }
}

class Tanggal {
    int tgl = 1;
    int bulan = 1;
    int tahun = 2021;

    public Tanggal (int Tgl, int Bulan, int Tahun) {
        tgl=Tgl;
        bulan=Bulan;
        tahun=Tahun;
    }

    public void setTgl(int Tgl) {
        tgl = Tgl;
    }

    public void setBulan(int Bulan) {
        bulan = Bulan;
    }

    public void settahun(int Tahun) {
        tahun = Tahun;
    }

    public void cetak() {
        System.out.println("tanggal:" + tgl);
        System.out.println("bulan:" + bulan);
        System.out.println("tahun:" + tahun);

    }

}