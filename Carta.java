public class Carta {
    private String tipoCarta;
    private int cantidad;

    public Carta(String tipoCarta) {
        this.tipoCarta = tipoCarta;
        this.cantidad = 0;
    }

    public String getTipoCarta() {
        return tipoCarta;
    }

    public void setTipoCarta(String tipoCarta) {
        this.tipoCarta = tipoCarta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
