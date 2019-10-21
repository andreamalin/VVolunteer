/**********************************************************
PeticionAyuda.java	
Integrantes grupo:
-> Andrea Amaya 19357
-> Diego Alvarez 19498
-> Diego Crespo 19541
-> Brandon Hernandez 19376
-> Laura Tamath 19365	

Autor de la clase:
-> Diego Alvarez 19498

Fecha de creación: 31/09/2019
Última fecha de modificación: 05/09/2019

La clase PeticionAyuda se encarga de pedir los datos del usuario que
reporta ayuda y mandar la ayuda lo antes posible.
**********************************************************/

import java.util.Random;
public class PeticionAyuda{
	private boolean bandera;
	private String[] info;
	// se crearon variables 

	public void setInfo(String[] datosUsuario){
	// se guardan los datos en un array de una dimension
		info = new String[5];
		this.info[0] = datosUsuario[0];
		this.info[1] = datosUsuario[1];
		this.info[2] = datosUsuario[2];
		this.info[3] = datosUsuario[3];
		this.info[4] = datosUsuario[4];
	}

	// se retorna la informacion
	public String getInfo(){
		// se concatenan los datos ingresados por el usuario y con sus especificaciones en una variable de tipo texto para mostrarla
		String informacion = "Nombre de usuario: " + info[0] + " Correo: " + info[1] + " Direccion: "+ info[2] + " Sintomas: " + info[4] + " Telefono: " + info[3];
		return informacion;
	}

	// se crea un numero aleatorio para verificar si se puede ayudar 
	// a la persona inmediatamente 
	public boolean enCamino(){
		Random r = new Random();
		int r1 = r.nextInt(10);
		if (r1 == 5){
			bandera = true;
		}
		else{
			bandera = false;
		}
	return bandera;

	}
}

