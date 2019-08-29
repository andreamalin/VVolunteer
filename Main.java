//Diego Crespo
//Diego Alvarez
//Andrea Amaya
//Brandon Hernandez
//Laura Tamath

import java.util.Scanner;
public class Main{
	
	//Metodo principal
	public static void main (String args []){
		Scanner sc = new Scanner(System.in);
		//Atributos
		int opcion; //Convierte a enter la opción elegida
		String opc; //Recibe el dato tipo String de la opcion elegirá

		opcion = 0;
		while (opcion != 4){
			System.out.println("Bienvenido a V-MEDIC+");
			System.out.println("La salud es un derecho de todos los seres humanos. Estamos para servirte");
			System.out.println("----------------------" + "\n");
			System.out.println("A continuacion, se le presentan las siguientes opciones");
			System.out.println("1. Centro de salud");
			System.out.println("2. Reportar");
			System.out.println("3. Ayudar");
			System.out.println("4. Salir");
			System.out.println("Por favor ingrese el numero de la opcion que desea" + "\n");
			opc = sc.nextLine(); //Toma lo ingresado como String
			opcion = Integer.parseInt(opc); //Convertir a entero el String
			System.out.println("\n");

			if (opcion ==1){

			}	
			else if (opcion ==2){

			}
			else if (opcion ==3){

			}
			else if (opcion >=4){
				System.out.println("Esta opcion no esta disponible")
			}

		}
	}	
}
