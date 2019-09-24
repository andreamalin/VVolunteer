/**********************************************************
Main.java	
Integrantes grupo:
-> Andrea Amaya 19357
-> Diego Alvarez 19498
-> Diego Crespo 19541
-> Brandon Hernandez 19376
-> Laura Tamath 19365	

Autores de la clase:
-> Diego Crespo 19541
-> Laura Tamath 19365
Fecha de creación: 31/09/2019
Última fecha de modificación: 05/09/2019

La clase main se encarga de mostrar todos los datos que el usuario solicita,
los manda al controlador.
**********************************************************/
import java.util.Scanner;

public class Main{
	//Metodo principal
	public static void main (String[] args){

		// Instancia de objetos; input es para números y scan es para strings
		Scanner input = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		Controlador control = new Controlador();
		Vista vista = new Vista();

		// Iniciando el programa
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

					if(control.getCentroSalud().accountManager(control.getUsername(), control.getPassword()) == false){
						System.out.print("\nSus datos son invalidos, vuelva a intentar\n");
					} else{

						//------------------ Ingresando sesion ---------------------------
						System.out.println("\n\tBienvenid@ " + control.getUsername()); 
						do{
							System.out.print("\n\nEstas son las opciones que puede realizar:\n1. Ver inventario\n2. Recomendaciones para la siguiente jornada\n3. Ver medicinas\n4. Buscar medicina por sintomas\n5. Cerrar Sesion\nIngrese la opcion que desea realizar: ");
							control.setOpcion(input.nextInt()); 
				 	
							switch(control.getOpcion()){

								// Ver el inventario del centro de salud
								case 1:

									// Verificar cual centro de salud quiere
									vista.obtenerCentroDeSalud(control, input);
									vista.mostrarInventario(control, control.obtenerPosicionCentroSalud());
							
								break;

								// Obtener recomendaciones para la siguiente jornada
								case 2:

									// for(int i = 0; i < 3; i++){
									// 	System.out.print("Ingrese la cantidad de medicina necesitada en esta jornada de " + (control.getCentroSalud().getGrafico().getInventario())[i].getNombreMedicamento() + ": ");
									// 	control.agregarANecesitados(input.nextInt(),i);
									// }

									// // Mostrando las recomendacioes
									// System.out.print(control.getCentroSalud().getGrafico().elaborarDatos(control.getCantidadNecesitada()));
									// System.out.print("Actualizando inventario..... el inventario se ha actualizado");

								break;

								// Buscar medicina
								case 3:
									System.out.print("Ingrese el nombre de la medicina a buscar: ");
									control.setMedicamento(scan.next());

									control.getCentroSalud().getMedicamento().buscarMedicamento(control.getMedicamento());
									System.out.println(control.getCentroSalud().getMedicamento().mostrarInformacion());
								
								break;

								//Buscar medicina por sintomas
								case 4:
									//Se pide un maximo de 3 sintomas
									System.out.println("Ingrese el primer sintoma: ");
									control.setSintoma1(scan.next());
									System.out.println("Ingrese el segundo sintoma: ");
									control.setSintoma2(scan.next());
									System.out.println("Ingrese el tercer sintoma: ");
									control.setSintoma3(scan.next());

									control.getCentroSalud().getMedicamento().buscarSintomas(control.getSint1(), control.getSint2(), control.getSint3());
									System.out.println(control.getCentroSalud().getMedicamento().mostrarRecomendados());

							}

						}while(control.getOpcion() != 5);

						// Regresando a la opcion del ususuario para que no se termine el programa
						control.setOpcion(1);
					}

			// Reportar a un voluntariado que necesita ayuda
			} else if (control.getOpcion() == 2){
				//Se piden los datos del usuario
				System.out.println("\n_________________________________________________\n");
				System.out.print("Ingrese su Nombre: ");				
				control.setNombre(scan.nextLine());
				System.out.print("Ingrese su Correo Electronico: ");
				control.setCorreo(scan.nextLine());	
				System.out.print("Ingrese su Telefono: ");
				control.setTel(scan.nextLine());
				System.out.print("Ingrese su direccion: ");
				control.setDireccion(scan.nextLine());
				System.out.print("Ingrese sus sintomas: ");	
				control.setSintomas(scan.nextLine());
				System.out.println("\n_________________________________________________\n");
				//Se manda la ayuda
				System.out.println(control.mandarAyuda());

			// Ayudar es para que pueda ir a ayudar a un centro de salud
			} else if (control.getOpcion() == 3){
				System.out.println("A continacion debe de seleccionar el departamento en el que se encuentra (en numeros)");
				System.out.println("1.Ciudad de Guatemala\n" +"2.Quetzaltenango, Xela\n"+"3.Sacatequepez, Antigua Guatemala\n"+"4. Alta Verapaz, Coban\n5. Otro\nIngrese en donde se encuentra: ");
				
				control.setDepartamento(input.nextInt());
				System.out.println("\n_________________________________________________\n\n"+control.mostrarInfoCentro()+"_________________________________________________");
			
			// Salir del programa y defensiva por si no es ninguna opcion
			} else if (control.getOpcion() == 4){
				System.out.println("Gracias por utilizar VMedic+");

			} else{
				System.out.println("Opcion invalida, ingrese una valida");
			}
		} while(control.getOpcion() != 4);
	}	
}