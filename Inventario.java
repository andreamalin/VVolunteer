public class Inventario{
	private String nombreMedicamento;
	private Integer cantidadEnInventario;

	public Inventario(String nombre, Integer cantidad){
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