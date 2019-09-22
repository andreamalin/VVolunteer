/**********************************************************
CentroSalud.java	
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

La clase centroSalud se encarga de llevar un registro de las cuentas.
Está ayudada por la clase CuentasSalud.java
**********************************************************/
public class CentroSalud{
		private CuentasSalud[] cuentas = new CuentasSalud[3];
		private Medicamento informacion = new Medicamento();
		private Regiones[] grafico = new Regiones[4];

		// Constructor de las cuentas ingresadas del centro de salud y los diferentes centros de salud
		public CentroSalud(){
			cuentas[0] = new CuentasSalud("Diego", "LaPiCeRo123", 1);
			cuentas[1] = new CuentasSalud("Andrea", "VOYALLORAR", 1);
			cuentas[2] = new CuentasSalud("Laura", "PythonTeExtrano", 2);

			grafico[0] = new Regiones("Santa Fe", 1);
			grafico[1] = new Regiones("La Rosa de Guadalupe", 1);
			grafico[2] = new Regiones("La Esperanza de Tus Ojos", 2);
			grafico[3] = new Regiones("Resguardando Tu Salud", 1);
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