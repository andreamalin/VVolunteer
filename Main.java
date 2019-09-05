/**********************************************************
DriverVVolunteer.java		
Autores: Andrea Amaya, Diego Alvarez, Diego Crespo,
Brandon Hernandes, Laura Tamath
Fecha de creación: 31/09/2019
Última fecha de modificación: 04/09/2019
Clase realizada para interactuar con el Voluntario.
**********************************************************/

import java.util.Scanner;
public class Main{
	//Metodo principal
	public static void main (String[] args){

		// Instancia de objetos; input es para números y scan es para strings
		Scanner input = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		Controlador control = new Controlador();

		do{
			System.out.println("\n\n _________________________________________________ ");
			System.out.println("                Bienvenido a VMedic+               \n");
			System.out.println(" La salud es un derecho de todos los seres humanos ");
			System.out.println("               Estamos para servirte               ");
			System.out.println("\n\t\t 1. Centro de Salud \n\t\t 2. Reportar \n\t\t 3. Ayudar\n\t\t 4. Salir\n");
			System.out.print(" _________________________________________________ \nIngrese su opcion: ");
			control.setOpcion(input.nextInt()); 

			// Opcion para entrar a la cuenta y utilizar las funciones del programa
			if (control.getOpcion() == 1){

					System.out.print("\n\nIngrese su nombre de Usuario: ");				
					control.setUsername(scan.nextLine());							
					System.out.print("Ingrese su Contrasena: ");
					control.setPassword(scan.nextLine());		

					/*	
					if(control.centro.accountManager(control.getUsername(), control.getPassword()) == false){
						System.out.print("\nSus datos son invalidos, vuelva a intentar\n");
					} else{

						//------------------ Ingresando sesion ---------------------------
						System.out.println("\n\tBienvenido " + control.getUsername()); */
						do{
							System.out.print("\n\nEstas son las opciones que puede realizar:\n1. Ver inventario\n2. Recomendaciones para la siguiente jornada\n3. Ver medicinas\n4. Cerrar Sesion\nIngrese la opcion que desea realizar: ");
							control.setOpcion(input.nextInt());

							switch(control.getOpcion()){

								// Ver el inventario del centro de salud
								case 1:
									System.out.println("\nSe cuenta en el inventario con la siguiente medicina: ");
									for(int i = 0; i < 3; i++){
										System.out.print("- " + (control.centro.grafico.getInventario())[i].getNombreMedicamento() + " de la cual se tiene "  + (control.centro.grafico.getInventario())[i].getCantidadEnInventario() + " en el inventario\n");
									}
									
								break;

								// Obtener recomendaciones para la siguiente jornada
								case 2:

									for(int i = 0; i < 3; i++){
										System.out.print("Ingrese la cantidad de medicina necesitada en esta jornada de " + (control.centro.grafico.getInventario())[i].getNombreMedicamento() + ": ");
										control.agregarANecesitados(input.nextInt(),i);
									}

									// Mostrando las recomendacioes
									System.out.print(control.centro.grafico.elaborarDatos(control.getCantidadNecesitada()));

								break;

								// Buscar medicina
								case 3:
									System.out.print("Ingrese el nombre de la medicina a buscar: ");
									control.setMedicamento(scan.next());

									System.out.println(control.centro.informacion.buscarMedicamento(control.getMedicamento()));
									
								
								break;
							}

						}while(control.getOpcion() != 4);

						// Regresando a la opcion del ususuario para que no se termine el programa
						control.setOpcion(1);
					//}

			} else if (control.getOpcion() == 2){
				//Se piden los datos del usuario
				System.out.println("\n_________________________________________________\n");
				System.out.println("Ingrese su Nombre");				
				control.setNombre(scan.nextLine());
				System.out.println("Ingrese su Correo Electronico");
				control.setCorreo(scan.nextLine());	
				System.out.println("Ingrese su Telefono");
				control.setTel(scan.nextLine());
				System.out.println("Ingrese su direccion");
				control.setDireccion(scan.nextLine());
				System.out.println("Ingrese sus sintomas");	
				control.setSintomas(scan.nextLine());
				System.out.println("\n_________________________________________________\n");
				//Se manda la ayuda
				System.out.println(control.mandarAyuda());

			} else if (control.getOpcion() ==3){
				System.out.println("A continacion debe de seleccionar el departamento en el que se encuentra (en numeros)");
				System.out.println("1.Ciudad de Guatemala\n" +"2.Quetzaltenango, Xela\n"+"3.Sacatequepez, Antigua Guatemala\n"+"4. Alta Verapaz, Coban\n5. Otro");
				
				control.setDepartamento(input.nextInt());
				System.out.println("\n_________________________________________________\n\n"+control.mostrarInfoCentro()+"_________________________________________________");
			} else{
				System.out.println("Opcion invalida, ingrese una valida");
			}
		} while(control.getOpcion() != 4);
	}	
}