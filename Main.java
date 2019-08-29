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
		Reportar reportar = new Reportar();
		Ayudar ayudar = new Ayudar();



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
				boolean ver = false;
				boolean correcto = false;
				String user;
				String password;
				int x = 0;

				while (ver !=true)
				{	
					System.out.println("Ingrese su Usuario");				//Falta mandar a comparar los datos ingresados
					user = sc.nextLine();									//Falta volver la variable "correcto" en true al verificar la autenticidad de los datos
					System.out.println("Ingrese su Usuario");
					password = sc.nextLine();			
					if (correcto = false) System.out.println("Error intente de nuevo");			

				}
				

			}	
			else if (opcion ==2){
				String nombre,correo,tel,dir,sint;
				System.out.println("Ingrese su Nombre");				
				nombre = sc.nextLine();	
				System.out.println("Ingrese su Correo Electronico");
				correo = sc.nextLine();	
				System.out.println("Ingrese su Telefono");
				tel = sc.nextLine();	
				System.out.println("Ingrese su direccion");
				dir = sc.nextLine();	
				System.out.println("Ingrese sus sintomas");	
				sint = sc.nextLine();
				reportar.SetInfo(nombre,correo,tel,dir,sint);
				while(x==0){
				
					if (reportar.enCamino() == false)
					System.out.println("Espere...");
					
					if (reportar.enCamino() == true){
					System.out.println("La ayuda va en camino");
					x=1;
				}
					
				}	
				//Falta recibir dato de clase reportar y terminar
				
				//nombre correo telefono dirrecion sintomas

			}
			else if (opcion ==3){


			}
			else if (opcion >=4){
				System.out.println("Esta opcion no esta disponible")
			}	

		}
	}	
}
