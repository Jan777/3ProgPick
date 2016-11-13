package itemsTipo;

public abstract class ItemLanzable {
	
	protected int cantidad;
	protected int limite;
	
	public void lanzar(){
		this.cantidad--;
	}
	
	public void aumentarCantidad(int cant){
		this.cantidad+= cant;
	}
	
	public int getCantidad(){
		return this.cantidad;
	}
	
	public int getLimite() {
		return this.limite;
	}
	
}
