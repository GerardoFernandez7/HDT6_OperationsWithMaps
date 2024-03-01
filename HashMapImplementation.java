import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapImplementation extends AbstractMap{

    public static Map<String, Carta> hashMapTXT = new HashMap<>();
    public static Map<String, Carta> hashMapColeccionUsuario = new HashMap<>();

    @Override
    public void leerArchivo(String archivoPath){
        try (BufferedReader br = new BufferedReader(new FileReader(archivoPath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en nombre y tipo usando el separador "|"
                String[] partes = linea.split("\\|");

                if (partes.length == 2) {
                    String nombreCarta = partes[0].trim();
                    String tipoCarta = partes[1].trim();

                    Carta carta = new Carta(tipoCarta);

                    // Almacenar en el HashMap
                    hashMapTXT.put(nombreCarta, carta);
                } else {
                    System.out.println("Error en el formato de la línea: " + linea);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    void agregarCarta() { // TOMAR EN CUENTA QUE PASA SI YA EXISTE LA CARTA AGREGAR VALIDACIÓN
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre de la carta que deseas agregar a su colección: ");
        String nombreCarta = sc.nextLine();
        // Se obtiene la carta del hashmap que contiene todas las cartas
        if (hashMapTXT.get(nombreCarta) == null){
            System.out.println("¡Carta no disponible!");
        }else{
            Carta carta = new Carta(nombreCarta);
            hashMapColeccionUsuario.put(nombreCarta, hashMapTXT.get(nombreCarta));
            System.out.println("Carta agregada correctamente.");
            System.out.println(hashMapTXT.get(nombreCarta).getTipoCarta() + ", " + hashMapTXT.get(nombreCarta).getCantidad());
        }
    }

    @Override
    void mostrarTipoCarta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre de la carta que deseas saber que tipo es: ");
        String nombreCarta = sc.nextLine();
        // Se obtiene la carta del hashmap que contiene todas las cartas
        if (hashMapTXT.get(nombreCarta) == null){
            System.out.println("¡Carta no existen!");
        }else{
            System.out.println("El tipo de la carta (" + nombreCarta + ") es: " + hashMapTXT.get(nombreCarta));
        }
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