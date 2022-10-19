package ui;

import dal.Almacen;
import dol.Cuenta;
import java.util.ArrayList;
import java.util.List;
import misc.Controles;

class ER implements IMenu{

    private List<Cuenta>GV;
    private List<Cuenta>GA;
    private List<Cuenta>GF;
    private List<Cuenta>OG;
    private String nombre;
    Cuenta[]UB=new Cuenta[4];
    public ER() {
        GV=new ArrayList<>();
        GA=new ArrayList<>();
        GF=new ArrayList<>();
        OG=new ArrayList<>();
        nombre=null;
        UB[0]=new Cuenta("Venta",0.0);
        UB[1]=new Cuenta("Compras",0.0);
        UB[2]=new Cuenta("Inventario Inicial",0.0);
        UB[3]=new Cuenta("Inventario Final",0.0);
    }
    
    public ER(String ER){
        GV=Almacen.veList("ER", ER, "GV");
        GA=Almacen.veList("ER", ER, "GA");
        GF=Almacen.veList("ER", ER, "GF");
        OG=Almacen.veList("ER", ER, "OG");
        nombre=ER;
        UB=Almacen.veArray("ER", ER, "UB");
    }
    
    @Override
    public void Opc() {
        System.out.println("----------------------------------------------------");
        System.out.println("1.Registrar o Editar Ventas Totales");
        System.out.println("2.Registrar o Editar Compras Totales");
        System.out.println("3.Registrar o Editar Inventario Inicial");
        System.out.println("4.Registrar o Editar Inventario Final");
        System.out.println("5.Agregar Gastos de Venta");
        System.out.println("6.Agregar Gastos Administrativos");
        System.out.println("7.Agregar Gastos Financieros");
        System.out.println("8.Agregar Otros Gastos");
        System.out.println("9.Ver cuentas que conforman la Utilidad Bruta");
        System.out.println("10.Ver Gastos de Venta");
        System.out.println("11.Ver Gastos Administrativos");
        System.out.println("12.Ver Gastos Financieros");
        System.out.println("13.Ver Otros Gasto");
        System.out.println("14.Editar Gastos de Ventas");
        System.out.println("15.Editar Gastos Administrativos");
        System.out.println("16.Editar Gastos Financieros");
        System.out.println("17.Editar Otros Gastos");
        System.out.println("18.Eliminar Gasto de Venta");
        System.out.println("19.Eliminar Gastos Administrativos");
        System.out.println("20.Eliminar Gastos Financieros");
        System.out.println("21.Eliminar Otros Gastos");
        System.out.println("22.Salir");
        System.out.print("Usted selecciono: ");
    }

    @Override
    public void Select() {
        int i=0;
        while(i!=22){
            Opc();
            i=Controles.tecladoI();
            System.out.println("------------------------------------------------");
            switch (i) {
                case 1 -> {
                    System.out.print("Ventas: ");
                    UB[0]=new Cuenta("Ventas",Controles.tecladoD());
                }
                case 2 -> {
                    System.out.print("Compras: ");
                    UB[1]=new Cuenta("Compras",Controles.tecladoD());
                }
                case 3 -> {
                    System.out.print("Inventario Inicial: ");
                    UB[2]=new Cuenta("Inventario Inicial",Controles.tecladoD());
                }
                case 4 -> {
                    System.out.print("Inventario Final: ");
                    UB[3]=new Cuenta("Inventario Final",Controles.tecladoD());
                }
                case 5 -> GV.add(Controles.agCuenta());
                case 6 -> GA.add(Controles.agCuenta());
                case 7 -> GF.add(Controles.agCuenta());
                case 8 -> OG.add(Controles.agCuenta());
                case 9 -> Controles.imArray(UB);
                case 10 -> Controles.imList(GV, 2);
                case 11 -> Controles.imList(GA, 3);
                case 12 -> Controles.imList(GF, 4);
                case 13 -> Controles.imList(OG, 5);
                case 14 -> GV=Controles.edCuenta(GV);
                case 15 -> GA=Controles.edCuenta(GA);
                case 16 -> GF=Controles.edCuenta(GF);
                case 17 -> OG=Controles.edCuenta(OG);
                case 18 -> GV=Controles.deCuenta(GV);
                case 19 -> GA=Controles.deCuenta(GA);
                case 20 -> GF=Controles.deCuenta(GF);
                case 21 -> OG=Controles.deCuenta(OG);
                case 22 -> System.out.println("Usted ha salido");
                default -> System.out.println("Ingrese una opcion valida");
            }
        }
        if(nombre!=null)Almacen.agER(UB, nombre, GV, GA, GF, OG);
        else{
            System.out.print("Nombre del Estado de Resultados: ");
            Almacen.agER(UB, Controles.tecladoS(), GV, GA, GF, OG);
        }
    }
    
}
