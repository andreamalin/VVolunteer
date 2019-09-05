
public class CentroSalud{
		CuentasSalud[] cuentas = new CuentasSalud[3];
		Medicamento informacion = new Medicamento();
		Regiones grafico = new Regiones();

		// Constructor de las cuentas ingresadas del centro de salud
		public CentroSalud(){
			cuentas[0] = new CuentasSalud("Diego", "LaPiCeRo123");
			cuentas[1] = new CuentasSalud("Andrea", "VOYALLORAR");
			cuentas[2] = new CuentasSalud("Laura", "PythonTeExtrano");
		}

		// Verificando que el nombre de usuario este bien y tenga la misma contraseña
		public Boolean accountManager(String possibleUsername, String possiblePassword){
			for(int i = 0; i <= 2; i++){
				if((cuentas[i].getUsername()).equals(possibleUsername)){
					if((cuentas[i].getPassword()).equals(possiblePassword)){
						return true;
					}
				}
			}
			return false;
		}

		public Regiones getGrafico(){
			return this.grafico;
		}

		public Medicamento getMedicamento(){
			return this.informacion;
		}
}