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

		do{	
			System.out.print("\nIngrese el centro de salud con el cual desea interactuar: ");
			centroDeSaludSeleccionado = input.nextInt();
		}while((centroDeSaludSeleccionado < 0) || (centroDeSaludSeleccionado > (cantidadCentrosMostrados - 2)));

		control.setOpcion(centroDeSaludSeleccionado);
	}

	

}