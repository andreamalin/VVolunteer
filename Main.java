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
		// Instancia de objetos
		Controlador control = new Controlador();
		SegundoControlador controlA = new SegundoControlador();

		VistaMain vista = new VistaMain();

		// Iniciando el programa
		vista.iniciarPrograma(control);
		
		while(vista.seguir()){
			escogerOpcion(control, controlA);
		}
	}
}