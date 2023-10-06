public class Envaner {

    private Silah silah;
    private Zirh zirh;

    public Envaner(){
        this.silah= new Silah("Yumruk",-1,0,0);
        this.zirh=new Zirh(-1,"Paçavra",0,0);

    }



    public Silah getSilah() {
        return silah;
    }

    public void setSilah(Silah silah) {
        this.silah = silah;
    }

    public Zirh getZirh() {
        return zirh;
    }

    public void setZirh(Zirh zirh) {
        this.zirh = zirh;
    }
}

