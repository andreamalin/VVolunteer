
public class CentroSalud{
		CuentasSalud[] cuentas = new CuentasSalud[3];
		Medicamento informacion = new Medicamento();
		Regiones grafico = new Regiones();

		// Constructor de las cuentas ingresadas del centro de salud
		public CentroSalud(){
			cuentas[0] = new CuentasSalud("Diego", "LaPiCeRo123");
			cuentas[1] = new CuentasSalud("Andrea", "voyAlLORAR");
			cuentas[2] = new CuentasSalud("Laura", "PythonTeExtraño");
		}

		// Verificando que el nombre de usuario este bien y tenga la misma contraseña
		public Boolean acountManager(String possibleUsername, String possiblePassword){
			for(int i = 0; i <= 2; i++){
				if(cuentas[i].getUsername() == possibleUsername){
					if(cuentas[i].getPassword() == possiblePassword){
						return true;
					}
				}
			}
			return false;
		}



}