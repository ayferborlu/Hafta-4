import java.util.Scanner;

public class Oyun {
    private Scanner input = new Scanner(System.in);

    public void basla() {
        System.out.println("Macera Oyununa Hoşgeldiniz");
        System.out.println("Lütfen bir isim giriniz: ");
        String oyuncuIsmi = input.nextLine();
        Oyuncu oyuncu = new Oyuncu(oyuncuIsmi);
        System.out.println("Sayın " + oyuncu.getIsim() + " Hoşgeldiniz");
        System.out.println("Lütfen bir karakter seçin");
        oyuncu.karakterSec();


        Lokasyon lokasyon = null;
        while (true) {
            oyuncu.bilgileriYazdir();
            System.out.println();
            System.out.println("++++++++++++Bölgeler++++++++++");
            System.out.println();
            System.out.println("1--Güvenli ev == Burası sizin için güvenlibir ev,düşman yok");
            System.out.println("2--Mağaza == Silay veya zırh satın alabilirsiniz");
            System.out.println("3--Mağara--Ödül: Yemek,, dikkatli ol karşına zombi çıkabilir ");
            System.out.println("4--Orman--Ödül: odun,, dikkatli ol karşına Vampir çıkabilir ");
            System.out.println("5--Nehir--ödül: su,, dikkatli ol karşına Ayı  çıkabilir ");
            System.out.println("6--Maden--ödül: para,, dikkatli ol karşına Yılan  çıkabilir ");
            System.out.println("0 -- Çıkış Yap -- Oyunu Sonlandır");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçin : ");
            int lokasyonSec = input.nextInt();
            switch (lokasyonSec) {
                case 0:
                    lokasyon = null;
                    break;
                case 1:
                    lokasyon = new GuvenliEv(oyuncu);
                    break;
                case 2:
                    lokasyon = new AletDeposu(oyuncu);
                    break;
                case 3:
                    lokasyon = new Magara(oyuncu);
                    break;
                case 4:
                    lokasyon = new Orman(oyuncu);
                    break;
                case 5:
                    lokasyon = new Nehir(oyuncu);
                    break;
                case 6:
                    lokasyon = new Maden(oyuncu);
                    break;
                default:
                    lokasyon = new GuvenliEv(oyuncu);
            }
            if (lokasyon == null) {
                System.out.println("Oyun bitti  ");
                break;
            }

            if (!lokasyon.tumLokasyon()) {
                System.out.println("ÖLDÜNÜZ GAME OVER");
                break;
            }
        }


    }
}
