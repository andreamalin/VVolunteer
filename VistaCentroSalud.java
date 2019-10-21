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

	// Obtener el centro de salud con el cual quiere interactuar el usuario
	public void obtenerCentroDeSalud(Controlador control){
		Integer centroDeSaludSeleccionado, cantidadCentrosMostrados = 0;

		// Mostrandole los centros de salud que puede utilizar
		System.out.print("\nEstos son los centros de salud con los que posee comunicacion: ");
		for(int i = 0; i < control.getLength(); i++){
			if(control.numeroIdentificacion()){
				System.out.print("\n" + (cantidadCentrosMostrados + 1) + ". " + control.getNombre(i));
				cantidadCentrosMostrados++;
			}
		}

		// Obteniendo el centro de salud que quiere el usuario
		do{	
			System.out.print("\nIngrese el centro de salud con el cual desea interactuar: ");
			centroDeSaludSeleccionado = input.nextInt();
		}while((centroDeSaludSeleccionado < 0) || (centroDeSaludSeleccionado > cantidadCentrosMostrados));

		control.setOpcion(centroDeSaludSeleccionado);
	}

	public void mostrarInventario(Controlador control){
		Integer j = control.obtenerPosicionCentroSalud();
		System.out.println("\nSe cuenta en el inventario de " + control.getCentroSalud().getGrafico()[j].getCentroSaludNombre() + " con las siguientes medicinas: ");
			for(int i = 0; i < 3; i++){
		 		System.out.print("- " + (control.getCentroSalud().getGrafico()[j].getInventario())[i].getNombreMedicamento() + " de la cual se tiene "  + (control.getCentroSalud().getGrafico()[j].getInventario())[i].getCantidadEnInventario() + " en el inventario\n");
			}
		}

	// Pidiendole al usuario los medicamentos utilizados en la jornada 
	public void pedirMedicinaNecesitada(Controlador control){
		Integer j = control.obtenerPosicionCentroSalud();
		for(int i = 0; i < 3; i++){
		 	System.out.print("Ingrese la cantidad de medicina necesitada en esta jornada de " + (control.getCentroSalud().getGrafico()[j].getInventario())[i].getNombreMedicamento() + ": ");
			 control.agregarANecesitados(input.nextInt(),i);
		}
		System.out.print(control.getCentroSalud().getGrafico()[j].elaborarDatos(control.getCantidadNecesitada()));
	}

	//Vistas programa
	public void mostrarinfocentroV(SegundoControlador controlA){
		System.out.println("\n_________________________________________________\n\n"+controlA.mostrarInfoCentro()+"_____________________________________________");
	
	}
	public void mandarayudaV(SegundoControlador controlA){
		System.out.println("\n_________________________________________________\n\n"+controlA.mandarAyuda());
	}
	
	public void menuv(){
		System.out.println("\n\nEstas son las opciones que puede realizar:\n1. Ver inventario\n2. Recomendaciones para la siguiente jornada\n3. Ver medicinas\n4. Buscar medicina por sintomas\n5. Cerrar Sesion\nIngrese la opcion que desea realizar: ");
	}
	public void opcionv(){
		System.out.println("A continacion debe de seleccionar el departamento en el que se encuentra (en numeros)" + "\n1.Ciudad de Guatemala\n" +"2.Quetzaltenango, Xela\n"+"3.Sacatequepez, Antigua Guatemala\n"+"4. Alta Verapaz, Coban\n5. Otro\nIngrese en donde se encuentra: ");
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
	}














}
