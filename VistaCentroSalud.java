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
	private Scanner scan = new Scanner(System.in);

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
		System.out.println("|\n|\n|\t\tBienvenid@ " + nombreUsuario ); 
		System.out.println("|___________________________________________________");
		System.out.println("|___________________________________________________|");
		System.out.println("|Estas son las opciones que puede realizar:\t    |");
		System.out.println("| 1. Ver inventario de medicina\t\t\t    |");
		System.out.println("| 2. Recomendaciones para la siguiente jornada\t    |");
		System.out.println("| 3. Ver medicinas\t\t\t\t    |");
		System.out.println("| 4. Buscar medicina por sintomas\t\t    |");
		System.out.println("| 5. Agregar medicina\t\t\t\t    |");
		System.out.println("| 6. Centro de Notificaciones\t\t\t    |");
		System.out.println("| 7. Cerrar Sesion\t\t\t\t    |");
		System.out.println("|___________________________________________________|");

		// Pidiendole al usuario que ingrese una opcion valida
		do{
			System.out.print("| Ingrese la opcion que desea realizar: ");
			opcionS = scan.nextLine();
		
		}while(tryCatch(opcionS) == false);
			

		// Convirtiendo la opcion string a una opcion entera 
		opcion = Integer.parseInt(opcionS);

		return opcion;
	}

	// OPCION 1 Y 2
	// Obtener el centro de salud con el cual quiere interactuar el usuario
	public Integer obtenerCentroDeSalud(String[] informacion){
		Integer centroDeSaludSeleccionado, cantidadCentrosMostrados = informacion.length;
		String opcionS;

		// Mostrandole los centros de salud que puede utilizar
		System.out.print("|\n| Estos son los centros de salud con los que posee comunicacion: ");
		for(int i = 0; i < cantidadCentrosMostrados; i++){
			System.out.print(informacion[i]);
		}
		System.out.print("\n");
		// Obteniendo el centro de salud que quiere el usuario
		do{
			do{	
				System.out.print("| Ingrese el centro de salud con el cual desea interactuar: ");
				opcionS = scan.nextLine();
				
			}while(tryCatch(opcionS) == false);

			centroDeSaludSeleccionado = Integer.parseInt(opcionS);

		}while((centroDeSaludSeleccionado < 0) || (centroDeSaludSeleccionado > cantidadCentrosMostrados));	

		centroDeSaludSeleccionado--;
		return centroDeSaludSeleccionado;
	}

	// OPCION 2
	// Pidiendole al usuario los medicamentos utilizados en la jornada 
	public Integer[] pedirMedicinaNecesitada(String[] datosMedicamentos){
		// Inicializando las variables en donde se guardan los medicamentos
		Integer[] cantidadMedicamentos = new Integer[datosMedicamentos.length];
		String[] cantidadMedicamentosS = new String[datosMedicamentos.length];

		for(int i = 0; i < datosMedicamentos.length; i++){
			 do{	
			 	// Pidiendole el tipo de medicamento que utilizo
				System.out.print("| Ingrese la cantidad de medicina necesitada en esta jornada de " + datosMedicamentos[i] + ": ");
				cantidadMedicamentosS[i] = scan.nextLine();

			}while(tryCatch(cantidadMedicamentosS[i]) == false);

			cantidadMedicamentos[i] = Integer.parseInt(cantidadMedicamentosS[i]);
		}
		return cantidadMedicamentos;
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

	//OPCION 5 pedir informacion del medicamento
	public String[] obtenerNuevoMed(){
		String[] info = new String[5];

		// Pidiendole los datos
		System.out.print("| Ingrese el nombre del medicamento: ");
		info[0] = scan.nextLine();
		System.out.print("| Ingrese el primer sintoma que alivia: ");
		info[1] = scan.nextLine();
		System.out.print("| Ingrese el segundo sintoma que alivia: ");
		info[2] = scan.nextLine();
		System.out.print("| Ingrese el tercer sintoma que alivia: ");
		info[3] = scan.nextLine();
		System.out.print("| Ingrese la dosis recomendada: ");
		info[4] = scan.nextLine();

		return info;
	}	

	//OPCION 6 montando notificaciones del centro de notificaciones
	public void notificaciones(String noti, String recomendaciones){
		System.out.println("|                   Notificaciones:                 \n|");
		System.out.println("|       Peticiones de ayuda      ");
		System.out.print("| Nombre - Numero - Direccion - Sintomas      ");
		System.out.println(noti);
		System.out.print("| Recomendaciones para la siguiente jornada en Resguardando Tu Salud");
		System.out.println(recomendaciones);
	}

	//Se pregunta al usuario si desea eliminar una notificacion
	public int[] preguntarEliminar(){
		int[] borrarNotificacion = new int[2];
		Boolean bandera = false;
		//Se pregunta al usuario si desea eliminar una notificacion
		System.out.println("| 	Desea borrar alguna notificacion?\n|1. Peticiones de ayuda\n|2. Recomendaciones de jornada\n|3. No borrar ninguna notificacion ");
		String opcion = scan.nextLine();
		do{
			System.out.print("| Ingrese el centro de salud con el cual desea interactuar: ");
			opcion = scan.nextLine();
		}while(tryCatch(opcion) == false);
		
		borrarNotificacion[0] = Integer.parseInt(opcion);
		bandera = false; //Se regresa a falso

		//Se pregunta al usuario que notificacion se desea eliminar
		if (borrarNotificacion[0]== 1 || borrarNotificacion[0] == 2) {
			System.out.println("| Ingrese el numero notificacion a eliminar: ");
			String numero = scan.nextLine();
			while (bandera == false){
				try{
					Integer.parseInt(numero);
					bandera = true;
					borrarNotificacion[1] = Integer.parseInt(numero);
				}catch(NumberFormatException nfe){
					bandera = false;
					System.out.print("| Favor ingrese una opcion, con numeros ");
				}
			}
		}

		return borrarNotificacion;
	}

	// FUNCIONALIDADES VARIAS
	// Mostrando cualquier mensaje
	public void mostrandoMensaje(String informacion){
		System.out.print(informacion);
	}

	// Mostrandole al usuario que los datos ingresados fueron invalidos
	public void datosInvalidos(){
		System.out.print("| Los datos ingresados son invalidos\n");
	}

	// Mostrando si la opcion es un número o no
	public Boolean tryCatch(String opcionS){
		Boolean bandera = false;
		try{
			Integer.parseInt(opcionS);
			bandera = true;
		}catch(NumberFormatException nfe){
			bandera = false;
			System.out.print("| Favor ingrese una opcion, con numeros ");
		}
		return bandera;
	}
}
