package controlador;

import modelo.Articulo;

public interface IArticuloController {
	final int MAX_ARTICULOS = 20;
	
	public Articulo[] getArticulos();
	public int[] getCantidades();
	public int getNumArticulos();
	public void llenarAlmacen();
	public int buscarArticulo(Articulo a);
	public String mostrarInventario();
}