package modelo;
import java.util.Date;

public class Cliente implements ICliente {
	
	private String sNombre; // Primary key
	private float fSaldo;
	private int iTamanioCarrito,iTamanioHistorial; // Contadores para los arrays
	private Articulo historialArticulos[], carrito[];
	private Date historialFechas[];
	private byte MetodoAniadirHistoria;
	private byte MetodoMostrarHistorial5;
	
	public Cliente(String sNombre, float fSaldo) {
		setsNombre(sNombre);
		setfSaldo(fSaldo);
		this.carrito = new Articulo[ARTICULOS_MAX];
		this.historialArticulos = new Articulo[ARTICULOS_MAX];
		this.historialFechas = new Date[ARTICULOS_MAX];
		this.iTamanioHistorial = 0;
		this.iTamanioCarrito = 0;
	}
	
	@Override
	public String getsNombre() {
		return sNombre;
	}
	
	// Primary key.
	private boolean setsNombre(String sNombre) {
		boolean bExito = false;
		if(!sNombre.equals("") && sNombre.length() < 250) {
			this.sNombre = sNombre;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public float getfSaldo() {
		return fSaldo;
	}

	@Override
	public boolean setfSaldo(float fSaldo) {
		boolean bExito = false;
		if(fSaldo > 0) {
			this.fSaldo = fSaldo;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public int getiTamanioCarrito() {
		return iTamanioCarrito;
	}
	
	@Override
	public boolean setiTamanioCarrito(int iTamanioCarrito) {
		boolean bExito = false;
		if(iTamanioCarrito >= 0) {
			this.iTamanioCarrito = iTamanioCarrito;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public int getiTamanioHistorial() {
		return iTamanioHistorial;
	}
	
	@Override
	public Articulo[] getHistorialArticulos() {
		return historialArticulos;
	}

	@Override
	public Articulo[] getCarrito() {
		return carrito;
	}

	@Override
	public Date[] getHistorialFechas() {
		return historialFechas;
	}

	// Funciones especificas del Cliente
	@Override
	public String mostrarSaldo() {
		return "El saldo actual de "+this.sNombre+ " es: "+this.fSaldo+" euros.";
	}
	
	@Override
	public void aumentarSaldo(float fSaldo) {
		this.fSaldo += fSaldo;
	}
	
	@Override
	public boolean disminuirSaldo(float fSaldo) {
		boolean bExito = false;
		if(this.fSaldo >= fSaldo) {
			this.fSaldo -= fSaldo;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public boolean meterAlCarrito(Articulo a) {
		boolean bExito = false;
		if(iTamanioCarrito < ARTICULOS_MAX) {
			this.carrito[iTamanioCarrito] = a;
			iTamanioCarrito++;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public boolean aniadirAHistorial(Articulo a1, Date d1) {
		boolean bExito = false;
		if(iTamanioHistorial < ARTICULOS_MAX) {
			historialArticulos[iTamanioHistorial] = a1;
			historialFechas[iTamanioHistorial] = d1;
			iTamanioHistorial++;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public String mostrarHistorial() {
		String sResultado = "Mostrar historial de compras de " + this.sNombre + "\n";
		sResultado += "------------------------------------------------\n";
		for(int iContador = 0; iContador < this.iTamanioHistorial; iContador++) {
			sResultado += this.historialArticulos[iContador] + " en " + this.historialFechas[iContador] + "\n";
		}
		sResultado += "------------------------------------------------\n";
		
		return sResultado;
	}

	@Override
	public String mostrarCarrito() {
		String sResultado = "Contenido del carrito: " + this.sNombre + "\n";
		sResultado += "------------------------------------------------\n";
		for(int iContador = 0; iContador < this.iTamanioCarrito; iContador++) {
			sResultado += this.carrito[iContador] + "\n";
		}
		sResultado += "------------------------------------------------\n";
		return sResultado;
	}
}
