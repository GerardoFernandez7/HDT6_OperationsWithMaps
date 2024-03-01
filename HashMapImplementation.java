import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
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
    void agregarCarta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre de la carta que deseas agregar a su colección: ");
        String nombreCarta = sc.nextLine();
        // Se obtiene la carta del hashmap que contiene todas las cartas
        if (hashMapTXT.get(nombreCarta) == null){
            System.out.println("¡Carta no disponible!");
        }else{
            Carta carta = new Carta(hashMapTXT.get(nombreCarta).getTipoCarta());
            if (hashMapColeccionUsuario.containsKey(nombreCarta)){
                int cantidad = hashMapColeccionUsuario.get(nombreCarta).getCantidad() + 1;
                carta.setCantidad(cantidad);
                hashMapColeccionUsuario.put(nombreCarta, carta);
            }else {
                carta.setCantidad(1);
                hashMapColeccionUsuario.put(nombreCarta, carta);
            }
            System.out.println("Carta agregada correctamente.");
        }
    }

    @Override
    void mostrarTipoCarta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre de la carta que deseas saber que tipo es: ");
        String nombreCarta = sc.nextLine();
        // Se obtiene la carta del hashmap que contiene todas las cartas
        if (hashMapTXT.get(nombreCarta) == null){
            System.out.println("¡Carta no existente!");
        }else{
            System.out.println("El tipo de la carta (" + nombreCarta + ") es: " + hashMapTXT.get(nombreCarta).getTipoCarta());
        }
    }

    @Override
    void mostrarColeccionUsuario() {
        if (hashMapColeccionUsuario.isEmpty()){
            System.out.println("No posee ninguna carta");
        }else{
            for (Map.Entry<String, Carta> entry : hashMapColeccionUsuario.entrySet()) {
                System.out.println("Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipoCarta() + ", Cantidad: " + entry.getValue().getCantidad());
            }
        }
    }

    @Override
    void mostrarColeccionUsuarioOrdenada() {
        if (hashMapColeccionUsuario.isEmpty()) {
            System.out.println("No posee ninguna carta");
        } else {
            boolean tieneMonstruos = false;
            boolean tieneHechizos = false;
            boolean tieneTrampas = false;

            System.out.println("Cartas de tipo Monstruo: ");
            for (Map.Entry<String, Carta> entry : hashMapColeccionUsuario.entrySet()) {
                if (entry.getValue().getTipoCarta().equals("Monstruo")) {
                    System.out.println("- Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipoCarta() + ", Cantidad: " + entry.getValue().getCantidad());
                    tieneMonstruos = true;
                }
            }
            if (!tieneMonstruos) {
                System.out.println("No tiene cartas de tipo Monstruo.");
            }

            System.out.println("Cartas de tipo Hechizo: ");
            for (Map.Entry<String, Carta> entry : hashMapColeccionUsuario.entrySet()) {
                if (entry.getValue().getTipoCarta().equals("Hechizo")) {
                    System.out.println("- Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipoCarta() + ", Cantidad: " + entry.getValue().getCantidad());
                    tieneHechizos = true;
                }
            }
            if (!tieneHechizos) {
                System.out.println("No tiene cartas de tipo Hechizo.");
            }

            System.out.println("Cartas de tipo Trampa: ");
            for (Map.Entry<String, Carta> entry : hashMapColeccionUsuario.entrySet()) {
                if (entry.getValue().getTipoCarta().equals("Trampa")) {
                    System.out.println("- Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipoCarta() + ", Cantidad: " + entry.getValue().getCantidad());
                    tieneTrampas = true;
                }
            }
            if (!tieneTrampas) {
                System.out.println("No tiene cartas de tipo Trampa.");
            }
        }
    }

    @Override
    void mostrarCartasExistente() {
        for (Map.Entry<String, Carta> entry : hashMapTXT.entrySet()) {
            System.out.println("Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipoCarta());
        }
    }

    @Override
    void mostrarCartasExistenteOrdenada() {
        boolean tieneMonstruos = false;
        boolean tieneHechizos = false;
        boolean tieneTrampas = false;

        System.out.println("Cartas de tipo Monstruo: ");
        for (Map.Entry<String, Carta> entry : hashMapTXT.entrySet()) {
            if (entry.getValue().getTipoCarta().equals("Monstruo")) {
                System.out.println("- Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipoCarta());
                tieneMonstruos = true;
            }
        }
        if (!tieneMonstruos) {
            System.out.println("No tiene cartas de tipo Monstruo.");
        }

        System.out.println("Cartas de tipo Hechizo: ");
        for (Map.Entry<String, Carta> entry : hashMapTXT.entrySet()) {
            if (entry.getValue().getTipoCarta().equals("Hechizo")) {
                System.out.println("- Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipoCarta());
                tieneHechizos = true;
            }
        }
        if (!tieneHechizos) {
            System.out.println("No tiene cartas de tipo Hechizo.");
        }

        System.out.println("Cartas de tipo Trampa: ");
        for (Map.Entry<String, Carta> entry : hashMapTXT.entrySet()) {
            if (entry.getValue().getTipoCarta().equals("Trampa")) {
                System.out.println("- Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipoCarta());
                tieneTrampas = true;
            }
        }
        if (!tieneTrampas) {
            System.out.println("No tiene cartas de tipo Trampa.");
        }
    }
    
}