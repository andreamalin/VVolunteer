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

public class Vista{
	Scanner input = new Scanner(System.in);
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
	public void vistaMain(){
		System.out.println("\n\n _________________________________________________ "+"\n                Bienvenido a VMedic+               \n" +" La salud es un derecho de todos los seres humanos \n"+ "               Estamos para servirte               \n" + "\n\t\t 1. Centro de Salud \n\t\t 2. Registrar Peticion de Ayuda \n\t\t 3. Registrar Donacion\n\t\t 4. Salir\n" +" _________________________________________________ \nIngrese su opcion: ");
	}
}
