//Diego Crespo
//Diego Alvarez
//Andrea Amaya
//Brandon Hernandez
//Laura Tamath

import java.util.Scanner;
public class Main{
	
	//Metodo principal
	public static void main (String args []){

		// Instancia de objetos; input es para números y scan es para strings
		Scanner input = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		Controlador control = new Controlador();

		do{
			System.out.println(" _________________________________________________ ");
			System.out.println("                Bienvenido a VMedic+               \n");
			System.out.println(" La salud es un derecho de todos los seres humanos ");
			System.out.println("               Estamos para servirte               ");
			System.out.println("\n\t\t 1. Centro de Salud \n\t\t 2. Reportar \n\t\t 3. Ayudar \n");
			System.out.println(" _________________________________________________ ");
			control.setOpcion(input.nextInt()); 

			// Opcion para entrar a la cuenta y utilizar las funciones del programa
			if (control.getOpcion() == 1){

					System.out.print("\n\nIngrese su Usuario");				
					control.setUsername(scan.nextLine());							
					System.out.print("Ingrese su Usuario");
					control.setPassword(scan.nextLine());			
					if(!control.control.centro.accountManager(control.getUsername(), control.getPassword())){
						System.out.print("\nSus datos son invalidos, vuelva a intentar\n");
					} else{

						//------------------ Ingresando sesion ---------------------------
						Systtem.out.println("\n\tBienvenido " + control.getUsername());
						do{
							Systtem.out.print("\n1. Ver inventario\n2. Recomendaciones para la siguiente jornada\n3. Ver medicinas\n4. Cerrar Sesion\nIngrese la opcion que desea realizar: ");

							switch(input.nextInt()){

								// Ver el inventario del centro de salud
								case 1:
									System.out.println("Se cuenta en el inventario con la siguiente medicina: ");
									for(int i = 0; i < 3; i++){
										System.out.print("- " + (control.centro.grafico.getInventario())[i].getNombreMedicamento() + " de la cual se tiene "  + (control.centro.grafico.getInventario())[i].getCantidadEnInventario() + " del medicamento");
									}
									
								break;

								// Obtener recomendaciones para la siguiente jornada
								case 2:

									for(int i = 0; i < 3; i++){
										System.out.print("Ingrese la cantidad de medicina necesitada en esta jornada de " + (control.centro.grafico.getInventario())[i].getNombreMedicamento() + ": ");
										control.agregarANecesitados(input.nextInt(),i);
									}

									// Mostrando las recomendacioes
									System.out.print(control.centro.grafico.elaborarDatos(control.getCantidadNecesitada()));

								break;

								// Buscar medicina
								case 3:
									System.out.println("Ingrese el nombre de la medicina a buscar: ");
									control.setMedicamento(scan.next());

									System.out.println(control.centro.informacion.buscarMedicamento(control.getMedicamento()));


								
								break;
							}

						}while(control.getOpcion() != 4);

						// Regresando a la opcion del ususuario para que no se termine el programa
						control.setOpcion(1);
					}

			} else if (control.getOpcion() == 2){
				String nombre,correo,tel,dir,sint;
				System.out.println("Ingrese su Nombre");				
				nombre = input.nextLine();	
				System.out.println("Ingrese su Correo Electronico");
				correo = input.nextLine();	
				System.out.println("Ingrese su Telefono");
				tel = input.nextLine();	
				System.out.println("Ingrese su direccion");
				dir = input.nextLine();	
				System.out.println("Ingrese sus sintomas");	
				sint = input.nextLine();

				//ESTO HAY QUE VER COMO ARREGARLO PORQUE HAY ACCESO A AYUDA
				reportar.SetInfo(nombre,correo,tel,dir,sint);
				
				//ESTO HAY QUE VER COMO ARREGARLO PORQUE HAY ACCESO A AYUDA
				boolean reporte= true;
				while(reporte){
					if (reportar.enCamino()){
						System.out.println("La ayuda va en camino");
						reporte = false;
					} else {
						System.out.println("Espere...");
					}
				}
					
			} else if (control.getOpcion() ==3){
				System.out.println("A continacion debe de seleccionar el departamento en el que se encuentra (en numeros)");
				System.out.println("1.Ciudad de Guatemala\n" +"2.Quetzaltenango, Xela\n"+"3.Sacatequepez, Antigua Guatemala\n"+"4. Alta Verapaz, Coban\n5. Otro");
				
				control.setDepartamento(input.nextInt());
			} else{
				System.out.println("Opcion invalida, ingrese una valida");
			}
		}
	}	
}
