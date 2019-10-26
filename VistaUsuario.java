import java.util.Scanner;

public class VistaUsuario{
	Scanner scan = new Scanner(System.in);

	// OPCION 2 del main
	public String[] conseguirInfoAyudar(){
		String[] datosAyuda = new String[5];

		// Pidiendole los datos al usuario
	 	System.out.println("|\n|_________________________________________________");
	 	System.out.print("| Ingrese su Nombre: ");				
	 	datosAyuda[0] = scan.nextLine();	
	 	System.out.print("| Ingrese su Telefono: ");
	 	datosAyuda[1] = scan.nextLine();
	 	System.out.print("| Ingrese su direccion: ");
	 	datosAyuda[2] = scan.nextLine();
	 	System.out.print("| Ingrese sus sintomas: ");	
	 	datosAyuda[3] = scan.nextLine();
	 	System.out.println("|_________________________________________________");
	 	
	 	return datosAyuda;
	}


	public Integer conseguirInfoDonacion(){
		String opcionS;
		Integer opcion = 0;
		Boolean bandera = false;

		System.out.println("|\n|_________________________________________________");
	 	System.out.println("| A continacion debe de seleccionar el departamento\n| en el que se encuentra (en numeros)");
	 	System.out.println("| 1. Ciudad de Guatemala");
	 	System.out.println("| 2. Quetzaltenango, Xela");
	 	System.out.println("| 3. Sacatequepez, Antigua Guatemala");
	 	System.out.println("| 4. Alta Verapaz, Coban");
	 	System.out.println("| 5. Otro");
	 	
	 	// Pidiendole al usuario que ingrese una opcion valida
	 	do{
			do{
				System.out.print("| Ingrese en donde se encuentra: ");
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
		}while((opcion < 1) || (opcion > 5));

		return opcion;
	}

	// Mostrando cualquier mensaje
	public void mostrandoMensaje(String informacion){
		System.out.print(informacion);
	}

	//Pedir datos para realizar el reporte
	public String[] reportar(){
		String[] datosReporte = new String[5];

		System.out.println("\n___________________________________________________\n             A quien desea reportar?\n___________________________________________________\n1.Paciente\n2.Voluntario");
		String acc = scan.nextLine();
		System.out.println("\t\t<<<< R E P O R T A R >>>>");

		if (acc.equalsIgnoreCase("1")) { //Reportar a un paciente
			System.out.print("| Ingrese su nombre: ");
			datosReporte[0] = scan.nextLine();
			System.out.print("| Ingrese el nombre del paciente atendido: ");
			datosReporte[1] = scan.nextLine();
			System.out.print("| Ingrese su numero de telefono para ser atendido su problema: ");
			datosReporte[2] = scan.nextLine();
			System.out.print("| Ingrese el motivo por el cual el paciente lo hizo sentir incomodo: ");
			datosReporte[3] = scan.nextLine();

		} else if (acc.equalsIgnoreCase("2")) { //Reportar un voluntario
			System.out.print("| Ingrese su nombre: ");
			datosReporte[0] = scan.nextLine();
			System.out.print("| Ingrese el nombre del voluntario que lo atendio: ");
			datosReporte[1] = scan.nextLine();
			System.out.print("| Ingrese su numero de telefono para ser atendido su problema: ");
			datosReporte[2] = scan.nextLine();
			System.out.print("| Ingrese el motivo por el cual el voluntario lo hizo sentir incomodo: ");
			datosReporte[3] = scan.nextLine();		


		} else {
			System.out.print("Opcion invalida");
		}
		datosReporte[4] = acc;
		System.out.println("\nSu reporte esta en revision, gracias por informarnos,\nlo notificaremos lo mas pronto posible\n");
		System.out.println("|___________________________________________________");

		return datosReporte;
	}

}