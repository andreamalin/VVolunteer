//Clase para que los pacientes reporten a los voluntarios
public class RVoluntario{
	private String nombrep; //Nombre del paciente
	private String nombrev; //Nombre del voluntario
	private int carne; 
	private String direccion; //En donde vive el paciente, para saber que voluntarios se encuentran cerca del area
	private String motivo; //escribe porque lo quiere reportar

	//Default
	public RVoluntario(){
		nombrep = "Samu";
		nombrev = "Joh";
		carne = 123456;
		direccion = "Ciudad de Guatemala";
		motivo = "Me hablo de un tono pesado";

	}

	public RVoluntario(String nombrep, String nombrev, int carne, String direccion, String motivo){
		this.nombrep = nombrep;
		this.nombrev = nombrev;
		this.direccion = direccion;
		this.motivo = motivo;
		this.carne = carne;
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
	public void setCarne(int carne){
		this.carne = carne;
	}
	

	//Override
	public String toString(){
		String m="";
		m += "\nUsted, " + nombrep;
		m += "\nQuien vive en "+ direccion;
		m += "\nHa reportado a "+ nombrev;
		m += "\nPor el motivo: " + motivo;
		return m;
	}
}