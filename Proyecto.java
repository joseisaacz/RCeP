package Datos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Proyecto {

    private Map<String, Actividad> actividades;
    private Actividad start = new Actividad("start", 0);
    private Actividad end = new Actividad("end", 0);

    public Proyecto() {
        actividades = new HashMap();
        actividades.put(start.getId(), start);
        actividades.put(end.getId(), end);
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
            Actividad b = (Actividad) actividades.get(x);
            b.agregarA(a);
        }
    }

    public void agregarSuc(String y, String x) {
        Actividad a = (Actividad) actividades.get(y);
        if (a.getId() == null ? y == null : a.getId().equals(y)) {
            Actividad b = (Actividad) actividades.get(x);
            b.agregarS(a);
        }

    }

//    public void CPM(String _id) {
//        Actividad a = (Actividad) actividades.get(_id);
//        while (!"end".equals(a.getId())) {
//            int x = a.getSucesoras().size();
//            Actividad s = (Actividad) a.getSucesoras().get(x - 1);
//            if (s.getIC() < a.getTC()) {
//                s.setIC(a.getDuracion() + a.getIC());
//            }
//            s.setTC(s.getIC() + s.getDuracion());
//            System.out.println(a.toString());
//            while (x != 0) {
//                CPM(s.getId());
//            }
//        }
//
//    }
    public void IC(String _id) {
        /*Version que el profesor sugirió en clase es mas eficiente no hace llamadas extra*/
        Actividad a = (Actividad) actividades.get(_id);
        for (Actividad s:(ArrayList<Actividad>)a.getSucesoras()) {
            
            s.contador++;
            if (s.getIC() < a.TC()) {
                s.setIC(a.getDuracion() + a.getIC());
            }
            s.TC();
            if (s.contador == s.getAntecesoras().size()) {
//                 System.out.println(s.toString()+" "+s.getIC()+ " "+ s.TC());
                    IC(s.getId()); 
            }
        }
        
    }
    
//    public void IC(String _id){
//        Actividad a=(Actividad) actividades.get(_id);
//        if(!a.getId().equals("end")){
//        for (int i=0; i<a.getSucesoras().size();i++){
//            Actividad s=(Actividad)a.getSucesoras().get(i);
//            if (s.getIC() < a.getTC()) {
//                s.setIC(a.getDuracion() + a.getIC());
//            }
//            s.setTC(s.getIC() + s.getDuracion());
//            System.out.println(a.toString());
//            IC(s.getId());
    /*version anterior del algoritmo funcionaba pero hacia llamadas extra*/
//        }
//      }
//    }

    public void TC(String _id) {
        Actividad s = (Actividad) actividades.get(_id);
        for (Actividad a: (ArrayList<Actividad>) s.getAntecesoras()) {
            a.contador1++;
                if (s.getSucesoras().isEmpty()) {
                    s.setIL(s.getIC());
                    s.TL();

                } 
                    if (a.TL() < s.getIL()) {
                        a.TL();
                    }
                    a.setIL(s.TL() - a.getDuracion());
            
                if (a.getSucesoras().size()==a.contador1) {
//                System.out.println(a.toString());
                    TC(a.getId());
                }
            }
        }
    
//    public void TC(String _id) {
//        Actividad s = (Actividad) actividades.get(_id);
//        
//            for (int i = s.getAntecesoras().size(); i >0 ; i--) {
//                Actividad a = (Actividad) s.getAntecesoras().get(i-1);
//                if (!a.getId().equals("start")) {
//                if (s.getIL() == 0) {
//                    a.setTL(a.getTC());
//                    a.setIL(a.getTL() - a.getDuracion());
//                } else{
//                    if(a.getTL()>s.getIL()||a.getTL()==0){
//                        a.setTL(s.getTL()-s.getDuracion());
//                    }
//                    a.setIL(a.getTL()-a.getDuracion());
//                }
//
////                System.out.println(a.toString());
//                TC(a.getId());
//            }
//        }
//    }
    

    public void AddStart() {
        for (Map.Entry<String, Actividad> entry : actividades.entrySet()) {
            if (entry.getValue().getAntecesoras().isEmpty()) {
                if (!"start".equals(entry.getKey()) && !"end".equals(entry.getKey())) {
                    Actividad s = (Actividad) entry.getValue();
                    start.agregarS(s);
                    s.agregarA(start);
                }
            }
        }
    }

    public void AddEnd() {
        for (Map.Entry<String, Actividad> entry : actividades.entrySet()) {
            if (entry.getValue().getSucesoras().isEmpty()) {
                if (!"start".equals(entry.getKey()) && !"end".equals(entry.getKey())) {
                    Actividad s = (Actividad) entry.getValue();
                    end.agregarA(s);
                    s.agregarS(end);
                }
            }
        }

    }

    public void Imprime() {
        for (Map.Entry<String, Actividad> entry : actividades.entrySet()) {
//            if (entry.getValue().holgura()) {
                System.out.println(entry.getValue().toString());
//            }
        }
    }
}
