public abstract class AbstractMap {
    /**
     * Lee información relevante desde un archivo.
     */
    abstract void leerArchivo();

    /**
     * Agrega una nueva carta a la colección.
     * 
     * @param nombreCarta El nombre de la carta que se va a agregar.
     */
    abstract void agregarCarta(String nombreCarta);

    /**
     * Muestra el tipo de una carta específica.
     * 
     * @param nombreCarta El nombre de la carta de la cual se mostrará el tipo.
     */
    abstract void mostrarTipoCarta(String nombreCarta);

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