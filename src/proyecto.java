
import java.util.Scanner;

public class proyecto {

    private static String nombreUsuario = "";
    private static String passwordUsuario = "";
    private static String[] productos;
    private static final int sizeProductos = 20;
    
    private static String[] codigos;
    private static final int sizeCodigos = 20;
    
    private static String[] carritoCompra;
    private static final int sizeCarritoCompra = 20;

    private static Integer[] estadisticas;
    private static final int sizeEstadisticas = 20;


    public static void InicializarData() {
        nombreUsuario = "cajero_202200066";
        passwordUsuario = "ipc1_202200066";

        productos = new String[sizeProductos];
        carritoCompra = new String[sizeCarritoCompra];
        codigos = new String[sizeCodigos];
        estadisticas = new Integer[sizeEstadisticas];
        
        /*productos[0] = "Galletas Diana|2.00";
        productos[1] = "Jugo Manzana|3.00";
        productos[2] = "Tortrix de limon|5.00";
        productos[3] = "Chiles Adams|0.50";
        productos[4] = "Botella de agua|4.00";
        
        

        //ManejoProductos.ImprimirInventario(productos);
        carritoCompra[0]="Helen|C/F";
        carritoCompra[1]="0|2";
        carritoCompra[2]="4|5";
        carritoCompra[3]="2|2";
        carritoCompra[4]="1|1";
        carritoCompra[5]="3|10";
        //CalcularFactura();
        

        codigos[0]="abcd|5";
        codigos[1]="efgh|10";
        codigos[2]="ijkl|15";
        codigos[3]="mnop|20";
        codigos[4]="qrst|25";

        
        estadisticas[0]=2;
        estadisticas[1]=1;
        estadisticas[2]=2;
        estadisticas[3]=10;
        estadisticas[4]=5;*/
        
        

       //EmitirFactura(10, 42.00);
    }

    public static void main(String args[]) {

        InicializarData();
        // VerificarCredenciales();
        MenuInicial();
        //AgregarProductos();
        //AgregarCupones();
        //RealizarVentas();
        //CalcularFactura();
        //RealizarReporte();
    }

    public static void VerificarCredenciales() {
        String user = "";
        String password = "";

        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Ingresa tu usuario: ");
            user = in.nextLine();
            System.out.print("Ingresa tu contrasenia: ");
            password = in.nextLine();

            if (user.equals(nombreUsuario) && password.equals(passwordUsuario)) {
                in.close();
                break;
            } else {
                System.out.println("************Error************");
                System.out.println("Usuario o constrasenia incorrectos, intentalo de nuevo");
            }
        }
        System.out.println("************Bienvenido a la tienda SUPER-25************");
        System.out.println("");
    }

    public static void ImprimirMenuInicial() {
        System.out.println("**************Menu Inicial SUPER-25*******************");
        System.out.println("1) Agregar nuevos productos");
        System.out.println("2) Agregar cupones de descuento");
        System.out.println("3) Realizar ventas");
        System.out.println("4) Realizar reporte");
        System.out.println("0) Salir del programa.");

        System.out.println("Seleccione opcion: ");
    }

    public static void MenuInicial() {
        Scanner in = new Scanner(System.in);
        int opcion = -1;

        do {
            Tools.clearScreen();
            ImprimirMenuInicial();

            opcion = in.nextInt();

            switch (opcion) {
                case 1: AgregarProductos();
                     break;
                case 2: AgregarCupones();
                    break;
                case 3: RealizarVentas();
                    break;
                case 4: RealizarReporte();
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }

    public static void AgregarProductos(){
        Scanner in = new Scanner(System.in);
        String continuar;
        int indiceVacio = -1;
        String producto ="";
        double precio=0.0;

        do{
            Tools.clearScreen();

            System.out.print("Ingrese producto: ");
            producto =in.next();
            
            System.out.print("Ingrese precio: ");
            precio =in.nextDouble();

            //--"Galletas Diana|2.00"
            String nuevoProducto= producto.trim() + "|"+ String.valueOf(precio);

            //--regresa -1 si no encuntra el item
            int posicion = ManejoProductos.ExisteProducto( productos, nuevoProducto);

            indiceVacio = Tools.ObtenerIndiceVacioEnArray(productos);

            if(indiceVacio == -1){
                System.out.println("No hay espacio para nuevos productos\n");
                break;
            }

            if (posicion == -1 ) { 
                productos[indiceVacio] = nuevoProducto;

                System.out.println("Producto registrado.\n");
            }
            else { 
                System.out.println("El producto ya existe!");
            }

            System.out.println("¿Continuar?(s/n): ");

            continuar = in.next().substring(0,1);
           
       }while(continuar.equalsIgnoreCase("s"));  
    }

    public static void AgregarCupones() {
        Scanner in = new Scanner(System.in);
        String continuar = "";
        int indiceVacio = -1;
        String codigo ="";
        int descuento=0;

        do{
            Tools.clearScreen();

            System.out.print("Ingrese codigo: ");
            codigo =in.next();
      
            if (codigo.length() == 4 ){
                
                System.out.print("Ingrese descuento: ");
                descuento =in.nextInt();
          
                //--"D23S| 5%"
                String nuevoCodigo= codigo.trim() + "|"+ String.valueOf(descuento);
    
                //--regresa -1 si no encuntra el codigo
                int posicion = ManejoDescuentos.ExisteCodigo(codigos, nuevoCodigo);
    
                indiceVacio = Tools.ObtenerIndiceVacioEnArray(codigos);
    
                if(indiceVacio == -1){
                    System.out.println("No hay espacio para nuevos codigos\n");
                    break;
                }
    
                if (posicion == -1 ) { 
                    codigos[indiceVacio] = nuevoCodigo;
    
                    System.out.println("Codigo registrado.\n");
                }
                else { 
                    System.out.println("El Codigo ya existe!");
                }
            }
            else{
                System.out.println("Codigo Invalido. Se necesitan codigo de 4 caracteres!");
            }
            System.out.println("¿Continuar?(s/n): ");

            continuar = in.next().substring(0,1);
           
       }while(continuar.equalsIgnoreCase("s"));

        System.out.println("****Codigos ingresados: ****");
        for (int i= 0; i<indiceVacio+1; i++){
            System.out.println(codigos[i]);
        }
    }
    
    public static void RealizarVentas() {
        String continuar;
        int indiceVacio = -1;
        String indiceProducto = "";
        String cantidadProducto = "";
        Scanner in = new Scanner(System.in);
        
        PedirDatosCliente();
        
        do{
            ManejoProductos.ImprimirInventario(productos);
            
            
            System.out.print("Ingrese indice del producto: ");
            indiceProducto =in.next();
            
            System.out.print("Ingrese cantidad: ");
         
            cantidadProducto =in.next();

            //--"0|2"
            String nuevoProductoAgregado= indiceProducto.trim() + "|"+ String.valueOf(cantidadProducto);

           // ManejoCarritoCompra.AgregarItemAFactura(nuevoProductoAgregado);

            //--regresa -1 si no encuntra el item
            int posicion = ManejoProductos.ExisteProductoAgregado( carritoCompra, nuevoProductoAgregado);

            indiceVacio = Tools.ObtenerIndiceVacioEnArray(carritoCompra);

            if(indiceVacio == -1){
                System.out.println("No hay espacio para mas productos\n");
                break;
            }

            if (posicion == -1 ) { 
                carritoCompra[indiceVacio] = nuevoProductoAgregado;

                ManejoEstadisticas.IngresarRegistro(estadisticas, Integer.parseInt(indiceProducto), Integer.parseInt(cantidadProducto));

                System.out.println("Producto Agregado.\n");
            }
            else { 
                System.out.println("El producto ya existe!");
            }
            System.out.print("¿Continuar?(s/n): ");
            continuar = in.next().substring(0,1);
            Tools.clearScreen();
       }while(continuar.equalsIgnoreCase("s"));
       
       Integer pctDescuento = ManejoDescuentos.ProcesarDescuento(codigos);
       Double subTotal = CalcularFactura(pctDescuento);
       
       EmitirFactura(pctDescuento, subTotal);
    }

    public static Double CalcularFactura(Integer pctDescuento){
        String nombreProducto = "";
        Double precioProducto = 0.00;
        Integer indiceProducto=-1;
        Integer cantidadProducto=0;
        Double monto=0.0;
        Double subTotal=0.00;
       
        for (int i = 1; i < carritoCompra.length; i++) {
            String lineaFactura=carritoCompra[i]; 
         
            if (lineaFactura == null || lineaFactura.isEmpty() || lineaFactura.trim().isEmpty()){
             break;
            }   
           indiceProducto=ManejoCarritoCompra.GetIndiceProducto(carritoCompra,i);
           cantidadProducto=ManejoCarritoCompra.GetCantidad(carritoCompra, i);
           nombreProducto=ManejoProductos.GetNombreByIndice(productos, indiceProducto);
           precioProducto=ManejoProductos.GetPrecioByIndice(productos, indiceProducto);
           
           monto=precioProducto*cantidadProducto;
          
           subTotal=subTotal+monto;
        }

       return subTotal;
    }
  
    public static void EmitirFactura(Integer pctDescuento, Double subTotal) {
        Scanner in = new Scanner(System.in);

        Double descuentoEnDecimales=0.00;
        Double total=0.00;

        String nombreCliente=ManejoCarritoCompra.GetNombreCliente(carritoCompra);
        String numeroDeNit=ManejoCarritoCompra.GetNit(carritoCompra);
        //String porcentajeDescuento=ManejoDescuentos.GetPorcentajeDeDescuento(codigos);
        
        Tools.clearScreen();

        System.out.println("=====================SUPER-25===================== ");
        System.out.println("Nombre del cajero: Helen Rodas");
        System.out.println("Nombre del cliente: " + nombreCliente);
        System.out.println("NIT: " + numeroDeNit);
        System.out.println("Fecha de emision: 10/2/2023");
        
        System.out.println("---------------------------------------------------");
        ManejoCarritoCompra.ListadoDeProductos(carritoCompra, productos);
        System.out.println(" ");
        // 
        if (pctDescuento == 0){
            System.out.printf("Su total es de: Q%5.2f\n", subTotal);
        }
        else{
            descuentoEnDecimales= pctDescuento/100.00;
            total=subTotal-(descuentoEnDecimales*subTotal);
            System.out.printf("%s %%%2d\n", "Porcentaje de Descuento: ", pctDescuento);
            System.out.printf("Su total con el descuento aplicado es de: Q%5.2f\n", total);
            System.out.println(" ");
        }
        System.out.println("===============Gracias por su compra=============== ");
        carritoCompra = new String[sizeCarritoCompra];
        System.out.printf("\n\n");

        System.out.println("Presione Enter para continuar...");
       
        in.nextLine();
        MenuInicial();
    }

    public static void RealizarReporte() {
        Scanner in = new Scanner(System.in);
        String[] reporte = new String[20];

        //ManejoEstadisticas.IngresarRegistro(estadisticas, , null);
        Tools.clearScreen();
        for (int i = 0; i < estadisticas.length; i++) {
            if(estadisticas[i] != null){
                reporte[i] =  String.valueOf(i)+"|"+ String.valueOf(estadisticas[i]);
            }
        }
        
        ManejoEstadisticas.SortArray(reporte); 
        System.out.println("==============Reporte=============");
        System.out.printf("%1$-4s\t %2$15s\n","Producto ","Cantidad ");
        System.out.println("----------------------------------");

        for (String val : reporte) {
           
            if (val != null){
                System.out.printf("%-20s\t %2$3s\n", 
                ManejoProductos.GetNombreByIndice(productos, 
                ManejoEstadisticas.GetIndiceProducto(val)),
                ManejoEstadisticas.GetCantidad(val)
                
                );
            }
        }
        System.out.printf("\n\n");
        System.out.println("Presione Enter para continuar...");
       
        in.nextLine();
        MenuInicial();
    
    }

    public static void PedirDatosCliente(){
        Scanner in = new Scanner(System.in);
        String nombreCliente = "";
        String preguntaNit = "";
        String numeroNit = "";

        Tools.clearScreen();

        System.out.println("Ingrese nombre cliente: ");
        nombreCliente = in.nextLine();
        
        System.out.println("¿Tiene NIT?(s/n): ");
        preguntaNit = in.nextLine(); //.substring(0,1);
        
        if(preguntaNit.equalsIgnoreCase("s")) {
            System.out.println("Ingrese NIT: ");
            numeroNit = in.nextLine();
            //in.close();
        }
        else{
            numeroNit = "C/F";
        }

        //--datos del cliente se ingresan en array: carritoCompra en indice 0
        carritoCompra[0]=nombreCliente.trim() + "|" + numeroNit.trim();
    }

}

