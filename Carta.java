/**
 * La clase Carta representa una carta en el contexto del programa.
 */
public class Carta {
    private String tipoCarta;
    private int cantidad;

    /**
     * Constructor de la clase Carta.
     *
     * @param tipoCarta El tipo de carta.
     */
    public Carta(String tipoCarta) {
        this.tipoCarta = tipoCarta;
        this.cantidad = 0;
    }

    /**
     * Obtiene el tipo de carta.
     *
     * @return El tipo de carta.
     */
    public String getTipoCarta() {
        return tipoCarta;
    }

    /**
     * Establece el tipo de carta.
     *
     * @param tipoCarta El tipo de carta a establecer.
     */
    public void setTipoCarta(String tipoCarta) {
        this.tipoCarta = tipoCarta;
    }

    /**
     * Obtiene la cantidad de esta carta.
     *
     * @return La cantidad de esta carta.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de esta carta.
     *
     * @param cantidad La cantidad de esta carta a establecer.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
