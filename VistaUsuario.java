public class VistaUsuario{


		// //Vistas programa
	// public void opcion2(Controlador controlA){
	// 	System.out.println("\n_________________________________________________\n");
	// 	System.out.print("Ingrese su Nombre: ");				
	// 	controlA.setNombre(scan.nextLine());
	// 	System.out.print("Ingrese su Correo Electronico: ");
	// 	controlA.setCorreo(scan.nextLine());	
	// 	System.out.print("Ingrese su Telefono: ");
	// 	controlA.setTel(scan.nextLine());
	// 	System.out.print("Ingrese su direccion: ");
	// 	controlA.setDireccion(scan.nextLine());
	// 	System.out.print("Ingrese sus sintomas: ");	
	// 	controlA.setSintomas(scan.nextLine());
	// 	//Se manda la ayuda
	// 	System.out.println(vista.mandarayudaV(controlA));
	// }
	// public void opcion3(Controlador controlA){
	// 	System.out.println(vista.opcionv());		
	// 	controlA.setDepartamento(input.nextInt());
	// 	System.out.println(vista.mostrarinfocentroV(controlA));
	// }
	// public void escogerOpcion(Controlador control, Controlador controlA){
	// 	// Opcion para entrar a la cuenta y utilizar las funciones del programa
	// 	if (control.getOpcion() == 1){
	// 		opcion1(control);
			



	public void mostrarinfocentroV(SegundoControlador controlA){
		System.out.println("\n_________________________________________________\n\n"+controlA.mostrarInfoCentro()+"_____________________________________________");
	
	}
	public void mandarayudaV(SegundoControlador controlA){
		System.out.println("\n_________________________________________________\n\n"+controlA.mandarAyuda());
	}

		public void opcionv(){
		System.out.println("A continacion debe de seleccionar el departamento en el que se encuentra (en numeros)" + "\n1.Ciudad de Guatemala\n" +"2.Quetzaltenango, Xela\n"+"3.Sacatequepez, Antigua Guatemala\n"+"4. Alta Verapaz, Coban\n5. Otro\nIngrese en donde se encuentra: ");
	}

}