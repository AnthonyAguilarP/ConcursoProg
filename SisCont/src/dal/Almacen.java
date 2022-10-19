package dal;

import dol.Cuenta;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import misc.Controles;

public class Almacen {
    public static void dire(){
        File a=new File("BG");
        a.mkdir();
        File b=new File("ER");
        b.mkdir();
        File c=new File("FE");
        c.mkdir();
    }
    public static void agList(String dir,String nombre,List<Cuenta>cuenta,String tipo){
        File a=new File(Controles.Direccion(dir),nombre+tipo+".dat");
        try{
            if(!a.exists())a.createNewFile();
            ObjectOutputStream b=new ObjectOutputStream(new FileOutputStream(a));
            b.writeObject(cuenta);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void agFE(Cuenta EcP,String nombre,List<Cuenta>AO,List<Cuenta>AI,List<Cuenta>AF){
        agObject("FE",nombre,EcP,"EcP");
        agList("FE",nombre,AO,"AO");
        agList("FE",nombre,AI,"AI");
        agList("FE",nombre,AF,"AF");
    }
    public static void agBa(List<Cuenta> pasivo,List<Cuenta> activo,String nombre){
        agList("BG",nombre,activo,"Activo");
        agList("BG",nombre,pasivo,"Pasivo");
    }
    public static void agArray(String dir,String nombre,Cuenta[]cuenta,String tipo){
        File a=new File(Controles.Direccion(dir),nombre+tipo+".dat");
        try{
            if(!a.exists())a.createNewFile();
            ObjectOutputStream b=new ObjectOutputStream(new FileOutputStream(a));
            b.writeObject(cuenta);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void agObject(String dir,String nombre, Cuenta obj,String tipo){
        File a=new File(Controles.Direccion(dir),nombre+tipo+".dat");
        try{
            ObjectOutputStream b=new ObjectOutputStream(new FileOutputStream(a));
            b.writeObject(obj);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void agER(Cuenta[]UB,String nombre,List<Cuenta>GV,List<Cuenta>GA,List<Cuenta>GF,List<Cuenta>OG){
        agArray("ER",nombre,UB,"UB");
        agList("ER",nombre,GV,"GV");
        agList("ER",nombre,GA,"GA");
        agList("ER",nombre,GF,"GF");
        agList("ER",nombre,OG,"OG");
    }
    public static List<Cuenta> veList(String dir,String Nombre,String tipo){
        File a=new File(Controles.Direccion(dir),Nombre+tipo+".dat");
        try{
            ObjectInputStream c=new ObjectInputStream(new FileInputStream(a));
            return (List<Cuenta>)c.readObject();
        }catch(Exception e){
            return null;
        }
    }
    public static Cuenta[] veArray(String dir,String Nombre,String tipo){
        File a=new File(Controles.Direccion(dir),Nombre+tipo+".dat");
        try{
            ObjectInputStream c=new ObjectInputStream(new FileInputStream(a));
            return (Cuenta[])c.readObject();
        }catch(Exception e){
            return null;
        }
    }
    public static void boBG(String nombre){
        nombre=nombre+"";
        bo(nombre+"Activo","BG",true);
        bo(nombre+"Pasivo","BG",true);
    }
    public static void boER(String nombre){
        nombre=nombre+"";
        bo(nombre+"UB","ER",true);
        bo(nombre+"GV","ER",true);
        bo(nombre+"GF","ER",true);
        bo(nombre+"GA","ER",true);
        bo(nombre+"OG","ER",true);
    }
    public static void bo(String nombre,String d,boolean sePudo){
        if(sePudo==false){
            File b=new File(Controles.Direccion(d),nombre+".dat");
            b.delete();
        }
        File a=new File(Controles.Direccion(d),nombre+".dat");
        if(!a.exists())System.out.println("El archivo que usted ingreso no se encontro(NO EXITE O FUE BORRADO)");
        else{
            if(a.delete()){
                System.out.println("Se borró el archivo "+nombre+" exitosamente");
            }
            else bo(nombre,d,false);
        }
    }
    public static void boFE(String nombre){
        nombre=nombre+"";
        bo(nombre+"EcP","FE",true);
        bo(nombre+"AI","FE",true);
        bo(nombre+"AO","FE",true);
        bo(nombre+"AF","FE",true);
    }
    public static Cuenta veObject(String dir, String nombre, String tipo) {
        File a=new File(Controles.Direccion(dir),nombre+tipo+".dat");
        try{
            ObjectInputStream b=new ObjectInputStream(new FileInputStream(a));
            return (Cuenta)b.readObject();
        }catch(Exception e){
            return new Cuenta("Efectivo al comienzo del Periodo",0.0);
        }
    }
}
