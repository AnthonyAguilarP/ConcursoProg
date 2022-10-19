package ui;

import dal.Almacen;
import misc.Controles;

class MenuER implements IMenu{

    @Override
    public void Opc() {
        System.out.println("----------------------------------------------------");
        System.out.println("1.Hacer Estado de Resultados");
        System.out.println("2.Ver Estado de Resultados");
        System.out.println("3.Editar Estado de Resultados");
        System.out.println("4.Eliminar Estado de Resultados");
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
                    ER a=new ER();
                    a.Select();
                }
                case 2 -> {
                    System.out.print("Nombre del Estado de Resultados: ");
                    Controles.realizarER(Controles.tecladoS());
                }
                case 3 -> {
                    System.out.print("Nombre del Estado de Resultados: ");
                    ER b=new ER(Controles.tecladoS());
                    b.Select();
                }
                case 4 -> {
                    System.out.print("Nombre del Estado de Resultados: ");
                    Almacen.boER(Controles.tecladoS());
                }
                case 5 -> System.out.println("Usted ha salido");
                default -> System.out.println("Ingrese una opcion valida");
            }
        }
    }
    
}
