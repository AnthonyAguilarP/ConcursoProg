package siscont;

import dal.Almacen;
import ui.Menu;

public class SisCont {

    public static void main(String[] args) {
        Almacen.dire();
        Menu a=new Menu();
        a.Select();
    }
    
}
