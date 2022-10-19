package ui;

import misc.Controles;

public class Menu implements IMenu{

    @Override
    public void Opc() {
        System.out.println("----------------------------------------------------");
        System.out.println("1.Balance General");
        System.out.println("2.Estado de Resultado");
        System.out.println("3.Flujo de Efectivo");
        System.out.println("4.Salir");
        System.out.print("Usted selecciono: ");
    }

    @Override
    public void Select() {
        int i=0;
        while(i!=4){
            Opc();
            i=Controles.tecladoI();
            System.out.println("------------------------------------------------");
            switch (i) {
                case 1 -> {
                    MenuBG a=new MenuBG();
                    a.Select();
                }
                case 2 -> {
                    MenuER b=new MenuER();
                    b.Select();
                }
                case 3 -> {
                    MenuFE c=new MenuFE();
                    c.Select();
                }
                case 4 -> System.out.println("Tenga buen dia");
                default -> System.out.println("Ingrese una opcion valida");
            }
        }
    }
    
}
