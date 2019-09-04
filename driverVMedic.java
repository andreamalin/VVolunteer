import java.util.Scanner;

class driverVMedic{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		CentroSalud centro = new CentroSalud();
		Regiones region = new Regiones();
		Medicamento medicina = new Medicamento();
		Reportar reportar = new Reportar();
		Ayudar ayuda = new Ayudar();
		int opcion;

		System.out.println(" _________________________________________________ ");
		System.out.println("                Bienvenido a VMedic+               ");
		System.out.println(" La salud es un derecho de todos los seres humanos ");
		System.out.println("               Estamos para servirte               ");
		System.out.println("\n\t\t 1. Centro de Salud \n\t\t 2. Reportar \n\t\t 3. Ayudar \n");
		System.out.println(" _________________________________________________ ");
		opcion = scan.nextInt();

		if (opcion == 1){
			System.out.println("Bienvenido");
		}else if (opcion == 2){
			System.out.println("Bienvenido");

		}else if (opcion == 3){
			System.out.println("Bienvenido");
			System.out.println("Hola");

		}else{
			System.out.println("Esa opcion no existe");
		}

	}
}
