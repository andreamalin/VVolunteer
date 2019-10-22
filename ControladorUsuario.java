/**********************************************************
SegundoControlador.java	
Integrantes grupo:
-> Andrea Amaya 19357
-> Diego Alvarez 19498
-> Diego Crespo 19541
-> Brandon Hernandez 19376
-> Laura Tamath 19365	

Autores de la clase:
-> Diego Alvarez 19498
Fecha de creación: 24/09/2019
Última fecha de modificación: 24/09/2019

Esta clase se encarga de enviar a los centros de salud los datos
del usuario, sintomas y datos personales.
**********************************************************/
public class ControladorUsuario{
    private VistaUsuario vistaUsuario = new VistaUsuario();
	private PeticionAyuda peticionAyuda = new PeticionAyuda();
	private RegistrarDonacion registrarDonacion = new RegistrarDonacion();


	// Haciendo la opcion 2 del main
	public void peticionDeAyuda(){
		String[] datosAyudar = new String[3];

		// Pidiendole los datos al usuario y mostrando la ayuda
		datosAyudar = vistaUsuario.conseguirInfoAyudar();
		vistaUsuario.mostrandoMensaje(mandarAyuda(datosAyudar));
	}

	// Haciendo la opcion 3 del main
	public void registrarDonacion(){
		Integer opcion;

		opcion = vistaUsuario.conseguirInfoDonacion();
		vistaUsuario.mostrandoMensaje(registrarDonacion.mostrarInformacion(opcion));
	}

	private String mandarAyuda(String[] datosAyudar){
		String ayuda = "";
		Boolean reporto= true;

		//Se guardan los datos
		peticionAyuda.setInfo(datosAyudar);

		// Iniciando ciclo hasta que la ayuda vaya en camino
		while(reporto){
			if (peticionAyuda.enCamino()){
				ayuda += "| La ayuda va en camino";
				reporto = false;
			} else {
				ayuda += "| Espere...\n";
			}
		}
		return ayuda;
	}

	


}