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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarTipoCarta'");
    }

    @Override
    void mostrarColeccionUsuario() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarColeccionUsuario'");
    }

    @Override
    void mostrarColeccionUsuarioOrdenada() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarColeccionUsuarioOrdenada'");
    }

    @Override
    void mostrarCartasExistente() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarCartasExistente'");
    }

    @Override
    void mostrarCartasExistenteOrdenada() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarCartasExistenteOrdenada'");
    }
    
}
