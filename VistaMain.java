/**********************************************************
VistaMain.java	
Integrantes grupo:
-> Andrea Amaya 19357
-> Diego Alvarez 19498
-> Diego Crespo 19541
-> Brandon Hernandez 19376
-> Laura Tamath 19365	

Autores de la clase:
-> Andrea Amaya 19357
Fecha de creación: 20/10/2019
Última fecha de modificación: 20/10/2019

Vista a cargo del Main
**********************************************************/
import java.util.Scanner;

public class VistaMain{
	Scanner scan = new Scanner(System.in);

	public void iniciarPrograma(Controlador control){
		// Iniciando el programa
		do{
			System.out.println(vistaMain()); 
			control.defensa(scan.nextLine());

			while(!control.getBandera()){
				System.out.println(" Favor ingrese una opcion, numeros ");
				control.defensa(scan.nextLine());
				if(control.getBandera()){
					control.setOpcion(control.getOpcion()); 
				}
			}
		}
	}
	public void opcion1(Controlador control){
		System.out.print("\n\nIngrese su nombre de Usuario: ");				
		control.setUsername(scan.nextLine());							
		System.out.print("Ingrese su Contrasena: ");
		control.setPassword(scan.nextLine());	
	}
	public void opcion2(Controlador controlA){
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
		//Se manda la ayuda
		System.out.println(vista.mandarayudaV(controlA));
	}
	public void opcion3(Controlador controlA){
		System.out.println(vista.opcionv());		
		controlA.setDepartamento(input.nextInt());
		System.out.println(vista.mostrarinfocentroV(controlA));
	}
	public void escogerOpcion(Controlador control, Controlador controlA){
		// Opcion para entrar a la cuenta y utilizar las funciones del programa
		if (control.getOpcion() == 1){
			opcion1(control);
			
			if(control.getCentroSalud().accountManager(control.getUsername(), control.getPassword()) == false){
				System.out.print("\nSus datos son invalidos, vuelva a intentar\n");
			} else{
				//------------------ Ingresando sesion ---------------------------
				System.out.println("\n\tBienvenid@ " + control.getUsername()); 
				do{
					System.out.print(vista.menuv());
					// Se verifica si lo ingresado es un numero o son palabras
					control.defensa(scan.nextLine()); 

		 			while(control.getBandera()==false){
						System.out.println(" Favor ingrese una opcion, numeros ");
						control.defensa(scan.nextLine());
						if(control.getBandera()==true){
							control.setOpcion(control.getOpcion()); 
						}
					}

					switch(control.getOpcion()){
					// Ver el inventario del centro de salud
					case 1:
						// Verificar cual centro de salud quiere

						obtenerCentroDeSalud(control);
						System.out.print(mostrarInventario(control));
						break;

					// Obtener recomendaciones para la siguiente jornada
					case 2:
						vista.obtenerCentroDeSalud(control);
						System.out.print(vista.pedirMedicinaNecesitada(control));
						break;

					// Buscar medicina
					case 3:
						System.out.print("Ingrese el nombre de la medicina a buscar: ");
						control.setMedicamento(scan.nextLine());

						control.getCentroSalud().getMedicamento().buscarMedicamento(control.getMedicamento());
						System.out.println(control.getCentroSalud().getMedicamento().mostrarInformacion());
						break;

					//Buscar medicina por sintomas
					case 4:
					//Se pide un maximo de 3 sintomas
						System.out.println("Ingrese el primer sintoma: ");
						control.setSintoma1(scan.nextLine());
						System.out.println("Ingrese el segundo sintoma: ");
						control.setSintoma2(scan.nextLine());
						System.out.println("Ingrese el tercer sintoma: ");
						control.setSintoma3(scan.nextLine());

						control.getCentroSalud().getMedicamento().buscarSintomas(control.getSint1(), control.getSint2(), control.getSint3());
						System.out.println(control.getCentroSalud().getMedicamento().mostrarRecomendados());
			} while(control.getOpcion() != 5);
				// Regresando a la opcion del usuario para que no se termine el programa
				control.setOpcion(1);
			}
		
		}
		// Reportar a un voluntariado que necesita ayuda
		} else if (control.getOpcion() == 2){
			opcion2(controlA);
		// Ayudar es para que pueda ir a ayudar a un centro de salud
		} else if (control.getOpcion() == 3){
			opcion3(controlA);
		// Salir del programa y defensiva por si no es ninguna opcion
		} else if (control.getOpcion() == 4){
			System.out.println("Gracias por utilizar VMedic+");
		} else{
			System.out.println("Opcion invalida, ingrese una valida");
		}
	}
	//Ciclo para mostrar menus
	public boolean seguir(){
		opcion = scan.nextLine();
		if (opcion == 4) {
			return false;
		} else {
			return true;
		}
	}
}