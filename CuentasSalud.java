public class CuentasSalud{
	String username, password;

	public CuentasSalud(String username, String password){
		this.username = username;
		this.password = password;
	}

	public String getUsername(){
		return this.username;
	}

	public String getPassword(){
		return this.password;
	}

}