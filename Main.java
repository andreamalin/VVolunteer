//Diego Crespo
//Diego Alvarez
//Andrea Amaya
//Brandon Hernandez
//Laura Tamath

import java.util.Scanner;
public class Main{
	
	//Metodo principal
	public static void main (String args []){
		Scanner inputI = new Scanner(System.in);
		Controlador control = new Controlador();
			//Reportar reportar = new Reportar();

		int depa;
		String depar;
	

		do{
			System.out.print("Bienvenido a V-MEDIC+\nLa salud es un derecho de todos los seres humanos. Estamos para servirte\n----------------------\nA continuacion, se le presentan las siguientes opciones\n");
			System.out.println("1. Centro de salud\n2. Reportar\n3. Ayudar\n4. Salir\nPor favor ingrese el numero de la opcion que desea: ");
			control.setOpcion(inputI.nextInt()); 

			// Opcion para entrar a la cuenta y utilizar las funciones del programa
			if (control.getOpcion() == 1){
				boolean ver = false;
				boolean correcto = false;
				String user;
				String password;
				int x = 0;

				while (ver != true)
				{	
					System.out.println("Ingrese su Usuario");				//Falta mandar a comparar los datos ingresados
					user = sc.nextLine();									//Falta volver la variable "correcto" en true al verificar la autenticidad de los datos
					System.out.println("Ingrese su Usuario");
					password = sc.nextLine();			
					if (correcto == false) System.out.println("Error intente de nuevo");			

				}


			} else if (control.getOpcion() == 2){
				String nombre,correo,tel,dir,sint;
				System.out.println("Ingrese su Nombre");				
				nombre =control.getOpcion() sc.nextLine();	
				System.out.println("Ingrese su Correo Electronico");
				correo = sc.nextLine();	
				System.out.println("Ingrese su Telefono");
				tel = sc.nextLine();	
				System.out.println("Ingrese su direccion");
				dir = sc.nextLine();	
				System.out.println("Ingrese sus sintomas");	
				sint = sc.nextLine();
				reportar.SetInfo(nombre,correo,tel,dir,sint);
				x =0;
				while(x==0){
				
					if (reportar.enCamino() == false)
					System.out.println("Espere...");
					
					if (reportar.enCamino() == true){
					System.out.println("La ayuda va en camino");
					x=1;
				}
					
				}	
				Falta recibir dato de clase reportar y terminar
				
				nombre correo telefono dirrecion sintomas

			}
			else if (control.getOpcion() ==3){
				System.out.println("A continacion debe de seleccionar el departamento en el que se encuentra (en numeros)");
				System.out.println("1.Ciudad de Guatemala" + "\n" +"2.Quetzaltenango, Xela"+"\n"+"3.Sacatequepez, Antigua Guatemala"+"\n"+"4. Alta Verapaz, Coban"+"\n"+"5. Otro"+"\n"+"6. Salir");
				depar = sc.nextLine(); //Toma lo ingresado como String
				depa = Integer.parseInt(opc); //Convertir a entero el String
				if (depa == 1){
					Ayuda ayuda1 = new Ayuda("9 calle 7-33 zona 1");
					System.out.println(ayuda1);
						//llamada
				}
				else if (depa == 2){
					Ayuda ayuda2 = new Ayuda("8 avenida 8-77 zona 5");
					System.out.println(ayuda2);
						//llamada
				}
				else if (depa == 3){
					Ayuda ayuda3 = new Ayuda("2 avenida 3-17 zona 9");
					System.out.println(ayuda3);
						//llamada
				}
				else if (depa ==4){
					Ayuda ayuda4 = new Ayuda("3 calle 8-24 zonna 6");
					System.out.println(ayuda4);
						//llamada
				}
				else if (depa == 5){
					System.out.println("No contamos con sede en su ubicacion, sin embargo podemos brindarle informacion.");
						//llamada
				}
				else if (depa <= 7){
					System.out.println("Esta opcion no esta disponible");
				}
			}
				
			
			else{
				System.out.println("Opcion invalida, ingrese una valida");
			}
		} while(control.getOpcion() != 4);
	}	
}
