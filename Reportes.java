/**********************************************************
Reportes.java	
Integrantes grupo:
-> Andrea Amaya 19357
-> Diego Alvarez 19498
-> Diego Crespo 19541
-> Brandon Hernandez 19376
-> Laura Tamath 19365	

Autores de la clase:
-> Andrea Amaya 19357
Fecha de creación: 24/10/2019
Última fecha de modificación: 24/10/2019

La clase madre de los reportes.
**********************************************************/

public class Reportes{
	protected String nombrep; //Nombre del paciente
	protected String nombrev; //Nombre del voluntario
	protected String numero;	//Numero del reportador
	protected String motivo;	//Razon del reporte
	//Constructor
	public Reportes(String nombrep, String nombrev, String numero, String motivo){
		this.nombrep = nombrep;
		this.nombrev = nombrev;
		this.numero = numero;
		this.motivo = motivo;
	}
	//Todos los reportes ingresan a un txt dependiendo del tipo
	public void meterDatos(){
	}
}
