import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TreeMapImplementation extends AbstractMap{

    public TreeMapImplementation(){

    }

    public static Map<String, Carta> treeMapTXT = new TreeMap<>();
    public static Map<String, Carta> coleccionUsuario = new TreeMap<>();

    /**
     * Lee información relevante desde un archivo.
     *
     * @param nombreArchivo
     */
    @Override
    void leerArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en nombre y tipo usando el separador "|"
                String[] partes = linea.split("\\|");

                if (partes.length == 2) {
                    String nombreCarta = partes[0].trim();
                    String tipoCarta = partes[1].trim();

                    Carta carta = new Carta(tipoCarta);

                    // Almacenar en el HashMap
                    treeMapTXT.put(nombreCarta, carta);
                } else {
                    System.out.println("Error en el formato de la línea: " + linea);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    void agregarCarta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre de la carta que deseas agregar a su colección: ");
        String nombreCarta = sc.nextLine();
        if (treeMapTXT.get(nombreCarta) != null){
            Carta carta = new Carta(treeMapTXT.get(nombreCarta).getTipoCarta());
            if (coleccionUsuario.containsKey(nombreCarta)){
                int cantidad = coleccionUsuario.get(nombreCarta).getCantidad() + 1;
                carta.setCantidad(cantidad);
                coleccionUsuario.put(nombreCarta, carta);
            }else {
                carta.setCantidad(1);
                coleccionUsuario.put(nombreCarta, carta);
            }
            System.out.println("Carta agregada correctamente.");
        }else{
            System.out.println("¡Carta no disponible!");
        }
    }

    @Override
    void mostrarTipoCarta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre de la carta que deseas saber que tipo es: ");
        String nombreCarta = sc.nextLine();
        if (treeMapTXT.get(nombreCarta) != null){
            System.out.println("El tipo de la carta (" + nombreCarta + ") es: " + treeMapTXT.get(nombreCarta).getTipoCarta());
        }else{
            System.out.println("¡Carta no existente!");
        }
    }

    @Override
    void mostrarColeccionUsuario() {
        if (!coleccionUsuario.isEmpty()){
            for (Map.Entry<String, Carta> entry : coleccionUsuario.entrySet()) {
                System.out.println("Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipoCarta() + ", Cantidad: " + entry.getValue().getCantidad());
            }
        }else{
            System.out.println("No posee ninguna carta");
        }
    }

    @Override
    void mostrarColeccionUsuarioOrdenada() {

        boolean tieneMonstruos = false;
        boolean tieneHechizos = false;
        boolean tieneTrampas = false;

        System.out.println("Cartas de tipo Monstruo: ");
        for (Map.Entry<String, Carta> entry : coleccionUsuario.entrySet()) {
            if (entry.getValue().getTipoCarta().equals("Monstruo")) {
                System.out.println("- Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipoCarta());
                tieneMonstruos = true;
            }
        }
        if (!tieneMonstruos) {
            System.out.println("No tiene cartas de tipo Monstruo.");
        }

        System.out.println("Cartas de tipo Hechizo: ");
        for (Map.Entry<String, Carta> entry : coleccionUsuario.entrySet()) {
            if (entry.getValue().getTipoCarta().equals("Hechizo")) {
                System.out.println("- Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipoCarta());
                tieneHechizos = true;
            }
        }
        if (!tieneHechizos) {
            System.out.println("No tiene cartas de tipo Hechizo.");
        }

        System.out.println("Cartas de tipo Trampa: ");
        for (Map.Entry<String, Carta> entry : coleccionUsuario.entrySet()) {
            if (entry.getValue().getTipoCarta().equals("Trampa")) {
                System.out.println("- Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipoCarta());
                tieneTrampas = true;
            }
        }
        if (!tieneTrampas) {
            System.out.println("No tiene cartas de tipo Trampa.");
        }
    }

    @Override
    void mostrarCartasExistente() {
        for (Map.Entry<String, Carta> entry : treeMapTXT.entrySet()) {
            System.out.println("Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipoCarta());
        }
    }

    @Override
    void mostrarCartasExistenteOrdenada() {
        boolean tieneMonstruos = false;
        boolean tieneHechizos = false;
        boolean tieneTrampas = false;

        System.out.println("Cartas de tipo Monstruo: ");
        for (Map.Entry<String, Carta> entry : treeMapTXT.entrySet()) {
            if (entry.getValue().getTipoCarta().equals("Monstruo")) {
                System.out.println("- Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipoCarta());
                tieneMonstruos = true;
            }
        }
        if (!tieneMonstruos) {
            System.out.println("No tiene cartas de tipo Monstruo.");
        }

        System.out.println("Cartas de tipo Hechizo: ");
        for (Map.Entry<String, Carta> entry : treeMapTXT.entrySet()) {
            if (entry.getValue().getTipoCarta().equals("Hechizo")) {
                System.out.println("- Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipoCarta());
                tieneHechizos = true;
            }
        }
        if (!tieneHechizos) {
            System.out.println("No tiene cartas de tipo Hechizo.");
        }
}