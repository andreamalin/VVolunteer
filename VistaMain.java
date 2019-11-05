/**********************************************************
VistaMain.java	
Integrantes grupo:
-> Andrea Amaya 19357
-> Diego Alvarez 19498
-> Diego Crespo 19541
-> Brandon Hernandez 19376
-> Laura Tamath 19365	

Autores de la clase:
-> Andrea Amaya 19357
Fecha de creación: 20/10/2019
Última fecha de modificación: 20/10/2019

Vista a cargo del Main
**********************************************************/
import java.util.Scanner;

public class VistaMain{
	Scanner scan = new Scanner(System.in);

	// Menu principal
	public Integer MenuPrincipal(){
		String opcionS;
		Integer opcion = 0;
		Boolean bandera = false;

		// Mostrando el menu principal
		System.out.println("\n\n ___________________________________________________ ");
		System.out.print("|                Bienvenido a VMedic+               |\n| La salud es un derecho de todos los seres humanos |\n");
		System.out.println("|\t\tEstamos para servirte\t\t    |\n|\t\t\t\t\t\t    |");
		System.out.println("|\t 1. Centro de Salud\t\t\t    |");
		System.out.println("|\t 2. Registrar Peticion de Ayuda\t\t    |");
		System.out.println("|\t 3. Registrar Donacion\t\t\t    |");
		System.out.println("|\t 4. Reportar Voluntario/Paciente\t    |");
		System.out.println("|\t 5. Salir\t\t\t\t    |");
		System.out.print("|___________________________________________________|");
		
		// Pidiendole al usuario que ingrese una opcion valida
		do{
			System.out.print("\n| Ingrese su opcion: ");
			opcionS = scan.nextLine();
		
			// Viendo si es un numero lo ingresado
			try{
				Integer.parseInt(opcionS);
				bandera = true;
			}catch(NumberFormatException nfe){
				bandera = false;
				System.out.print("| Favor ingrese una opcion, con numeros ");
			}
		}while(bandera == false);
			

		// Convirtiendo la opcion string a una opcion entera
		opcion = Integer.parseInt(opcionS);
		return opcion;
	}

	// Mostrando opciones que no necesitan operaciones
	public void opcionDefault(Integer opcion){
		switch(opcion){
			// Mensaje para salir del programa
			case 5:
				System.out.println("| Gracias por utilizar VMedic+");
				System.out.println("|___________________________________________________");
			break;

			// Mensaje para decirle al usuario que la opcion es invalida
			default:
				System.out.println("| Opcion invalida, ingrese una valida");
				System.out.println("|___________________________________________________");
			break;
		}
	}

}