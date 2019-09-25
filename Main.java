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
-> Diego Alvarez 19498
Fecha de creación: 31/09/2019
Última fecha de modificación: 24/09/2019

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
		SegundoControlador controlA = new SegundoControlador();

		Vista vista = new Vista();

		// Iniciando el programa
		do{
			System.out.println("\n\n _________________________________________________ ");
			System.out.println("                Bienvenido a VMedic+               \n");
			System.out.println(" La salud es un derecho de todos los seres humanos ");
			System.out.println("               Estamos para servirte               ");
			System.out.println("\n\t\t 1. Centro de Salud \n\t\t 2. Reportar \n\t\t 3. Ayudar\n\t\t 4. Salir\n");
			System.out.print(" _________________________________________________ \nIngrese su opcion: ");
			control.defensa(input.next());
			while(control.getBandera()==false){
				System.out.println(" Favor ingrese una opcion, numeros ");
				control.defensa(input.next());
				if(control.getBandera()==true){
					control.setOpcion(control.getOpcion()); 
				}
			}
			

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
						System.out.println(vista.bienvenidav()); 
						do{
							System.out.print(vista.menuv());
							// Se verifica si lo ingresado es un numero o son palabras
							control.defensa(input.next()); 

				 			while(control.getBandera()==false){
								System.out.println(" Favor ingrese una opcion, numeros ");
								control.defensa(input.next());
								if(control.getBandera()==true){
									control.setOpcion(control.getOpcion()); 
								}
							}
							switch(control.getOpcion()){

								// Ver el inventario del centro de salud
								case 1:
									// Verificar cual centro de salud quiere
									vista.obtenerCentroDeSalud(control, input);
									vista.mostrarInventario(control, control.obtenerPosicionCentroSalud());
							
								break;

								// Obtener recomendaciones para la siguiente jornada
								case 2:

									vista.obtenerCentroDeSalud(control, input);
									vista.pedirMedicinaNecesitada(control, control.obtenerPosicionCentroSalud(), input);

									// Mostrando las recomendacioes
									//System.out.print(control.getCentroSalud().getGrafico()[control.obtenerPosicionCentroSalud()].elaborarDatos(control.getCantidadNecesitada()));
									System.out.print(vista.mostrarrecomendacionesv());

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
									controlA.setSintoma1(scan.next());
									System.out.println("Ingrese el segundo sintoma: ");
									controlA.setSintoma2(scan.next());
									System.out.println("Ingrese el tercer sintoma: ");
									controlA.setSintoma3(scan.next());

									control.getCentroSalud().getMedicamento().buscarSintomas(controlA.getSint1(), controlA.getSint2(), controlA.getSint3());
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
				controlA.setNombre(scan.nextLine());
				System.out.print("Ingrese su Correo Electronico: ");
				controlA.setCorreo(scan.nextLine());	
				System.out.print("Ingrese su Telefono: ");
				controlA.setTel(scan.nextLine());
				System.out.print("Ingrese su direccion: ");
				controlA.setDireccion(scan.nextLine());
				System.out.print("Ingrese sus sintomas: ");	
				controlA.setSintomas(scan.nextLine());
			//	System.out.println("\n_________________________________________________\n");   SE AGREGO ESTE TEXTO EN EL METODO MANDARAYUDAV
				//Se manda la ayuda
				System.out.println(vista.mandarAyudaV());

			// Ayudar es para que pueda ir a ayudar a un centro de salud
			} else if (control.getOpcion() == 3){
			//	System.out.println("A continacion debe de seleccionar el departamento en el que se encuentra (en numeros)");    SE AGREGO ESTE TEXTO Y EL QUE ESTABA DESPUES EN METODO OPCIONV
				System.out.println(vista.opcionv());
				
				controlA.setDepartamento(input.nextInt());
				System.out.println(vista.mostrarinfocentroV());
			
			// Salir del programa y defensiva por si no es ninguna opcion
			} else if (control.getOpcion() == 4){
				System.out.println("Gracias por utilizar VMedic+");

			} else{
				System.out.println("Opcion invalida, ingrese una valida");
			}
		} while(control.getOpcion() != 4);
	}	
}