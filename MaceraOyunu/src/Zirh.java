public class Zirh {
    private int id;
    private String isim;
    private int blok;
    private int fiyat;

    public Zirh(int id, String isim, int blok, int fiyat) {
        this.id = id;
        this.isim = isim;
        this.blok = blok;
        this.fiyat = fiyat;
    }
    public static Zirh[] zirhlar(){
        Zirh[] zirhListesi = new Zirh[3];
        zirhListesi[0]=new Zirh(1,"Hafif",1,15);
        zirhListesi[1]=new Zirh(2,"Orta",3,25);
        zirhListesi[2]=new Zirh(3,"Ağır",5,40);

        return zirhListesi;

    }
    public static Zirh getZirhByID(int id){

        for(Zirh z : Zirh.zirhlar()){
            if (z.getId() == id){
                return z;
            }
        }
        return  null;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getBlok() {
        return blok;
    }

    public void setBlok(int blok) {
        this.blok = blok;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }
}
