//Clase para que los voluntarios reporten a los pacientes
public class Rpaciente{
	private String nombrep; //Nombre del paciente
	private String nombrev; //Nombre del voluntario
	private String direccion; //En donde vive el paciente
	private String motivo; //escribe porque lo quiere reportar

	//Default
	public Rpaciente(){
		nombrep = "Samu";
		nombrev = "Joh";
		direccion = "Ciudad de Guatemala, 9-22 zona 1";
		motivo = "No se dejaba inyectar";

	}

	public Rpaciente(String nombrep, String nombrev, String direccion, String motivo){
		this.nombrep = nombrep;
		this.nombrev = nombrev;
		this.direccion = direccion;
		this.motivo = motivo;
	}

	public void setNombrep(String nombrep){
		this.nombrep = nombrep;
	}
	public void setNombrev(String nombrev){
		this.nombrev = nombrev;
	}
	public void setDireccion(String direccion){
		this.direccion = direccion;
	}
	public void setMotivo(String motivo){
		this.motivo = motivo;
	}
	//Override
	public String toString(){
		String m="";
		m += "\nUsted, " + nombrev;
		m += "\nHa reportado a "+ nombrep;
		m += "\nQuien vive en "+ direccion;
		m += "\nPor el motivo: " + motivo;
		return m;
	}
}