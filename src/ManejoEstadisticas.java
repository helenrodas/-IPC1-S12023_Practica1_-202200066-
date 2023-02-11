public class ManejoEstadisticas {
    public static void IngresarRegistro( Integer[] estadisticas, Integer indiceProducto, Integer nuevaCantidad) {
        //--las cantidades en el array estan con formato 5
        //--Array[] integers, 4, 2
        
       if(indiceProducto<0 || nuevaCantidad < 1){
        return;
       }
        Integer valorActual=  estadisticas[indiceProducto];
        
        if(valorActual == null){
            estadisticas[indiceProducto] = nuevaCantidad;
        }
        else{
            estadisticas[indiceProducto] = valorActual + nuevaCantidad;
        }
        
    }

    
    public static Integer GetIndiceProducto( String producto ){
        int indiceDelSeparador = -1;
        
        indiceDelSeparador =producto.indexOf("|"); 
        String indiceProducto = producto.substring(0, indiceDelSeparador);
        return  Integer.parseInt( indiceProducto);
    }
    
    public static Integer GetCantidad(String producto){
        int indiceDelSeparador = -1;
        
        indiceDelSeparador =producto.indexOf("|"); 
        String cantidad = producto.substring(indiceDelSeparador+1);

        return Integer.parseInt(cantidad);

    }
 
    public static void SortArray(String[] reporte){
        // 0|2
        // 1|1
        // 2|10
        
        String tmp = "";  
        for (int i = 0; i < reporte.length; i++) {
            if( reporte[i] == null){
                continue;
            }
            for (int j = i+1; j < reporte.length; j++) {
                if( reporte[j] == null){
                    continue;
                }
                
                int valorCantidad = Integer.parseInt(reporte[i].substring(reporte[i].indexOf("|") + 1 ));
                int valorCantidadSiguiente = Integer.parseInt(reporte[j].substring(reporte[j].indexOf("|") + 1 ));
                
                if (valorCantidad < valorCantidadSiguiente)   
                {  
                    tmp =reporte[i];  
                    reporte[i] = reporte[j];  
                    reporte[j] = tmp;  
                }
            }
        }
    }

}