public class Controlador{
	private Integer opcion, departamento;
	private String medicamento, nombre, correo, tel, dir, sint;
	public String username, password;
	Integer[] necesitados = new Integer[3];

	CentroSalud centro = new CentroSalud();
	Reportar reporte = new Reportar();
	Ayudar ayuda = new Ayudar();

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
	//Getters y setters de todos los atributos
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
}