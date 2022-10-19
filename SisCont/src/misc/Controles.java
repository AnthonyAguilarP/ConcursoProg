package misc;

import dal.Almacen;
import dol.Cuenta;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

public class Controles {
   
    private static final String linea="-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-";
    private static final BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
    
    public static int tecladoI(){
        try{
            int teclado=Integer.parseInt(bf.readLine());
            return teclado;
        }catch(Exception e){
            return 0;
        }
    }
    public static Double tecladoD(){
        try{
            Double teclado=Double.parseDouble(bf.readLine());
            return teclado;
        }catch(Exception e){
            return 0.0;
        }
    }
    public static String tecladoS(){
        try{
            String teclado=bf.readLine();
            return teclado;
        }catch(Exception e){
            return "Error";
        }
    }
    public static String Direccion(String dir){
        File a=new File(dir);
        return a.getAbsolutePath();
    }
    public static List<Cuenta> deCuenta(List<Cuenta> cuenta){
        System.out.print("Posicion del elemento a eliminar: ");
        try{
        int i=Integer.parseInt(bf.readLine());
        cuenta.remove(i-1);
        return cuenta;
        }catch(Exception e){
                return cuenta;
                }
    }
    public static List<Cuenta> edCuenta(List<Cuenta> cuenta){
        System.out.print("Posicion del elemento a editar: ");
        try{
        int i=Integer.parseInt(bf.readLine());
        cuenta.set(i-1, agCuenta());
        return cuenta;
        }catch(Exception e){
            return cuenta;
        }
    }
    public static Cuenta agCuenta(){
        Cuenta a=new Cuenta();
        System.out.print("Cuenta: ");
        a.setCuenta(tecladoS());
        System.out.print("Efectivo: ");
        a.setEfectivo(tecladoD());
        return a;
    }
    public static void imArray(Cuenta[]cuenta){
        int i=0;
        for(Cuenta j:cuenta){
            System.out.println("1."+(i+1)+cuenta[i].toString());
            i++;
        }
    }
    public static void imList(List<Cuenta> cuenta,int k){
        int i=0;
        for(Cuenta j: cuenta){
            System.out.println(k+"."+(i+1)+cuenta.get(i).toString());
            i++;
        }
    }
    public static Double Suma(List<Cuenta> cuenta){
        int i=0;
        Double cont=0.0;
        for(Cuenta j: cuenta){
            cont=cont+cuenta.get(i).getEfectivo();
            i++;
        }
        return cont;
    }
    public static void realizarBG(String nombre){
        List<Cuenta>activo=Almacen.veList("BG", nombre, "Activo");
        List<Cuenta>pasivo=Almacen.veList("BG", nombre, "Pasivo");
        System.out.println(linea+"\nBalance General "+nombre+"\n"+linea+"\nActivo");
        imList(activo,1);
        System.out.println("Total Activo: "+Suma(activo)+"\n"+linea+"\nPasivo");
        imList(pasivo,2);
        System.out.println("Total Pasivo: "+Suma(pasivo)+"\n"+linea+"\nCapital: "+(Suma(activo)-Suma(pasivo))+"\n"+linea);
    }
    public static void realizarER(String nombre){
        Double ub;
        Cuenta[]UB=Almacen.veArray("ER", nombre, "UB");
        List<Cuenta>GV=Almacen.veList("ER", nombre, "GV");
        List<Cuenta>GA=Almacen.veList("ER", nombre, "GA");
        List<Cuenta>GF=Almacen.veList("ER", nombre, "GF");
        List<Cuenta>OG=Almacen.veList("ER", nombre, "OG");
        System.out.println(linea+"\nEstado de Resultados "+nombre+"\n"+linea);
        imArray(UB);
        ub=UB[0].getEfectivo()-((UB[1].getEfectivo()+UB[2].getEfectivo())-UB[3].getEfectivo());
        System.out.println("Utilidad/Perdida Bruta: "+ub+"\n"+linea+"\nGastos de Venta");
        imList(GV,2);
        System.out.println("Total Gastos de Venta: "+Suma(GV)+"\n+"+linea+"Gastos Administrativos");
        imList(GA,3);
        System.out.println("Total Gastos Administrativos: "+Suma(GA)+"\n"+linea+"\nGastos Financieros");
        imList(GF,4);
        System.out.println("Total Gastos Financieros: "+Suma(GF)+"\n"+linea+"\nOtros Gastos");
        imList(OG,5);
        System.out.println("Total de Otros Gastos: "+Suma(OG)+"\n"+linea);
        System.out.println("Utilidad/Perdida neta: "+(ub-(Suma(GA)+Suma(GV)+Suma(GF)+Suma(OG)))+"\n"+linea);
    }
    public static void realizarFE(String nombre){
        List<Cuenta>AI=Almacen.veList("FE", nombre, "AI");
        List<Cuenta>AO=Almacen.veList("FE", nombre, "AO");
        List<Cuenta>AF=Almacen.veList("FE", nombre, "AF");
        Cuenta EcP=Almacen.veObject("FE", nombre, "EcP");
        System.out.println(linea+"\nFlujo de Efectivo\n"+linea+"\nActividades de Inversion");
        imList(AI,1);
        System.out.println("Total Actividades de Inversion: "+Suma(AI)+"\n"+linea+"\nActividades de Operacion");
        imList(AO,2);
        System.out.println("Total Actividades de Operacion: "+Suma(AO)+"\n"+linea+"\nActividades de Financiamiento");
        imList(AF,3);
        System.out.println("Total Actividades de Financiamiento: "+Suma(AF)+"\n"+linea+"\n4.1"+EcP.toString());
        Cuenta EfP=new Cuenta("Efectivo al final del Periodo",(Suma(AI)+Suma(AO)+Suma(AF)+EcP.getEfectivo()));
        System.out.println("4.2"+EfP.toString()+"\n"+linea);
    }
}
