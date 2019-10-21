/**********************************************************
Main.java	
Integrantes grupo:
-> Andrea Amaya 19357
-> Diego Alvarez 19498
-> Diego Crespo 19541
-> Brandon Hernandez 19376
-> Laura Tamath 19365	

Autores de la clase:
NO SE QUIEN LA CREOOOOOO

Fecha de creación: 31/09/2019
Última fecha de modificación: 20/10/2019

Vista encargada del primer Y segundo controlador
**********************************************************/
import java.util.Scanner;

public class VistaCentroSalud{
	Scanner input = new Scanner(System.in);
	Scanner scan = new Scanner(System.in);

	// Obteniendo el nombre y contraseña del usuario
	public String[] inicioSesion(){
		String[] datosUsuario = new String[2];
		System.out.print("|\n| Usted esta tratando de iniciar sesion\n");
		System.out.print("| Ingrese su nombre de Usuario: ");				
		datosUsuario[0] = scan.nextLine();							
		System.out.print("| Ingrese su Contrasena: ");
		datosUsuario[1] = scan.nextLine();	

		return datosUsuario;
	}

	// Menu adentro del sistema
	public Integer menuCentroSalud(String nombreUsuario){
		String opcionS;
		Integer opcion = 0;
		Boolean bandera = false;

		// Mostrando el menu de inicio de sesion
		System.out.println("|\n|\tBienvenid@ " + nombreUsuario ); 
		System.out.println("|___________________________________________________");
		System.out.println("|Estas son las opciones que puede realizar:\t    |");
		System.out.println("| 1. Ver inventario\t\t\t\t    |");
		System.out.println("| 2. Recomendaciones para la siguiente jornada\t    |");
		System.out.println("| 3. Ver medicinas\t\t\t\t    |");
		System.out.println("| 4. Buscar medicina por sintomas\t\t    |");
		System.out.println("| 5. Cerrar Sesion\t\t\t\t    |");
		System.out.println("|___________________________________________________|");

		// Pidiendole al usuario que ingrese una opcion valida
		do{
			System.out.print("| Ingrese la opcion que desea realizar: ");
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


	// Mostrandole al usuario que los datos ingresados fueron invalidos
	public void datosInvalidos(){
		System.out.print("| Sus datos son invalidos\n");
	}

	// // Obtener el centro de salud con el cual quiere interactuar el usuario
	// public void obtenerCentroDeSalud(Controlador control){
	// 	Integer centroDeSaludSeleccionado, cantidadCentrosMostrados = 0;

	// 	// Mostrandole los centros de salud que puede utilizar
	// 	System.out.print("\nEstos son los centros de salud con los que posee comunicacion: ");
	// 	for(int i = 0; i < control.getLength(); i++){
	// 		if(control.numeroIdentificacion()){
	// 			System.out.print("\n" + (cantidadCentrosMostrados + 1) + ". " + control.getNombre(i));
	// 			cantidadCentrosMostrados++;
	// 		}
	// 	}

	// 	// Obteniendo el centro de salud que quiere el usuario
	// 	do{	
	// 		System.out.print("\nIngrese el centro de salud con el cual desea interactuar: ");
	// 		centroDeSaludSeleccionado = input.nextInt();
	// 	}while((centroDeSaludSeleccionado < 0) || (centroDeSaludSeleccionado > cantidadCentrosMostrados));

	// 	control.setOpcion(centroDeSaludSeleccionado);
	// }


	// public void mostrarInventario(Controlador control){
	// 	Integer j = control.obtenerPosicionCentroSalud();
	// 	System.out.println("\nSe cuenta en el inventario de " + control.getCentroSalud().getGrafico()[j].getCentroSaludNombre() + " con las siguientes medicinas: ");
	// 		for(int i = 0; i < 3; i++){
	// 	 		System.out.print("- " + (control.getCentroSalud().getGrafico()[j].getInventario())[i].getNombreMedicamento() + " de la cual se tiene "  + (control.getCentroSalud().getGrafico()[j].getInventario())[i].getCantidadEnInventario() + " en el inventario\n");
	// 		}
	// 	}

	// // Pidiendole al usuario los medicamentos utilizados en la jornada 
	// public void pedirMedicinaNecesitada(Controlador control){
	// 	Integer j = control.obtenerPosicionCentroSalud();
	// 	for(int i = 0; i < 3; i++){
	// 	 	System.out.print("Ingrese la cantidad de medicina necesitada en esta jornada de " + (control.getCentroSalud().getGrafico()[j].getInventario())[i].getNombreMedicamento() + ": ");
	// 		 control.agregarANecesitados(input.nextInt(),i);
	// 	}
	// 	System.out.print(control.getCentroSalud().getGrafico()[j].elaborarDatos(control.getCantidadNecesitada()));
	// }

	// //Vistas programa
	
	
	















	
	// public void opcion2(Controlador controlA){
	// 	System.out.println("\n_________________________________________________\n");
	// 	System.out.print("Ingrese su Nombre: ");				
	// 	controlA.setNombre(scan.nextLine());
	// 	System.out.print("Ingrese su Correo Electronico: ");
	// 	controlA.setCorreo(scan.nextLine());	
	// 	System.out.print("Ingrese su Telefono: ");
	// 	controlA.setTel(scan.nextLine());
	// 	System.out.print("Ingrese su direccion: ");
	// 	controlA.setDireccion(scan.nextLine());
	// 	System.out.print("Ingrese sus sintomas: ");	
	// 	controlA.setSintomas(scan.nextLine());
	// 	//Se manda la ayuda
	// 	System.out.println(vista.mandarayudaV(controlA));
	// }
	// public void opcion3(Controlador controlA){
	// 	System.out.println(vista.opcionv());		
	// 	controlA.setDepartamento(input.nextInt());
	// 	System.out.println(vista.mostrarinfocentroV(controlA));
	// }
	// public void escogerOpcion(Controlador control, Controlador controlA){
	// 	// Opcion para entrar a la cuenta y utilizar las funciones del programa
	// 	if (control.getOpcion() == 1){
	// 		opcion1(control);
			


	// 				switch(control.getOpcion()){
	// 				// Ver el inventario del centro de salud
	// 				case 1:
	// 					// Verificar cual centro de salud quiere

	// 					obtenerCentroDeSalud(control);
	// 					System.out.print(mostrarInventario(control));
	// 					break;

	// 				// Obtener recomendaciones para la siguiente jornada
	// 				case 2:
	// 					vista.obtenerCentroDeSalud(control);
	// 					System.out.print(vista.pedirMedicinaNecesitada(control));
	// 					break;

	// 				// Buscar medicina
	// 				case 3:
	// 					System.out.print("Ingrese el nombre de la medicina a buscar: ");
	// 					control.setMedicamento(scan.nextLine());

	// 					control.getCentroSalud().getMedicamento().buscarMedicamento(control.getMedicamento());
	// 					System.out.println(control.getCentroSalud().getMedicamento().mostrarInformacion());
	// 					break;

	// 				//Buscar medicina por sintomas
	// 				case 4:
	// 				//Se pide un maximo de 3 sintomas
	// 					System.out.println("Ingrese el primer sintoma: ");
	// 					control.setSintoma1(scan.nextLine());
	// 					System.out.println("Ingrese el segundo sintoma: ");
	// 					control.setSintoma2(scan.nextLine());
	// 					System.out.println("Ingrese el tercer sintoma: ");
	// 					control.setSintoma3(scan.nextLine());

	// 					control.getCentroSalud().getMedicamento().buscarSintomas(control.getSint1(), control.getSint2(), control.getSint3());
	// 					System.out.println(control.getCentroSalud().getMedicamento().mostrarRecomendados());
	// 		} while(control.getOpcion() != 5);
	// 			// Regresando a la opcion del usuario para que no se termine el programa
	// 			control.setOpcion(1);
	// 		}
		
	// 	}
	// 	// Reportar a un voluntariado que necesita ayuda
	// 	} else if (control.getOpcion() == 2){
	// 		opcion2(controlA);
	// 	// Ayudar es para que pueda ir a ayudar a un centro de salud
	// 	} else if (control.getOpcion() == 3){
	// 		opcion3(controlA);
	// }














}
