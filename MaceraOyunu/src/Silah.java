public class Silah {
    private String isim;
    private int id;
    private int zarar;
    private int deger;

    public Silah(String isim, int id, int zarar, int deger) {
        this.isim = isim;
        this.id = id;
        this.zarar = zarar;
        this.deger = deger;
    }

    public static Silah[] silahlar() {
        Silah[] silahListesi = new Silah[3];
        silahListesi[0] = new Silah("Tabanca", 1, 2, 5);
        silahListesi[1] = new Silah("Kılıç", 2, 3, 35);
        silahListesi[2] = new Silah("Tüfek", 3, 7, 45);
        return silahListesi;
    }

    public static Silah silahObjGetId(int id) {

        for (Silah s : Silah.silahlar()) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;

    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getZarar() {
        return zarar;
    }

    public void setZarar(int zarar) {
        this.zarar = zarar;
    }

    public int getDeger() {
        return deger;
    }

    public void setDeger(int deger) {
        this.deger = deger;
    }
}
