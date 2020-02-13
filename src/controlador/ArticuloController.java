package controlador;

import modelo.Articulo;

public class ArticuloController implements IArticuloController {
	
	private Articulo articulos[];
	private int cantidades[], numArticulos;
	
	
	public ArticuloController() {
		this.articulos = new Articulo[MAX_ARTICULOS];
		this.cantidades = new int[MAX_ARTICULOS];
		this.numArticulos = 0;
	}
	
	@Override
	public Articulo[] getArticulos() {
		return articulos;
	}

	@Override
	public int[] getCantidades() {
		return cantidades;
	}

	@Override
	public int getNumArticulos() {
		return numArticulos;
	}
	
	@Override
	public void llenarAlmacen() {
		this.articulos[this.numArticulos] = new Articulo((short)1,"Portatil",300);
		this.cantidades[this.numArticulos] = 3;
		this.numArticulos++;
		
		this.articulos[this.numArticulos] = new Articulo((short)2,"Raton",400);
		this.cantidades[this.numArticulos] = 5;
		this.numArticulos++;
		
		this.articulos[this.numArticulos] = new Articulo((short)3,"Teclado",800);
		this.cantidades[this.numArticulos] = 10;
		this.numArticulos++;
		
		this.articulos[this.numArticulos] = new Articulo((short)4,"Pantalla",50);
		this.cantidades[this.numArticulos] = 2;
		this.numArticulos++;
	}
	
	@Override
	public int buscarArticulo(Articulo a) {
		int iPosicionArticulo = -1, iContador = 0;
		while(iContador < this.numArticulos && iPosicionArticulo == -1) {
			if(this.articulos[iContador].getShIdentificador() == a.getShIdentificador()) {
				iPosicionArticulo = iContador;
			}
			iContador++;
		}
		return iPosicionArticulo;
	}
	
	@Override
	public String mostrarInventario() {
		String sResultado = "Mostrando inventario de la tienda\n";
		sResultado += "----------------------------------------------\n";
		for(int iContador = 0; iContador < this.getNumArticulos(); iContador++) {
			sResultado += "[ " + iContador + "] ";
			sResultado += "Articulo: " + this.articulos[iContador] + "\n";
			sResultado += "\t Cantidad en stock: " + this.cantidades[iContador] + "\n";
					sResultado += "----------------------------------------------\n";
		}
		return sResultado;
	}
	
	
}
