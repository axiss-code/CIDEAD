package Tarea02;

public class PROG02_Ejerc10 {
    
    public static void main(String[] args) {
        
        System.out.println("------- Conversiones entre enteros y coma flotante -------");
        //Producto de int por float: j= i*x = 9
        float x =4.5f;
        float y =3.0f;
        int i = 2;
        int j = (int) (i * x);
        System.out.println("Producto de int por float: j = i*x = "+j);
        
        //Producto de float por double: dz=dx * y = 6.0
        double dx = 2.0;
        double dz = dx * y;
        System.out.println("Producto de float por double: dz = dx*y = "+dz);
        
        System.out.println("\n------- Operaciones con byte -------");
        //byte: 5 - 2 = 3
        byte bx = 5;
        byte by = 2;
        byte bz = (byte)(bx-by);
        System.out.println("byte: "+bx+" - "+by+" = "+bz);
        
        //byte -128 - 1 = 127
        bx = -128;
        by = 1;
        bz = (byte)(bx-by);
        System.out.println("byte "+bx+" - "+by+" = "+bz);
        
        //(int)(-128 - 1) = -129
        System.out.println("(int)("+bx+" - "+by+") = "+(int)(bx-by));  
        
        System.out.println("\n------- Operaciones con short -------");
        //short: 10 - 1 = 3
        short sx = 5;
        short sy = 2;
        short sz = (short)(sx - sy);
        System.out.println("short: "+sx+" - "+sy+" = "+sz);
        
        //short 32767 + 1 = -32768
        sx = 32767;
        sy = 1;
        sz = (short)(sx + sy);
        System.out.println("short: "+sx+" + "+sy+" = "+sz);
        
        System.out.println("\n------- Operaciones con char -------");
         //char: - = 14
        char cx = '\u000f';
        char cy = '\u0001';
        int z = cx - cy;
        System.out.println("char: "+cx+" - "+cy+" = "+z);
        
        //char(0x000F) - 1 = 14
        z = cx - 1;
        System.out.printf("char (0x%04x) - 1 = %d\n", (int)cx, z);
        
        //(int)( ) = 65535
        cx = '\uFFFF';
        z = cx;
        System.out.println("(int)("+cx+") = "+z);
        
        //(short)( ) = -1
        sx = (short)cx;
        System.out.println("(short)("+cx+") = "+sx);
        
        //-32768 short-char-int = 32768
        sx = -32768;
        cx = (char)sx;
        //en el enunciado pone "int|z|sx", pero entiendo por el resultado a mostrar en consola
        //que lo que se pretende es ir casteando el valor de short a char y luego a int
        //por eso he igualado a z con cx (y no con sx como muestra el enunciado)
        z = (int)cx; 
        System.out.println(sx+" short-char-int = "+z);
        
        //-1 short-char-int = 65535
        sx = -1;
        cx = (char) sx;
        z = cx;
        System.out.println(sx+" short-char-int = "+z);
        
    }
}
