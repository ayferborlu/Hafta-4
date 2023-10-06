public class SavasLokasyonu extends Lokasyon{

    public SavasLokasyonu(Oyuncu oyuncu, String isim){
        super(oyuncu,isim);
    }

    @Override
    public boolean tumLokasyon(){
        return false;
    }
}








