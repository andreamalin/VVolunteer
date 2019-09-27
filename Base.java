import java.io.*;
import java.util.Scanner;
public class I{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		File archivo;
		FileWriter escribir;
		PrintWriter linea;
		archivo = new File("Base.txt");
		String medicamento1, medicamento2, medicamento3;

		try{
			escribir = new FileWriter(archivo, true);
			linea = new PrintWriter(escribir);


			for(int i = 0; i < 3; i++){
				System.out.print("Hola");
				medicamento1 = input.nextLine();
				System.out.print("Hola2");
				medicamento2 = input.nextLine();
				System.out.print("Hola3");
				medicamento3 = input.nextLine();
				

				linea.print(medicamento1 + ",");
				linea.print(medicamento2 + ",");
				linea.println(medicamento3);
			}
			
			linea.close();
			escribir.close();

		}catch(Exception ex){
			System.out.print("HOla");
		}
	}
}