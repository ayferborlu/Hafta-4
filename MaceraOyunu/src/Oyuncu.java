import java.util.Scanner;

public class Oyuncu {
    private int hasar;
    private int saglik;
    private int orjinalSaglik;
    private int para;
    private String karakterIsmi;
    private String isim;

    private  Scanner input = new Scanner(System.in);
    private Envaner envanter;

    public Oyuncu(String isim){
        this.isim=isim;
        this.envanter =new Envaner();
    }

    public void karakterSec(){
        OyunKarakteri[] karakterlistesi = { new Samuray(),new Okcu(), new Sovalye()};
        System.out.println("Karakterler");
        System.out.println("-----------------------------------------------------");
        for (OyunKarakteri oyunKarakteri : karakterlistesi){
            System.out.println("ID: " +oyunKarakteri.getId()+
                "\t Karakter:" + oyunKarakteri.getIsim() +
                    "\t\t Hasar:" +oyunKarakteri.getHasar()+
                    "\t\tSağlık:" +oyunKarakteri.getSaglik()+
                    "\t\tPara:" +oyunKarakteri.getPara());
        }
        System.out.println("-----------------------------------------------------");
        System.out.print("Lütfen bir karakter seçiniz ");
        int karakterSec= input.nextInt();
        switch (karakterSec){
            case 1:
                oyuncuyuBaslat(new Samuray());
                break;
            case  2:
                oyuncuyuBaslat(new Okcu());
                break;
            case 3:
                oyuncuyuBaslat(new Sovalye());
                break;
            default:
                oyuncuyuBaslat(new Samuray());
        }
        /*System.out.println("Karakter: "+this.getKarakterIsmi()
                +", Hasar: "+this.getHasar()
                +", Sağlık: "+this.getSaglik()
                + ", Para: "+ this.getPara());
                */

    }
    public void lokasyonSec(){

    }
    public void oyuncuyuBaslat(OyunKarakteri oyunKarakteri){
        this.setHasar(oyunKarakteri.getHasar());
        this.setSaglik(oyunKarakteri.getSaglik());
        this.setOrjinalSaglik(oyunKarakteri.getSaglik());
        this.setPara(oyunKarakteri.getPara());
        this.setKarakterIsmi(oyunKarakteri.getIsim());

    }
  public void bilgileriYazdir(){
      System.out.println("Silah: " + getEnvanter().getSilah().getIsim() +
                      ", Zırh: " + getEnvanter().getZirh().getIsim() +
                      ", Bloklama: " + getEnvanter().getZirh().getBlok() +
                      ", Hasarınız: "+this.getToplamHasar()+
                      ", Sağlık: "+this.getSaglik()+
                      ", Para: "+ this.getPara());
  }
public int getToplamHasar(){
    return hasar + this.getEnvanter().getSilah().getZarar();
}
    public int getHasar() {
        return hasar;
    }

    public void setHasar(int hasar) {
        this.hasar = hasar;
    }

    public int getSaglik() {
        return saglik;
    }

    public void setSaglik(int saglik) {
        this.saglik = saglik;
    }

    public int getPara() {
        return para;
    }

    public void setPara(int para) {
        this.para = para;
    }

    public String getKarakterIsmi() {
        return karakterIsmi;
    }

    public void setKarakterIsmi(String karakterIsmi) {
        this.karakterIsmi = karakterIsmi;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public Envaner getEnvanter() {
        return envanter;
    }

    public void setEnvanter(Envaner envanter) {
        this.envanter = envanter;
    }

    public int getOrjinalSaglik() {
        return orjinalSaglik;
    }

    public void setOrjinalSaglik(int orjinalSaglik) {
        this.orjinalSaglik = orjinalSaglik;
    }
}


