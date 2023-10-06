public class AletDeposu extends NormalLokasyon {
    public AletDeposu(Oyuncu oyuncu) {
        super(oyuncu,"Mağaza");
    }

    @Override
    public boolean tumLokasyon() {
        System.out.println("----------Mağazaya Hoşgeldiniz------------");
        boolean showMenu = true;
        while (showMenu){
        System.out.println("1 - Silahlar");
        System.out.println("2 - Zırhlar");
        System.out.println("3 - Çıkış Yap");
        System.out.print("Seçiminiz: ");
        int degerSec = Lokasyon.input.nextInt();
        while ((degerSec < 1 || degerSec > 3)) {
            System.out.print("Geçersiz değer, tekrar girin: ");
            degerSec = input.nextInt();
        }
        switch (degerSec) {
            case 1:
                silahYazdir();
                silahSatinAlma();
                break;
            case 2:
                zirhYazdir();
                zirhSatinAl();
                break;
            case 3:
                System.out.println("Bir daha bekleriz");
                showMenu = false;
               break;
        }

        }
        return true;

    }

    public void silahYazdir() {
        System.out.println("------------Silahlar------------");
        for (Silah s : Silah.silahlar()) {
            System.out.println(s.getIsim() + " - " +
                    "<Para: " + s.getDeger() + ",Hasar: " + s.getZarar());
        }
        System.out.println("0 Çıkış Yap");
    }

    public void silahSatinAlma() {

        System.out.print("Bir silah seçiniz: ");
        int silahSec = input.nextInt();

        while ((silahSec < 0 || silahSec > Silah.silahlar().length)) {
            System.out.print("Geçersiz değer, tekrar girin: ");
            silahSec = input.nextInt();
        }
        if (silahSec != 0) {

            Silah silahSecilmis = Silah.silahObjGetId(silahSec);

            if (silahSecilmis != null) {
                if (silahSecilmis.getDeger() > this.getOyuncu().getPara()) {
                    System.out.println("Yeterli paranız bulunmamaktadır");
                } else {
                    // satın almanın gerçekleştiği alan
                    System.out.println(silahSecilmis.getIsim() + " Silahını satın aldınız ");
                    int balance = this.getOyuncu().getPara() - silahSecilmis.getDeger();
                    this.getOyuncu().setPara(balance);
                    System.out.println("Kalan bakiye: " + this.getOyuncu().getPara());
                    this.getOyuncu().getEnvanter().setSilah(silahSecilmis);

                }
            }
        }
    }
    public void zirhYazdir() {
        System.out.println("------------Zırhlar------------");
        for (Zirh z: Zirh.zirhlar()){
            System.out.println(z.getId() + " - " + z.getIsim() +
                    " <Para: " + z.getFiyat() + ", Zırh: " +z.getBlok()+ " > ");

        }
        System.out.println("0 Çıkış Yap");


    }
    public void zirhSatinAl() {
        System.out.print("Bir zırh seçiniz: ");
        int zirhSec = input.nextInt();

        while ((zirhSec < 1 || zirhSec > Zirh.zirhlar().length)) {
            System.out.print("Geçersiz değer, tekrar girin: ");
            zirhSec = input.nextInt();

        }

        if(zirhSec !=0){
        Zirh SecilenZirh =Zirh.getZirhByID(zirhSec);

        if(SecilenZirh != null){
            if(SecilenZirh.getFiyat()>this.getOyuncu().getPara()){
                System.out.println("Yeterli paranız bulunmamaktadır");
            }else{
                System.out.println(SecilenZirh.getIsim() + "zırhını satın aldınız ");
                int balance = this.getOyuncu().getPara() + SecilenZirh.getFiyat();
                this.getOyuncu().setPara(balance);
                this.getOyuncu().getEnvanter().setZirh(SecilenZirh);
                System.out.println("Kalan bakiye: " + this.getOyuncu().getPara());

            }

        }
    }
}}