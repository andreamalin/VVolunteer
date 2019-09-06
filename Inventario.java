/**********************************************************
Inventario.java		
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

La clase Inventario sirve para llevar un conteo de la cantidad
del medicamento presente durante la jornada
**********************************************************/
public class Inventario{
	private String nombreMedicamento;
	private Integer cantidadEnInventario;

	public Inventario(String nombre, Integer cantidad){ //Se obtiene el nombre del medicamento y la cantidad presente
		this.nombreMedicamento = nombre;
		this.cantidadEnInventario = cantidad;
	}

	// Getters  y setters
	public String getNombreMedicamento(){
		return this.nombreMedicamento;
	}

	public Integer getCantidadEnInventario(){
		return this.cantidadEnInventario;
	}

	public void setCantidadEnInventario(Integer nuevaCantidad){
		this.cantidadEnInventario = nuevaCantidad;
	}
}