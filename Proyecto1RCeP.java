package proyecto1.rcep;

import Datos.Actividad;
import Datos.Proyecto;
import Datos.ReadAndWrite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Proyecto1RCeP {

    public static void main(String[] args) {
        Proyecto pro = new Proyecto();
        try {
            ReadAndWrite read=new ReadAndWrite("datos.xml");
            for(int i=0; i<read.getas("Actividad").getLength();i++){
                Actividad act=read.read("id", "duracion", i);
                pro.agregar(act);
            }
//                read.setas("Relacion");
               for(int j=0; j<read.getas("Relacion").getLength();j++){
                   String Antecesor=read.readRelacion(j, "actividad");
                   String Sucesor= read.readRelacion(j, "sucesor");
                   pro.agregarAnt(Antecesor, Sucesor);
                   pro.agregarSuc(Sucesor, Antecesor);
               } 
               pro.AddStart();
               pro.AddEnd();
             
               pro.IC("start");
               pro.TC("end");
            pro.Imprime();
        }catch(Exception e){
            System.out.println(e.getCause());
        }
    }
    
}