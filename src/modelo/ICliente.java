package modelo;

import java.util.Date;

public interface ICliente {
	final int ARTICULOS_MAX = 50;
	
	public String getsNombre();
	public float getfSaldo();
	public boolean setfSaldo(float fSaldo);
	public int getiTamanioCarrito();
	public boolean setiTamanioCarrito(int iTamanioCarrito);
	public int getiTamanioHistorial();
	public Articulo[] getHistorialArticulos();
	public Articulo[] getCarrito();
	public Date[] getHistorialFechas();
	
	public String mostrarSaldo();
	public void aumentarSaldo(float fSaldo);
	public boolean disminuirSaldo(float fSaldo);
	public boolean meterAlCarrito(Articulo a);
	public boolean aniadirAHistorial(Articulo a1, Date d1);
	
	public String mostrarHistorial();
	public String mostrarCarrito();
}