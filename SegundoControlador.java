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
	private CentroSalud centro = new CentroSalud();
	private Reportar reporte = new Reportar();
	private Ayudar ayuda = new Ayudar();
	private String nombre,correo,tel, dir,sint, sint1, sint2, sint3;

	//Realizar opcion
	public String mostrarInfoCentro(){
		ayuda.generarInformacion(departamento);
		String informacion = ayuda.mostrarInformacion();	

		return informacion;
	}


	public String mandarAyuda(){
		//Se guardan los datos
		reporte.setInfo(nombre,correo,tel,dir,sint);

		String ayuda = "";
		boolean reporto= true;
		while(reporto){
			if (reporte.enCamino()){
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
	public void setSintoma1(String sintoma1){
		this.sint1 = sintoma1;
	}
	public void setSintoma2(String sintoma2){
		this.sint2 = sintoma2;
	}
	public void setSintoma3(String sintoma3){
		this.sint3 = sintoma3;
	}
	public void setDepartamento(Integer dept){
		this.departamento = dept;
	}

	public String getSint1(){
		return sint1;
	}
	public String getSint2(){
		return sint2;
	}
	public String getSint3(){
		return sint3;
	}

}