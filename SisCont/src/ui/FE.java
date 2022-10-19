package ui;

import dal.Almacen;
import dol.Cuenta;
import java.util.ArrayList;
import java.util.List;
import misc.Controles;

class FE implements IMenu{

    private List<Cuenta>AI;
    private List<Cuenta>AO;
    private List<Cuenta>AF;
    private Cuenta EcP;
    private String nombre;

    public FE() {
        AI=new ArrayList<>();
        AO=new ArrayList<>();
        AF=new ArrayList<>();
        EcP=new Cuenta("Efectivo al comienzo del Periodo",0.0);
        this.nombre=null;
    }
    
    public FE(String nombre){
        AI=Almacen.veList("FE", nombre, "AI");
        AO=Almacen.veList("FE", nombre, "AO");
        AF=Almacen.veList("FE", nombre, "AF");
        EcP=Almacen.veObject("FE", nombre, "EcP");
        this.nombre=nombre;
    }
    
    @Override
    public void Opc() {
        System.out.println("----------------------------------------------------");
        System.out.println("1.Editar o Agregar Efectivo al comienzo del Periodo");
        System.out.println("2.Agregar Actividades de Inversion");
        System.out.println("3.Agregar Actividades de Operacion");
        System.out.println("4.Agregar Actividades de Financiamiento");
        System.out.println("5.Ver Efectivo al comienzo del Periodo");
        System.out.println("6.Ver Actividades de Inversion");
        System.out.println("7.Ver Actividades de Operacion");
        System.out.println("8.Ver Actividades de Financiamiento");
        System.out.println("9.Editar Actividades de Inversion");
        System.out.println("10.Editar Actividades de Operacion");
        System.out.println("11.Editar Actividades de Financiamiento");
        System.out.println("12.Eliminar Actividades de Inversion");
        System.out.println("13.Eliminar Actividades de Operacion");
        System.out.println("14.Eliminar Actividades de Financiamiento");
        System.out.println("15.Salir");
        System.out.print("Usted selecciono: ");
    }

    @Override
    public void Select() {
        int i=0;
        while(i!=15){
            Opc();
            i=Controles.tecladoI();
            System.out.println("------------------------------------------------");
            switch (i) {
                case 1 -> {
                    System.out.print("Efectivo al comienzo del Periodo: ");
                    EcP.setEfectivo(Controles.tecladoD());
                }
                case 2 -> AI.add(Controles.agCuenta());
                case 3 -> AO.add(Controles.agCuenta());
                case 4 -> AF.add(Controles.agCuenta());
                case 5 -> System.out.println("4.1 "+EcP.toString());
                case 6 -> Controles.imList(AI, 1);
                case 7 -> Controles.imList(AO, 2);
                case 8 -> Controles.imList(AF, 3);
                case 9 -> AI=Controles.edCuenta(AI);
                case 10 -> AO=Controles.edCuenta(AO);
                case 11 -> AF=Controles.edCuenta(AF);
                case 12 -> AI=Controles.deCuenta(AI);
                case 13 -> AO=Controles.deCuenta(AO);
                case 14 -> AF=Controles.deCuenta(AF);
                case 15 -> System.out.println("Usted ha salido");
                default -> System.out.println("Ingrese una opcion valida");
            }
        }
        if(nombre!=null)Almacen.agFE(EcP, nombre, AO, AI, AF);
        else {
            System.out.print("Nombre del Flujo de Efectivo: ");
            Almacen.agFE(EcP, Controles.tecladoS(), AO, AI, AF);
        }
    }
    
}
