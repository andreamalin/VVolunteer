public class Controlador{
	private Integer opcion, departamento;
	private String username, password, medicamento;
	Integer[] necesitados = new Integer[3];

	CentroSalud centro = new CentroSalud();
	Reportar reporte = new Reportar();
	Ayudar ayuda = new Ayudar();

	//Realizar opcion
	public String realizarOpcion(){
		if (opcion == 3) {
			ayuda.generarInformacion(departamento);
			String informacion = ayuda.mostrarInformacion();	

			return informacion;
		}
	}

	// Agregar un elemento a la lista de necesitados
	public void agregarANecesitados(Integer cantidad, Integer lugar){
		this.necesitados[i] = cantidad; 
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