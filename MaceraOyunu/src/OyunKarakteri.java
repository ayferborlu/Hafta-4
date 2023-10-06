public abstract class OyunKarakteri {
    private int id;
    private String isim;
    private int hasar;
    private int saglik;
    private int para;



    public OyunKarakteri(int id,String isim,int hasar,int saglik, int para){
        this.id=id;
        this.isim=isim;
        this.hasar=hasar;
        this.saglik=saglik;
        this.para=para;
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

    public String getIsim() {
        return isim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsim(String isim) {
        this.isim = isim;

    }
}

