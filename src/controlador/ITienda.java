package controlador;

import modelo.Articulo;
import modelo.Cliente;

public interface ITienda {

	public Articulo[] getArticulos();
	public int buscarArticulo(Articulo a);
	public void llenarAlmacen();
	public String mostrarInventario();
	
	public boolean aniadirCliente(Cliente c);
	public int buscarCliente(Cliente c);
	
	public boolean vender(Articulo articulo, Cliente c1);
	public boolean meterAlCarrito(Articulo articulo, Cliente c2);
	public boolean venderCarrito(Cliente c2);
}
