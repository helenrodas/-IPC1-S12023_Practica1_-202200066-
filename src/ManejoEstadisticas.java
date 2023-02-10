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

    //Nombre Producto
    //Cantidad de veces comprado
    //Mostrar listado de forma descendente
    public static void MuestraEstadisiticas(Integer[] estadisticas){
        String[] reporte;

        reporte = new String[20];

        //ordenar array
        for (int i = 0; i < estadisticas.length; i++)   
        {  

            System.out.printf("Indice: %d\t Valor:%d\n", i,estadisticas[i] );

            for (int j = i + 1; j < estadisticas.length; j++)   
            {  
                int tmp = 0;  
                if(estadisticas[i] != null && estadisticas[j] != null ){
                    if (estadisticas[i] > estadisticas[j])   
                    {  
                        tmp = estadisticas[i];  
                        estadisticas[i] = estadisticas[j];  
                        estadisticas[j] = tmp;
                    }  
                }
            }  
            //System.out.printf("Indice: %d\t Valor:%d\n", i,estadisticas[i] );
        }
    }

}