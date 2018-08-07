package Datos;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Proyecto {

    private Map<String, Actividad> actividades;

    public Proyecto() {
        actividades = new HashMap();
    }

    public void agregar(Actividad a) {
        actividades.put(a.getId(), a);
    }

    public Map getactividades() {
        return actividades;
    }

    public void setactividades(Map _actividades) {
        actividades = _actividades;
    }

    public void agregarAnt(String y, String x) {
        Actividad a = (Actividad) actividades.get(y);
        if (a.getId() == null ? y == null : a.getId().equals(y)) {
            actividades.get(x).agregarA(a);
        }
    }

    public void agregarSuc(String y, String x) {
        Actividad a = (Actividad) actividades.get(y);
        if (a.getId() == null ? y == null : a.getId().equals(y)) {
            Actividad b = (Actividad) actividades.get(x);
            b.agregarS(a);
        }

    }

    public void CPM( String _id) {
       Actividad a=(Actividad)actividades.get(_id);
        while(!"end".equals(a.getId())){
        int x = a.getSucesoras().size();
        Actividad s=(Actividad)a.getSucesoras().get(x-1);
        if(s.getIC()<a.getTC()){
        s.setIC(a.getDuracion()+a.getIC());
        }
        s.setTC(s.getIC()+s.getDuracion());
        System.out.println(a.toString());
        while(x!=0){
            CPM(s.getId());
        }
    }
       
    
    }
    public void AddStart(Actividad start){
       for( Map.Entry<String,Actividad> entry: actividades.entrySet()){
           if(entry.getValue().getAntecesoras().isEmpty()){
               start.agregarS(entry.getValue());
               entry.getValue().agregarA(start);
               
           }
       }
    }
    public void AddEnd(Actividad end){
          for( Map.Entry<String,Actividad> entry: actividades.entrySet()){
           if(entry.getValue().getSucesoras().isEmpty()){
               entry.getValue().agregarS(end);
               end.agregarA(entry.getValue());
               actividades.put(end.getId(), end);
           }
       }
    }

}
