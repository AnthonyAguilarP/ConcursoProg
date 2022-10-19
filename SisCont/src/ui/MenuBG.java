package ui;

import dal.Almacen;
import misc.Controles;

public class MenuBG implements IMenu{

    @Override
    public void Opc() {
        System.out.println("----------------------------------------------------");
        System.out.println("1.Hacer Balance General");
        System.out.println("2.Ver Balance General");
        System.out.println("3.Editar Balance General");
        System.out.println("4.Eliminar Balance General");
        System.out.println("5.Salir");
        System.out.print("Usted selecciono: ");
    }

    @Override
    public void Select() {
       int i=0;
       while(i!=5){
           Opc();
           i=Controles.tecladoI();
           System.out.println("-------------------------------------------------");
           switch (i) {
               case 1 -> {
                   BG a=new BG();
                   a.Select();
               }
               case 2 -> {
                   System.out.print("Nombre del BG: ");
                   Controles.realizarBG(Controles.tecladoS());
               }
               case 3 -> {
                   System.out.print("Nombre del BG: ");
                   BG b=new BG(Controles.tecladoS());
                   b.Select();
               }
               case 4 -> {
                   System.out.print("Nombre del BG: ");
                   Almacen.boBG(Controles.tecladoS());
               }
               case 5 -> System.out.println("Usted salio");
               default -> System.out.println("Ingrese una Opcion Valida");
           }
       }
    }
    
}
