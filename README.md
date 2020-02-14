# EEDD_TIENDA
**Proyecto grupal EEDD Tienda**

En este proyecto desarrollaremos una app de gestión, en este caso para una Tienda.

Contaremos con tres clases, denominadas Tienda, Cliente y Articulo.

**Dentro de la clase Tienda encontraremos lo siguiente:**
  * Vector articulos, de tipo Articulo
  * Vector cantidades, de tipo Integer
  * Vector clientes, de tipo Cliente
  * Variable numArticulos, de tipo Integer
  * Variable numClientes, de tipo Integer
  
  A continuación dispondremos de los siguientes métodos:
    - llenarAlmacen()
    - mostrarInventario()
    - obtenerArticulos()
    - aniadirCliente()
    - meterAlCarrito()
    - venderCarrito()
    - vender()
    
    

**Dentro de la clase Articulo encontraremos lo siguiente:**
  - Variable Id, de tipo Integer
  - Variable nombre, de tipo String
  - Variable precio, de tipo Double
  
  A continuación dispondremos de los siguientes métodos:
    - getId()
    - getNombre()
    - getPrecio()
 
 
 
**Dentro de la clase Cliente encontraremos lo siguiente:**
  - Vector historialArticulos, de tipo Articulo
  - Vector historialFechas, de tipo Date
  - Vector carrito, de tipo Articulo
  - Variable nombre, de tipo String
  - Variable saldo, de tipo Double
  - Variable tienda, de tipo Tienda
  - Variable tamanioCarrito, de tipo Integer
  - Variable tamanioHistorial, de tipo Integer
  
  A continuación dispondremos de los siguientes métodos:
    - getNombre()
    - getSaldo()
    - aumentarSaldo()
    - disminuirSaldo()
    - meterAlCarrito()
    - aniadirAHistorial()
    - getCarrito()
    - getHistorialFechas()
    - getHistorialArticulos()
    - mostrarCarrito()
    - mostrarHistorial()
    - mostrarSaldo()



