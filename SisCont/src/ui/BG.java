package ui;

import dal.Almacen;
import dol.Cuenta;
import java.util.ArrayList;
import java.util.List;
import misc.Controles;

public class BG implements IMenu{

    private List<Cuenta>activo;
    private List<Cuenta>pasivo;
    private String nombre;
    
    public BG(){
        activo=new ArrayList<>();
        pasivo=new ArrayList<>();
        nombre=null;
    }
    
    public BG(String BG){
        activo=Almacen.veList("BG", BG, "Activo");
        pasivo=Almacen.veList("BG", BG, "Pasivo");
        nombre=BG;
    }

    @Override
    public void Opc() {
        System.out.println("----------------------------------------------------");
        System.out.println("1.Agregar Activo");
        System.out.println("2.Agreagar Pasivo");
        System.out.println("3.Ver Activos");
        System.out.println("4.Ver Pasivos");
        System.out.println("5.Editar Activo");
        System.out.println("6.Editar Pasivo");
        System.out.println("7.Eliminar Activo");
        System.out.println("8.Eliminar Pasivo");
        System.out.println("9.Salir");
        System.out.print("Usted selecciono: ");
    }

    @Override
    public void Select() {
        int i=0;
        while(i!=9){
            Opc();
            i=Controles.tecladoI();
            System.out.println("------------------------------------------------");
            switch (i) {
                case 1 -> activo.add(Controles.agCuenta());
                case 2 -> pasivo.add(Controles.agCuenta());
                case 3 -> Controles.imList(activo, 1);
                case 4 -> Controles.imList(pasivo, 2);
                case 5 -> activo=Controles.edCuenta(activo);
                case 6 -> pasivo=Controles.edCuenta(pasivo);
                case 7 -> activo=Controles.deCuenta(activo);
                case 8 -> pasivo=Controles.deCuenta(pasivo);
                case 9 -> System.out.println("Usted ha salido");
                default -> System.out.println("Ingrese una opcion valida");
            }
        }
        if(nombre!=null)Almacen.agBa(pasivo,activo,nombre);
        else{
        System.out.print("Nombre del Balance General: ");
        Almacen.agBa(pasivo, activo, Controles.tecladoS());
        }
    }
    
}
