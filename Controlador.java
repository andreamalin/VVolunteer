public class Controlador{
	private Integer opcion;
	private int departamento;
	private String username, password;

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
}