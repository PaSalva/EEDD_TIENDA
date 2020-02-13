package controlador;

import modelo.Cliente;

public class ClienteController implements IClienteController {

	private Cliente clientes[];
	private int numClientes;

	public ClienteController() {
		this.clientes = new Cliente[MAX_CLIENTES];
		this.numClientes = 0;
	}

	@Override
	public int getNumClientes() {
		return numClientes;
	}
	
	@Override
	public Cliente[] getClientes() {
		return clientes;
	}

	@Override
	public boolean aniadirCliente(Cliente c) {
		boolean bExito = false;
		if (numClientes < MAX_CLIENTES) {
			clientes[this.numClientes] = c;
			numClientes++;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public int buscarCliente(Cliente c) {
		int iPosicionCliente = -1, iContador = 0;
		while(iContador < this.numClientes && iPosicionCliente == -1) {
			if(this.clientes[iContador].getsNombre().equals(c.getsNombre())) {
				iPosicionCliente = iContador;
			}
			iContador++;
		}
		return iPosicionCliente;
	}

}
