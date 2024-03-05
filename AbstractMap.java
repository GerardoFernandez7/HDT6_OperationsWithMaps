import java.io.IOException;

/**
 * La clase AbstractMap representa una abstracción de un mapa de cartas.
 */
public abstract class AbstractMap {

    /**
     * Lee información relevante desde un archivo.
     */
    abstract void leerArchivo(String nombreArchivo);

    /**
     * Agrega una nueva carta a la colección.
     *
     */
    abstract void agregarCarta();

    /**
     * Muestra el tipo de una carta específica.
     *
     */
    abstract void mostrarTipoCarta();

    /**
     * Muestra la colección de cartas del usuario.
     */
    abstract void mostrarColeccionUsuario();

    /**
     * Muestra la colección de cartas del usuario ordenada de alguna manera específica.
     */
    abstract void mostrarColeccionUsuarioOrdenada();

    /**
     * Muestra todas las cartas existentes.
     */
    abstract void mostrarCartasExistente();

    /**
     * Muestra todas las cartas existentes ordenadas de alguna manera específica.
     */
    abstract void mostrarCartasExistenteOrdenada();
}