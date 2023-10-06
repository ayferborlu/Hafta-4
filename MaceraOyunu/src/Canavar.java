public class Canavar {
    private int id;
    private String isim;
    private int hasar;
    private int saglik;
    private int odul;
    private int OrjinalSaglik;


    public Canavar(int id, String isim, int hasar, int saglik,int odul) {
        this.id = id;
        this.isim = isim;
        this.hasar = hasar;
        this.saglik = saglik;
       OrjinalSaglik=saglik;
        this.odul= odul;
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
        if(saglik <0){
            saglik=0;
        }
        this.saglik = saglik;
    }

    public int getOdul() {
        return odul;
    }

    public void setOdul(int odul) {
        this.odul = odul;
    }

    public int getOrjinalSaglik() {
        return OrjinalSaglik;
    }

    public void setOrjinalSaglik(int orjinalSaglik) {
        OrjinalSaglik = orjinalSaglik;
    }
}
