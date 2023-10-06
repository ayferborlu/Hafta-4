import java.util.Scanner;

public abstract class Lokasyon {
    private Oyuncu oyuncu;
    private String isim;
    public static Scanner input= new Scanner(System.in);

    public Lokasyon(Oyuncu oyuncu,String isim) {
        this.oyuncu = oyuncu;
        this.isim=isim;

    }
   public abstract boolean tumLokasyon();
    public Oyuncu getOyuncu() {
        return oyuncu;
    }

    public void setOyuncu(Oyuncu oyuncu) {
        this.oyuncu = oyuncu;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }


}
