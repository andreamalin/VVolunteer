/**********************************************************
Controlador.java	
Integrantes grupo:
-> Andrea Amaya 19357
-> Diego Alvarez 19498
-> Diego Crespo 19541
-> Brandon Hernandez 19376
-> Laura Tamath 19365	

Autores de la clase:
-> Andrea Amaya 19357
-> Brandon Hernandez 19376
Fecha de creación: 31/09/2019
Última fecha de modificación: 05/09/2019

Esta clase se encarga de mostrar los numeros y direcciones de
las cedes para que la población pueda donar medicamento.
**********************************************************/
public class Controlador{
	private Integer opcion, departamento;
	private String medicamento, nombre, correo, tel, dir, sint, username, password, sint1, sint2, sint3;
	private Integer[] necesitados = new Integer[3];
	private CentroSalud centro = new CentroSalud();
	private Reportar reporte = new Reportar();
	private Ayudar ayuda = new Ayudar();

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
	
	// Agregar un elemento a la lista de necesitados
	public void agregarANecesitados(Integer cantidad, Integer lugar){
		this.necesitados[lugar] = cantidad; 
	}

	// Setters de todos los atributos
	public void setOpcion(Integer opcion){
		this.opcion = opcion;
	}	
	public void setUsername(String username){
		this.username = username;
	}
	public void setPassword(String password){
		this.password = password; 
	}
	public void setMedicamento(String medicamento){
		this.medicamento = medicamento;
	}
	public void setDepartamento(Integer dept){
		this.departamento = dept;
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
	//Getters de todos los atributos
	public Integer getOpcion(){
		return this.opcion;
	}
	public String getUsername(){
		return this.username;
	}
	public String getPassword(){
		return this.password;
	}
	public Integer[] getCantidadNecesitada(){
		return this.necesitados;
	}
	public String getMedicamento(){
		return this.medicamento;
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
	public CentroSalud getCentroSalud(){
		return this.centro;
	}
}