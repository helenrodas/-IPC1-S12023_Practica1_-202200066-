public class ManejoEstadisticas {
    public static void IngresarRegistro( Integer[] estadisticas, Integer indiceProducto, Integer nuevaCantidad) {
        //--las cantidades en el array estan con formato 5
        //--"5"
        
       if(indiceProducto<0 || nuevaCantidad < 1){
        return;
       }
        Integer valorActual=  estadisticas[indiceProducto];
        estadisticas[indiceProducto] = valorActual + nuevaCantidad;
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
    
    public static void MuestraEstadisiticas(Integer[] estadisticas, String nombreProducto){
        String[] reporte;

        reporte = new String[20];

        //ordenar array
        for (int i = 0; i < estadisticas.length; i++){  
            if(estadisticas[i] == null){
                break;
            }
            reporte[i] =  String.valueOf(i)+"|"+ String.valueOf(estadisticas[i]);
            // 0|2
            // 1|1
        }
    }

    public static void SortArray(String[] reporte){
        //{"0|10","1|3", "2|20"}
        //=> {"2|20", "0|10", "1|3"}
// 0|2
// 1|1
// 2|10
// 3|5
// 4|1
// 5|4

        String tmp = "";  
        for (int i = 0; i < reporte.length; i++) {
            if( reporte[i] == null){
                break;
            }
            for (int j = i+1; j < reporte.length; j++) {
                if( reporte[j] == null){
                    break;
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