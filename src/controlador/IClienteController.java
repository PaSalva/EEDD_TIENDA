package controlador;

import modelo.Cliente;

public interface IClienteController {
	final int MAX_CLIENTES = 50;
	
	public int getNumClientes();
	public Cliente[] getClientes();
	public boolean aniadirCliente(Cliente c);
	public int buscarCliente(Cliente c);
	
}
