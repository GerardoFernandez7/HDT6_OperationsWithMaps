import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LinkedHashMapImplementation extends AbstractMap{
    public LinkedHashMapImplementation(){
    }
    public static Map<String, String> linkedHashMapTXT = new LinkedHashMap<>();
    public static Map<String, Carta> coleccionUsuario = new LinkedHashMap<>();

    /**
     * Lee información relevante desde un archivo.
     *
     * @param archivoTXT
     */
    @Override
    void leerArchivo(String archivoTXT) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoTXT))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en nombre y tipo usando el separador "|"
                String[] partes = linea.split("\\|");

                if (partes.length == 2) {
                    String nombreCarta = partes[0].trim();
                    String tipoCarta = partes[1].trim();

                    // Almacenar en el HashMap
                    linkedHashMapTXT.put(nombreCarta, tipoCarta);
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
        System.out.println("Ingrese el nombre de la carta que desea agregar:");
        Scanner sc = new Scanner(System.in);
        String nombreCarta = sc.nextLine();
        if (linkedHashMapTXT.containsKey(nombreCarta)) {
            String tipoCarta = linkedHashMapTXT.get(nombreCarta);
            Carta newCarta = new Carta(tipoCarta);
            if(coleccionUsuario.containsKey(nombreCarta)) {
                int cantidad = coleccionUsuario.get(nombreCarta).getCantidad() + 1;
                newCarta.setCantidad(cantidad);
                coleccionUsuario.put(nombreCarta, newCarta);
                System.out.println("Carta agregada correctamente");

            }else{
                newCarta.setCantidad(1);
                coleccionUsuario.put(nombreCarta, newCarta);
            }

        } else {
            System.out.println("La carta no existe en el archivo");
        }

    }

    @Override
    void mostrarTipoCarta() {
        System.out.println("Ingrese el nombre de la carta que desea ver:");
        Scanner sc = new Scanner(System.in);
        String nombreCarta = sc.nextLine();
        if (coleccionUsuario.containsKey(nombreCarta)) {
            System.out.println("Nombre: " + nombreCarta + ", Tipo: " + coleccionUsuario.get(nombreCarta).getTipoCarta());
        }else{
            System.out.println("La carta ingresada no existe en la colección");
        }
    }

    @Override
    void mostrarColeccionUsuario() {
        System.out.println("-----CARTAS-----\n");
        if(!coleccionUsuario.isEmpty()){
            for (Map.Entry<String, Carta> entry : coleccionUsuario.entrySet()) {
                System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipoCarta() + ", Cantidad: " + entry.getValue().getCantidad());
            }
        }else{
            System.out.println("No hay cartas en la colección");
        }
    }

    @Override
    void mostrarColeccionUsuarioOrdenada() {
        System.out.println("-----CARTAS ORDENAS POR TIPO-----\n");
        if(!coleccionUsuario.isEmpty()){
            System.out.println("*Cartas tipo Mounstruo:");
            for (Map.Entry<String, Carta> entry : coleccionUsuario.entrySet()) {
                if(entry.getValue().getTipoCarta().equals("Monstruo")){
                    System.out.println("  Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipoCarta() + ", Cantidad: " + entry.getValue().getCantidad());
                }
            }
            System.out.println("*Cartas tipo Hechizo:");
            for (Map.Entry<String, Carta> entry : coleccionUsuario.entrySet()) {
                if(entry.getValue().getTipoCarta().equals("Hechizo")){
                    System.out.println("  Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipoCarta() + ", Cantidad: " + entry.getValue().getCantidad());
                }
            }
            System.out.println("*Cartas tipo Trampa:");
            for (Map.Entry<String, Carta> entry : coleccionUsuario.entrySet()) {
                if(entry.getValue().getTipoCarta().equals("Trampa")){
                    System.out.println("  Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipoCarta() + ", Cantidad: " + entry.getValue().getCantidad());
                }
            }
        }else{
            System.out.println("No hay cartas en la colección");
        }
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
