public class GuvenliEv extends NormalLokasyon{
    public GuvenliEv(Oyuncu oyuncu) {
        super(oyuncu, "Güvenli Ev");
    }
    @Override
   public boolean tumLokasyon(){
        System.out.println("Güvenli evdesiniz");
        System.out.println("Canınız Yenilendi");
        this.getOyuncu().setSaglik(this.getOyuncu().getOrjinalSaglik());
        return true;
    }
}
