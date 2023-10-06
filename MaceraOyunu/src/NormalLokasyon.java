import java.util.Random;

public abstract class NormalLokasyon extends Lokasyon {
    private Canavar canavar;
    private String odul;
    private int maxEngel;

    public NormalLokasyon(Oyuncu oyuncu, String isim, Canavar canavar, String odul, int maxEngel) {
        super(oyuncu, isim);
        this.canavar = canavar;
        this.odul = odul;
        this.maxEngel = maxEngel;
    }

    public NormalLokasyon(Oyuncu oyuncu, String magaza) {
        super(oyuncu, "Mağaza");
    }

    @Override
    public boolean tumLokasyon() {
        int cnvrSayi = this.randomEngelSayisi();
        System.out.println("Şuan buradasınız: " + this.getIsim());
        System.out.println("Dikkatli ol, Burada " + cnvrSayi + " tane " + this.getCanavar().getIsim() + " yaşıyor");
        System.out.print("<S<avaş veya <K<aç :");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S") && savas(cnvrSayi)) {
            if (savas(cnvrSayi)) ;
            System.out.println(this.getIsim() + "tüm düşmanları yendiniz");
            return true;
        }

        if (this.getOyuncu().getSaglik() <= 0) {
            System.out.println("Öldünüz");
            return false;
        }

        return true;
    }

    public boolean savas(int cnvrSayi) {
        for (int i = 1; i <= cnvrSayi; i++) {
            this.getCanavar().setSaglik(this.getCanavar().getOrjinalSaglik());
            oyuncuDeger();
            cnvrDegeri(i);
            while (this.getOyuncu().getSaglik() > 0 && this.getCanavar().getSaglik() > 0) {
                hamleBelirle();
            }
            if (this.getCanavar().getSaglik() < this.getOyuncu().getSaglik()) {
                odulKazan();
            } else {
                return false;
            }
        }

        return false;
    }

    private void odulKazan() {
        System.out.println("***Düşmanı Yendiniz***");
        Random r = new Random();
        int randomSayi = r.nextInt(1, 101);

        //silah kazanma ihtimali
        if (randomSayi <= 15) {
            int silahRandomSayi = r.nextInt(1, 101);
            //tüfek
            if (silahRandomSayi <= 20) {
                this.getOyuncu().getEnvanter().setSilah(Silah.silahlar()[2]);
                System.out.println(" Silah => Tüfek kazandınız.");
            }
            //kılıç
            else if (silahRandomSayi > 15 && silahRandomSayi <= 30) {
                this.getOyuncu().getEnvanter().setSilah(Silah.silahlar()[1]);
                System.out.println(" Silah => Kılıç kazandınız.");
            }
            //tabanca
            else {
                this.getOyuncu().getEnvanter().setSilah(Silah.silahlar()[0]);
                System.out.println(" Silah => Tabanca kazandınız.");
            }
        }
        // zırh kazanma ihtimali
        else if (randomSayi > 15 && randomSayi <= 30) {
            int zirhRandomSayi = r.nextInt(1, 101);
            //Ağır zırh kanma ihtimali
            if (zirhRandomSayi <= 20) {
                this.getOyuncu().getEnvanter().setZirh(Zirh.zirhlar()[2]);
                System.out.println("Zırh => Ağır Zırh Kazandınız.");
            }
            // orta zırh:
            else if (zirhRandomSayi > 20 && zirhRandomSayi <= 30) {
                this.getOyuncu().getEnvanter().setZirh(Zirh.zirhlar()[1]);
                System.out.println("Zırh => Orta Zırh Kazandınız.");
            } else {
                // Hafif zırh:
                this.getOyuncu().getEnvanter().setZirh(Zirh.zirhlar()[0]);
                System.out.println(" X Hafif  Zırh kazandınız");

            }
        }
        //Para kazanma ihtimali
        else if (randomSayi > 30 && randomSayi <= 55) {
            int kazanilanPara = 0;
            int paraRandomSayi = r.nextInt(1, 101);
            // 10 para kazanma:
            if (paraRandomSayi <= 20) {
                kazanilanPara = 10;
            }
            // 5 para:
            else if (paraRandomSayi > 20 && paraRandomSayi <= 30) {
                kazanilanPara = 5;
            } else {
                kazanilanPara = 1;
            }

            this.getOyuncu().setPara(this.getOyuncu().getPara() + this.getCanavar().getOdul());
            System.out.println("Güncel Paranız:  " + this.getOyuncu().getPara());
            System.out.println(kazanilanPara + " para kazandınız");

        } else {
            System.out.println("Hiçbirşey kazanamadınız");

        }
    }

    private boolean hamleBelirle() {
        System.out.print("<V<ur veya <K<aç: ");
        String savasSec = input.nextLine().toUpperCase();
        if (savasSec.equals("V")) {
            Random r = new Random();
            int kimVuracak = r.nextInt(1, 3);

            // Ben vuracağım
            if (kimVuracak == 1) {
                canavaraHasarVer();
                if (this.getCanavar().getSaglik() > 0) {
                    kendimeHasarVer();
                }
            } else {
                kendimeHasarVer();
            }
            return true;
        } else {
            return false;
        }
    }

    private void canavaraHasarVer() {
        System.out.println("Siz vurdunuz");
        this.getCanavar().setSaglik(this.getCanavar().getSaglik() - getOyuncu().getHasar());
        sonradanVurus();
    }

    private void kendimeHasarVer() {
        System.out.println();
        System.out.println("Canavar size vurdu");
        int canavarahasar = this.getCanavar().getHasar() - this.getOyuncu().getEnvanter().getZirh().getBlok();
        if (canavarahasar < 0) {
            canavarahasar = 0;

        }
        this.getOyuncu().setSaglik(this.getOyuncu().getSaglik() - canavarahasar);
        sonradanVurus();
    }

    public void sonradanVurus() {
        System.out.println("Canınız : " + this.getOyuncu().getSaglik());
        System.out.println(this.getCanavar().getIsim() + "Canı: " + this.getCanavar().getSaglik());
        System.out.println();
    }

    public void oyuncuDeger() {
        System.out.println("Oyuncu değerleri");
        System.out.println("---------------------");
        System.out.println("Sağlık: " + this.getOyuncu().getSaglik());
        System.out.println("Silah: " + this.getOyuncu().getEnvanter().getSilah().getIsim());
        System.out.println("Hasar: " + this.getOyuncu().getHasar());
        System.out.println("Zırh: " + this.getOyuncu().getEnvanter().getZirh().getIsim());
        System.out.println("Bloklama: " + this.getOyuncu().getEnvanter().getZirh().getBlok());
        System.out.println("Para: " + this.getOyuncu().getPara());
        System.out.println();

    }

    public void cnvrDegeri(int i) {
        System.out.println(i + "." + this.getCanavar().getIsim() + " Vampir değerleri");
        System.out.println("---------------------");
        System.out.println("Sağlık: " + this.getCanavar().getSaglik());
        System.out.println("Hasar: " + this.getCanavar().getHasar());
        System.out.println("Ödül: " + this.getCanavar().getOdul());
        System.out.println();


    }


    public int randomEngelSayisi() {
        Random r = new Random();
        return r.nextInt(this.getMaxEngel()) + 1;
    }

    public Canavar getCanavar() {
        return canavar;
    }

    public void setCanavar(Canavar canavar) {
        this.canavar = canavar;
    }

    public String getOdul() {
        return odul;
    }

    public void setOdul(String odul) {
        this.odul = odul;
    }

    public int getMaxEngel() {
        return maxEngel;
    }

    public void setMaxEngel(int maxEngel) {
        this.maxEngel = maxEngel;
    }

}
