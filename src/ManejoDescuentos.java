
import java.util.Scanner;

public class ManejoDescuentos {
    public static String GetNombreCodigo(String codigo ){
         //--"D23S|5"
        int indiceDelSeparador = -1;
        
        indiceDelSeparador =codigo.indexOf("|"); 
        String nombreCodigo = codigo.substring(0, indiceDelSeparador);

        return nombreCodigo;
    }

    public static Integer GetPorcentajeCodigo(String codigo ){
        //--"D23S|5"
       int indiceDelSeparador = -1;
       
       indiceDelSeparador =codigo.indexOf("|"); 
       String porcentajeDescuento = codigo.substring(indiceDelSeparador+1);
       Integer porcentaje = Integer.parseInt(porcentajeDescuento); 
       return porcentaje;
   }
 
    //Busca dentro del array codigos si encuentra el codigo ingresado
    //--los codigos en el array estan con formato codigo|descuento
    //--"D23S| 5"
    public static Integer ExisteCodigo(String[] codigos, String codigo){
        String nombreCodigo = "";
        
        String nombreCodigoNuevo = GetNombreCodigo(codigo);

        for (int i = 0; i < codigos.length; i++) {
            if(  codigos[i] != null &&  codigos[i].length() > 0){
                nombreCodigo = GetNombreCodigo(codigos[i]);
                
                if (  nombreCodigo.equalsIgnoreCase(nombreCodigoNuevo)){
                    return 1; 
                }
            }
        }
        return -1;
    }

    //Recibe del array codigos el codigo y revisa si lo encuentra dentro del array.
    //Ejemplo de codigo: "abcd", "fghi", "JKLM"
    public static boolean CodigoEncontrado(String[] codigos, String codigo){
        String nombreCodigo = "";
        
       // String nombreCodigoNuevo = ManejoCodigos.GetNombreCodigo(codigo);

        for (int i = 0; i < codigos.length; i++) {
            if(  codigos[i] != null &&  codigos[i].length() > 0){
                nombreCodigo = GetNombreCodigo(codigos[i]);
                
                if (  nombreCodigo.equalsIgnoreCase(codigo)){
                    return true; 
                }
            }
        }
        return false;
    }
   
    //Recibe del array codigos el codigo y devuelve solo el porcentaje de descuento como un entero.
    //Ejemplo de codigo "abcd"
    public static Integer GetPorcentajeDeDescuento(String[] codigos, String codigo){
     String datosCodigo="";
     Integer pctDescuento=0;
     String nombreCodigo="";

        for(Integer i=0;i<codigos.length;i++){
            datosCodigo=codigos[i];
            if (datosCodigo != null && datosCodigo.trim().length()>0){
                nombreCodigo=GetNombreCodigo(datosCodigo);
                if(nombreCodigo.equalsIgnoreCase(codigo)){
                    pctDescuento=GetPorcentajeCodigo(datosCodigo);
                    return pctDescuento;
                }
            } 
        } 
       return 0; //No se encontro el codigo enviado
    } 
   
    public static Integer ProcesarDescuento(String[] codigos){
        Scanner in = new Scanner(System.in);
        String preguntaDescuento="";
        String codigoIngresado="";
        boolean existeCodigo=false;
        Integer pctDescuento=0;


        Tools.clearScreen();
        
        System.out.print("¿Tiene codigo de descuento?(s/n): ");
        preguntaDescuento=in.next().substring(0,1);
 
        if(preguntaDescuento.equalsIgnoreCase("n")){
            return 0; //no hay descuento por no haber codigo
        }

        do {
             System.out.print("Ingrese codigo de descuento: ");
             codigoIngresado=in.next();
             // "abcd"
             existeCodigo=ManejoDescuentos.CodigoEncontrado(codigos, codigoIngresado);
             if(existeCodigo){
                 pctDescuento=ManejoDescuentos.GetPorcentajeDeDescuento(codigos, codigoIngresado);
                 System.out.printf("El porcentaje de decuento aplicado a la factura sera de: %d\n", pctDescuento);
                 return pctDescuento;
             }
             else{
                 System.out.println("Codigo no encontrado ");
                 System.out.print("Desea Ingresar un nuevo codigo?(s/n):  ");
                 preguntaDescuento=in.next().substring(0,1);
             }
             
        } while (preguntaDescuento.equalsIgnoreCase("s"));
        return 0; //no hay descuento
    }

}
