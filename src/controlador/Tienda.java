package controlador;
import java.util.Date;

import modelo.Articulo;
import modelo.Cliente;

public class Tienda implements ITienda {
		
	private ArticuloController artController;
	private ClienteController cliController;
	private  byte finalizacion;
	private byte obtenerArticulos;
	private byte anadirCliente;
	
	public Tienda() {
		artController = new ArticuloController();
		cliController = new ClienteController();
	}

	@Override
	public void llenarAlmacen() {
		artController.llenarAlmacen();
	}

	@Override
	public String mostrarInventario() {
		return artController.mostrarInventario();
	}
	
	@Override
	public int buscarArticulo(Articulo a) {
		return artController.buscarArticulo(a);
	}
	
	@Override
	public Articulo[] getArticulos() {
		return artController.getArticulos();
	}

	@Override
	public boolean aniadirCliente(Cliente c) {
		return cliController.aniadirCliente(c);
	}
	
	@Override
	public int buscarCliente(Cliente c) {
		return cliController.buscarCliente(c);
	}

	// ###########################################
	// # METODOS QUE UTILIZAN VARIOS CONTROLLERS #
	// ###########################################
	@Override
	public boolean venderCarrito(Cliente c2) {
		boolean bExito = true;
		Articulo carrito[] = c2.getCarrito();
		
		// Vendiendo articulos
		int numArticulosCarrito = c2.getiTamanioCarrito();
		for(int iContador = 0; iContador < numArticulosCarrito && bExito; iContador++) {
			bExito = vender(carrito[iContador], c2);
		}
		
		//Vaciar el carrito
		c2.setiTamanioCarrito(0);
		return bExito;
	}
	
	@Override
	public boolean vender(Articulo articulo, Cliente c1) {
		boolean bExito = false;
		int iPosicionCliente = buscarCliente(c1);
		int iPosicionArticulo = buscarArticulo(articulo);
		if(iPosicionCliente != -1 && iPosicionArticulo != -1) { // Si se encuentra el articulo y el cliente registrado.
			if(cliController.getClientes()[iPosicionCliente].disminuirSaldo(articulo.getfPrecio())) { // Si el cliente tiene saldo suficiente.
				if(cliController.getClientes()[iPosicionCliente].aniadirAHistorial(articulo, new Date())) { // Si hay hueco en el historial de compras.
					artController.getCantidades()[iPosicionArticulo] -= 1; //Reduzco stock.
					bExito = true;
				}else { // Si el cliente tiene saldo pero no tiene hueco en el historial de compras, aumentamos el Saldo que le hemos quitado previamente.
					cliController.getClientes()[iPosicionCliente].aumentarSaldo(articulo.getfPrecio());
				}
			}	
		}	
		return bExito;
	}

	@Override
	public boolean meterAlCarrito(Articulo articulo, Cliente c2) {
		boolean bExito = false;
		int iPosicionCliente = buscarCliente(c2);
		int iPosicionArticulo = buscarArticulo(articulo);
		if(iPosicionCliente != -1 && iPosicionArticulo != -1 && cliController.getClientes()[iPosicionCliente].meterAlCarrito(articulo)) {
			bExito = true;
		}
		return bExito;
	}
}
