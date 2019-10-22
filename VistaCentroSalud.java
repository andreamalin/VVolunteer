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
	public Integer menuCentroSalud(String nombreUsuario, String noti){
		String opcionS;
		Integer opcion = 0;
		Boolean bandera = false;

		// Mostrando el menu de inicio de sesion
		System.out.println("|\n|\n|\t\tBienvenid@ " + nombreUsuario ); 
		System.out.println("|___________________________________________________");
		System.out.println("|                   Notificaciones:                 ");
		System.out.println("|         Nombre: Numero: Direccion: Sintomas:      ");
		System.out.println("|\n"+noti);
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



	// OPCION 3 que quiere ver los medicamentos
	public String pidiendoMedicamento(){
		String medicamento;
		System.out.print("| Ingrese el nombre de la medicina a buscar: ");
		medicamento = scan.nextLine();

		return medicamento;
	}
	
	// OPCION 4 que quiere buscar por sintomas
	public String[] obtenerSintomas(){
		String[] sintomas = new String[3];

		// Pidiendole los sintomas al paciente
		System.out.print("| Ingrese el primer sintoma: ");
		sintomas[0] = scan.nextLine();
		System.out.print("| Ingrese el segundo sintoma: ");
		sintomas[1] = scan.nextLine();
		System.out.print("| Ingrese el tercer sintoma: ");
		sintomas[2] = scan.nextLine();

		return sintomas;
	}

	// Mostrando cualquier mensaje
	public void mostrandoMensaje(String informacion){
		System.out.print(informacion);
	}

	// Mostrandole al usuario que los datos ingresados fueron invalidos
	public void datosInvalidos(){
		System.out.print("| Los datos ingresados son invalidos\n");
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

}
