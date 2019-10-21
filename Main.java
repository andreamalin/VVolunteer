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
-> Andrea Amaya 19357
Fecha de creación: 31/09/2019
Última fecha de modificación: 20/10/2019

La clase main se encarga de mostrar datos al usuario.
**********************************************************/
public class Main{
	//Metodo principal
	public static void main (String[] args){
		Integer opcionMain = 0;
		// Instancia de objetos
		//ControladorCentroSalud control = new ControladorCentroSalud();
		//SegundoControlador controlA = new SegundoControlador();
		VistaMain vistaMain = new VistaMain();

		// Iniciando el programa
		do{
			opcionMain = vistaMain.MenuPrincipal();

			// Cambiando a la opcion que el usuario desea
			switch(opcionMain){
				// Ingresando al controlador de centro de salud
				case 1:
	
				break;

				// Ingresando al controlador de ayudar y reportar
				case 2:

				break;
				case 3:

				break;

				// Saliendo o para obtener otra opción
				default:
					vistaMain.opcionDefault(opcionMain);
				break;
			}
		}while(opcionMain != 4);	
	}

}