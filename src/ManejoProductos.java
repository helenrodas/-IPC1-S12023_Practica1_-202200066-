public class ManejoProductos {
    //--data: "Galletas Diana|2.00";
    public static String GetNombre(String producto ){
        int indiceDelSeparador = -1;
        
        indiceDelSeparador =producto.indexOf("|"); 
        String nombreProducto = producto.substring(0, indiceDelSeparador);

        return nombreProducto;
    }

    public static String GetPrecio(String producto){
        int indiceDelSeparador = -1;
        
        indiceDelSeparador =producto.indexOf("|"); 
        String precio = producto.substring(indiceDelSeparador+1);

        return precio;

    }

    public static int ExisteProducto( String[] productos, String producto) {
        //--los productos en el array estan con formato producto|precio
        //--"Galletas Diana|2.00"
        String nombreProducto = "";
        
        String nombreProductoNuevo = ManejoProductos.GetNombre(producto); 

        for (int i = 0; i < productos.length; i++) {
            if(  productos[i] != null &&  productos[i].length() > 0){
                nombreProducto = ManejoProductos.GetNombre( productos[i]);
                
                if ( nombreProducto.equalsIgnoreCase(nombreProductoNuevo)){
                    return i; 
                }
            }
        }
        return -1; 
    }

    public static void ImprimirInventario(String[] array){
        Tools.clearScreen();
        System.out.println("****** Inventario de tienda ******");
        System.out.println();
        System.out.printf("%1$-4s %2$11s %3$18s%n","Indice","Producto", "Precio");
        System.out.println("=========================================");
        
        //for (int i= 0; i<  Tools.ObtenerIndiceVacioEnArray(array); i++){
        for (int i= 0; i< array.length; i++){
            if (array[i] == null){
                break;
            }

            System.out.printf("%-5d %12s\t %3$12s\n",i
            ,ManejoProductos.GetNombre(array[i])
            ,ManejoProductos.GetPrecio(array[i])
            );
        }
        System.out.println("=========================================");
    }

    public static int ExisteProductoAgregado ( String[] carritoCompra, String indiceProducto){
    //--los productos en el array estan con formato indiceProducto|cantidad
        //--"1|5"
        String nombreProductoAgregado = "";
        
        String nombreProductoNuevoAgregado = ManejoProductos.GetNombre(indiceProducto); 

        for (int i = 0; i < carritoCompra.length; i++) {
            if(  carritoCompra[i] != null &&  carritoCompra[i].length() > 0){
                nombreProductoAgregado = ManejoProductos.GetNombre( carritoCompra[i]);
                
                if ( nombreProductoAgregado.equalsIgnoreCase(nombreProductoNuevoAgregado)){
                    return i; 
                }
            }
        }
        return -1;  
    }

    public static String GetIndiceProducto(String indiceProducto ){
        int indiceDelSeparador = -1;
        
        indiceDelSeparador =indiceProducto.indexOf("|"); 
        String indiceNombreProducto = indiceProducto.substring(0, indiceDelSeparador);

        return indiceNombreProducto;
    }

    public static String GetCantidadProducto(String indiceProducto){
        int indiceDelSeparador = -1;
        
        indiceDelSeparador =indiceProducto.indexOf("|"); 
        String cantidad = indiceProducto.substring(indiceDelSeparador+1);

        return cantidad;
    }

    public static void ImprimirLineaFactura(String[] array){
        System.out.println("**** Productos Adquiridos ****");
        System.out.println();
        System.out.printf("%1$-4s %2$11s%n","Indice","Cantidad");
        System.out.println("====================");
        
        for (int i= 1; i< Tools.ObtenerIndiceVacioEnArray(array); i++){
            System.out.printf("%1$-4s %2$11s%n",
            ManejoProductos.GetIndiceProducto(array[i])
            ,ManejoProductos.GetCantidadProducto(array[i])
            );
        }
    }

    //Recibe el array de prodcutos y el indice y retorna solo el nombre del producto
    public static String GetNombreByIndice(String[] Productos, Integer indice){
        //"Galletas|5.25"
        String datosProducto=Productos[indice];
        String nombreProducto=GetNombre(datosProducto);
        return nombreProducto;
    }

    public static Double GetPrecioByIndice(String[] Productos, Integer indice){
        //"Galletas|5.25"
        String datosProducto=Productos[indice];
        String precioProductoComoString=GetPrecio(datosProducto);
        double precioProducto = Double.parseDouble(precioProductoComoString);
        return precioProducto;
    }

}
