
public class CentroSalud{
		CuentaSalud[] cuentas = new CuentaSalud[3];

		public CentroSalud(){
			cuentas[0] = new CuentaSalud("Diego", "LaPiCeRo123");
			cuentas[1] = new CuentaSalud("Andrea", "voyAlLORAR");
			cuentas[2] = new CuentaSalud("Laura", "PythonTeExtraño");
		}

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