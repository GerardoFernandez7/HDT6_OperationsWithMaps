import java.util.Scanner;

public class OperacionesCartas {
    // Instancias
    static AbstractMap map;

    public void typeHash(){
        // Variables
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean continueProgram = true;

        while(continueProgram){
            // Mensaje
            System.out.println();
            System.out.println("----------BIENVENIDO----------");
            System.out.println("Elija la implementación de MAP con la que desea trabajar.");
            System.out.println("1. HashMap");
            System.out.println("2. TreeMap");
            System.out.println("3. LinkedHashMap");
            System.out.println("4. Salir");

            // Solicitud de input
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ha seleccionado la implentación HashMap");
                    map = new HashMapImplementation();// Aquí se aplica Factory
                    accionesUsuario();
                    
                    break;

                case 2:
                    System.out.println("Ha seleccionado la implentación TreeMap");
                    map = new TreeMapImplementation();// Aquí se aplica Factory
                    accionesUsuario();

                    break;
                
                case 3:
                    System.out.println("Ha seleccionado la implentación LinkedHashMap");
                    map = new LinkedHashMapImplementation();// Aquí se aplica Factory
                    accionesUsuario();
                   
                    break;
                
                case 4:
                    continueProgram = false;
                    System.out.println("Saliendo...");
                    
                    break;
            
                default:
                    System.out.println("Ingrese una opción válida.");
                    break;
            }
        }
    }

    public void opcionesUsuario(){
        System.out.println();
        System.out.println("-------Opciones Usuario-------");
        System.out.println("1. Agregar carta a la colección de usuario");
        System.out.println("2. Mostrar el tipo de una carta en específico");
        System.out.println("3. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección");
        System.out.println("4. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección, ordenadas por tipo");
        System.out.println("5. Mostrar el nombre y tipo de todas las cartas existentes");
        System.out.println("6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo");
        System.out.println("7. Regresar a menú principal");
    }

    public void accionesUsuario() {
        // Variables del método
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        boolean continueProgram = true;

        map.leerArchivo("cards_desc.txt");
        while (continueProgram) {
            opcionesUsuario();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    map.agregarCarta();
                    break;
                case 2:
                    map.mostrarTipoCarta();
                    break;
                case 3:
                    map.mostrarColeccionUsuario();
                    break;
                case 4:
                    map.mostrarColeccionUsuarioOrdenada();
                    break;
                case 5:
                    map.mostrarCartasExistente();
                    break;
                case 6:
                    map.mostrarCartasExistenteOrdenada();
                    break;
                case 7:
                    continueProgram = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
}