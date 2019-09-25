import java.util.Scanner;

public class Vista{

	// Obtener el centro de salud con el cual quiere interactuar el usuario
	public void obtenerCentroDeSalud(Controlador control, Scanner input){
		Integer centroDeSaludSeleccionado, cantidadCentrosMostrados = 1;

		// Mostrandole los centros de salud que puede utilizar
		System.out.print("\nEstos son los centros de salud con los que posee comunicacion: ");
		for(int i = 0; i < control.getCentroSalud().getGrafico().length; i++){
			if((control.getCentroSalud().getCuentas()[control.getCentroSalud().getLoggedOnPosition()].getNumberOfIdentification()) == (control.getCentroSalud().getGrafico()[i].getNumberOfIdentification())){
				System.out.print("\n" + cantidadCentrosMostrados + ". " + control.getCentroSalud().getGrafico()[i].getCentroSaludNombre());
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

	// Mostrando los datos del Centro de Salud seleccionado
	public void mostrarInventario(Controlador control, Integer j){
		System.out.println("\nSe cuenta en el inventario de " + control.getCentroSalud().getGrafico()[j].getCentroSaludNombre() + " con las siguientes medicinas: ");
			for(int i = 0; i < 3; i++){
		 	System.out.print("- " + (control.getCentroSalud().getGrafico()[j].getInventario())[i].getNombreMedicamento() + " de la cual se tiene "  + (control.getCentroSalud().getGrafico()[j].getInventario())[i].getCantidadEnInventario() + " en el inventario\n");
		}
	}

	// Pidiendole al usuario los medicamentos utilizados en la jornada 
	public void pedirMedicinaNecesitada(Controlador control, Integer j, Scanner input){
		for(int i = 0; i < 3; i++){
		 	System.out.print("Ingrese la cantidad de medicina necesitada en esta jornada de " + (control.getCentroSalud().getGrafico()[j].getInventario())[i].getNombreMedicamento() + ": ");
		 	control.agregarANecesitados(input.nextInt(),i);
		}
	}
}