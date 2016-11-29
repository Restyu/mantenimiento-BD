package cafes;

public class Cafes {

	private String cafe_nombre;
	private int prov_id;
	private float precio;
	private int ventas;
	private int total;
	
	public Cafes(){
		this.cafe_nombre = "";
		this.prov_id = 0;
		this.precio = 0;
		this.ventas = 0;
		this.total = 0;
	} 
	
	public Cafes(String nombre , int id , float precio , int ventas , int total){
		
		this.cafe_nombre = nombre;
		this.prov_id = id;
		this.precio = precio;
		this.ventas = ventas;
		this.total = total;
	}

	public String getCafe_nombre() {
		return cafe_nombre;
	}

	public void setCafe_nombre(String cafe_nombre) {
		this.cafe_nombre = cafe_nombre;
	}

	public int getProv_id() {
		return prov_id;
	}
	public void setProv_id(int prov_id) {
		this.prov_id = prov_id;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getVentas() {
		return ventas;
	}
	public void setVentas(int ventas) {
		this.ventas = ventas;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return " Nombre: " + cafe_nombre + "\n id: " + prov_id + "\n precio: " + precio + "\n ventas: "
				+ ventas + "\n total: " + total +"\n";
	}	
}
