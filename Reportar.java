/**********************************************************
Reportar.java	
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

La clase Reportar se encarga de pedir los datos del usuario que
reporta ayuda y mandar la ayuda lo antes posible.
**********************************************************/

import java.util.Random;
public class Reportar{
	private String nombre_usuario, correo, telefono, direccion, sintomas;
	private boolean bandera;
	private String[] info;
// se crearon variables 
	public void setInfo(String nom, String cor, String tel, String dire, String sint){
	// se convierte el numero de telefono a texto para agregarlo al array
	// de tipo String
		this.nombre_usuario = nom;
		this.correo = cor;
		this.telefono = tel;
		this.direccion = dire;
		this.sintomas = sint;
	// se guardan los datos en un array de una dimension
		info = new String[5];
		info[0] = this.nombre_usuario;
		info[1] = this.correo;
		info[2] = this.telefono;
		info[3] = this.direccion;
		info[4] = this.sintomas;
	}
	// se retorna la informacion
	public String getInfo(){
		// se concatenan los datos ingresados por el usuario y con sus especificaciones en una variable de tipo texto para mostrarla
		String informacion = "Nombre de usuario: " + nombre_usuario + " Correo: " + correo + " Direccion: "+ direccion + " Sintomas: " + sintomas+ " Telefono: " + telefono;
		return informacion;
	}
	// se crea un numero aleatorio para verificar si se puede ayudar 
	// a la persona inmediatamente 
	public boolean enCamino(){
		Random r = new Random();
		int r1 = r.nextInt(100);
		if (r1 == 67){
			bandera = true;
		}
		else{
			bandera = false;
		}
	return bandera;

	}
}

