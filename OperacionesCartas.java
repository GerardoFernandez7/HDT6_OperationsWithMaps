import java.util.Scanner;

public class OperacionesCartas {

    public static void typeHash(){
        // Variables
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean continueProgram = true;
        
        // Instancias
        AbstractMap abstractMap;
        
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
                    
                    break;

                case 2:
                    System.out.println("Ha seleccionado la implentación TreeMap");
                    
                    break;
                
                case 3:
                    System.out.println("Ha seleccionado la implentación LinkedHashMap");
                    
                    break;
                
                case 4:
                    
                    break;
            
                default:
                    System.out.println("Ingrese una opción válida.");
                    break;
            }
        }
        
    }
    
}