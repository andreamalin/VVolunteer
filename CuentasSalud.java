/**********************************************************
CuentasSalud.java		
Integrantes grupo:
-> Andrea Amaya 19357
-> Diego Alvarez 19498
-> Diego Crespo 19541
-> Brandon Hernandez 19376
-> Laura Tamath 19365	

Autor de la clase:	 
-> Brandon Hernandez 19376

Fecha de creación: 31/09/2019
Última fecha de modificación: 05/09/2019

La clase CuentasSalud se encarga de ayudar la clase CentroSalud
**********************************************************/
public class CuentasSalud{
	private String username, password; //Se lleva un registro de las cuentas
	private Integer numberOfIdentification;

	public CuentasSalud(String username, String password){ //Se guarda la nueva cuenta
		this.username = username;
		this.password = password;
	}

	public String getUsername(){ //Se obtiene el nombre de la cuenta
		return this.username;
	}

	public String getPassword(){ //Se obtiene la contraseña de la cuenta
		return this.password;
	}

	public Integer getNumberOfIdentification(){
		return this.numberOfIdentification;
	}
}