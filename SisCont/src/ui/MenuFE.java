package ui;

import dal.Almacen;
import misc.Controles;

public class MenuFE implements IMenu{

    @Override
    public void Opc() {
        System.out.println("----------------------------------------------------");
        System.out.println("1.Hacer Flujo de Efectivo");
        System.out.println("2.Ver Flujo de Efectivo");
        System.out.println("3.Editar Flujo de Efectivo");
        System.out.println("4.Eliminar Flujo de Efectivo");
        System.out.println("5.Salir");
        System.out.print("Usted selecciono: ");
    }

    @Override
    public void Select() {
        int i=0;
        while(i!=5){
            Opc();
            i=Controles.tecladoI();
            System.out.println("------------------------------------------------");
            switch (i) {
                case 1 -> {
                    FE a=new FE();
                    a.Select();
                }
                case 2 -> {
                    System.out.print("Nombre del Flujo de Efectivo: ");
                    Controles.realizarFE(Controles.tecladoS());
                }
                case 3 -> {
                    System.out.print("Nombre del Flujo de Efectivo: ");
                    FE b=new FE(Controles.tecladoS());
                    b.Select();
                }
                case 4 -> {
                    System.out.print("Nombre del Flujo de Efectivo: ");
                    Almacen.boFE(Controles.tecladoS());
                }
                case 5 -> System.out.println("Usted ha salido");
                default -> System.out.println("Ingrese una opcion valida");
            }
        }
    }
    
}
