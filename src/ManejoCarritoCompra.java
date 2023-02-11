
public class ManejoCarritoCompra {
    public static String GetNombreCliente(String[] carritoCompra){
        int indiceDelSeparador = -1;
        //"Helen|NIT"
        String datosCliente=carritoCompra[0];

        indiceDelSeparador =datosCliente.indexOf("|"); 
        String nombreCliente = datosCliente.substring(0, indiceDelSeparador);
        return nombreCliente;
    }

    public static String GetNit(String[] carritoCompra){
        int indiceDelSeparador = -1;
        //"Helen|NIT"
        String datosCliente=carritoCompra[0];

        indiceDelSeparador =datosCliente.indexOf("|"); 
        String numeroNit = datosCliente.substring(indiceDelSeparador+1);
        return numeroNit;

    }
   
    //Regresa un entero de cada indice de productos del array CarritoCompra
    public static Integer GetIndiceProducto(String[] carritoCompra, Integer indice){
        int indiceDelSeparador = -1;
        //"1|5"
        String datosLineaFactura=carritoCompra[indice];

        indiceDelSeparador =datosLineaFactura.indexOf("|"); 
        String indiceProductoComoString = datosLineaFactura.substring(0, indiceDelSeparador);

        Integer indiceProducto = Integer.parseInt(indiceProductoComoString);
        return indiceProducto;
    }

    //Regresa un entero de cada cantidad de productos del array CarritoCompra
    public static Integer GetCantidad(String[] carritoCompra, Integer indice){
        int indiceDelSeparador = -1;
        //"1|5"
        String datosLineaFactura=carritoCompra[indice];

        indiceDelSeparador =datosLineaFactura.indexOf("|"); 
        String indiceCantidadComoString = datosLineaFactura.substring(indiceDelSeparador+1);

        Integer cantidad = Integer.parseInt(indiceCantidadComoString);
        return cantidad;
    }
    
    public static void ListadoDeProductos(String[] carritoCompra, String[] productos){
        String nombreProducto = "";
        Double precioProducto = 0.00;
        Integer indiceProducto=-1;
        Integer cantidadProducto=0;
        Double monto=0.0;
        Double subTotal=0.00;

        System.out.printf("%1$-4s\t %2$11s %3$12s%n","Producto ","Precio Unitario ", "Cantidad");
        System.out.println("---------------------------------------------------");
     
        for (int i = 1; i < carritoCompra.length; i++) {
            String lineaFactura=carritoCompra[i]; 
         
            if (lineaFactura == null || lineaFactura.isEmpty() || lineaFactura.trim().isEmpty()){
             break;
            }   
           indiceProducto=GetIndiceProducto(carritoCompra,i);
           cantidadProducto=GetCantidad(carritoCompra, i);
           nombreProducto=ManejoProductos.GetNombreByIndice(productos, indiceProducto);
           precioProducto=ManejoProductos.GetPrecioByIndice(productos, indiceProducto);
           
           monto=precioProducto*cantidadProducto;
           subTotal=subTotal+monto;
        
           System.out.printf("%-20s Q%5.2f %14d\n",  nombreProducto ,precioProducto ,cantidadProducto);
           //nombreProducto = ManejoProductos.GetNombreByIndice(productos,i);
        }

        System.out.println("---------------------------------------------------");
     
        System.out.printf("%-20s Q%5.2f\n", " subtotal: ", subTotal);
    }

   
}



