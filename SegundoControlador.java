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
public class SegundoControlador{
	private Integer departamento;
	private String nombre,correo,tel, dir,sint;
	private PeticionAyuda peticionAyuda = new PeticionAyuda();
	private RegistrarDonacion registrarDonacion = new RegistrarDonacion();

	//Realizar opcion
	public String mostrarInfoCentro(){
		registrarDonacion.generarInformacion(departamento);
		String informacion = registrarDonacion.mostrarInformacion();	

		return informacion;
	}


	public String mandarAyuda(){
		//Se guardan los datos
		peticionAyuda.setInfo(nombre,correo,tel,dir,sint);

		String ayuda = "";
		boolean reporto= true;
		while(reporto){
			if (peticionAyuda.enCamino()){
				ayuda += "La ayuda va en camino";
				reporto = false;
			} else {
				ayuda += "Espere...";
			}
		}
		return ayuda;
	}


	//Setters opcion 2
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public void setCorreo(String correo){
		this.correo = correo;
	}
	public void setTel(String telefono){
		this.tel = telefono;
	}
	public void setDireccion(String direccion){
		this.dir = direccion;
	}
	public void setSintomas(String sintomas){
		this.sint = sintomas;
	}
	public void setDepartamento(Integer dept){
		this.departamento = dept;
	}


}