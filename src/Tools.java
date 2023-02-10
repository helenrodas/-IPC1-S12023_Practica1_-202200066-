public class Tools {
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    //--verifica que array tenga aun capacidad
    public static int ObtenerIndiceVacioEnArray(String[] myArray){
        for (int i = 0; i < myArray.length; i++) {
            if ( myArray[i] ==null || myArray[i].length() ==0){
                return i;
            }
        }
        return -1;
    }


 
}
