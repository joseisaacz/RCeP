package Datos;

import java.util.*;

public class Actividad {
    private String id;
    private int duracion;
    private int IC;
    private int TC;
    private int IL;
    private int TL;
    private int holgura;
    private ArrayList<Actividad> antecesoras;    
    private ArrayList<Actividad> sucesoras;
       public Actividad(){
            id=" ";
            duracion=0;
            antecesoras=null;
            sucesoras=null;
        }
        public Actividad(String _id, int _duracion){
            id=_id;
            duracion=_duracion;
         antecesoras=new ArrayList();
         sucesoras=new ArrayList();
        }
        public String getId(){
            return id;
        }
        public void setId(String _id){
            id=_id;
        }
        public int getDuracion(){
            return duracion;
        }
        public void setDuracion(int _duracion){
            duracion=_duracion;
        }
      public ArrayList getAntecesoras(){
          return antecesoras;
      }
      public void setAnteceoras(ArrayList<Actividad> _antecesoras){
          antecesoras=_antecesoras;
      }
      public ArrayList getSucesoras(){
          return antecesoras;
      }
      public void setSucesoras(ArrayList<Actividad> _sucesoras){
          sucesoras=_sucesoras;
      }
      public boolean equals(Actividad obj){
          return this.getId().equals(obj.getId());
      }
      public void agregarS(Actividad _sucesora){
          sucesoras.add(_sucesora);
      }
      public void agregarA(Actividad _antecesora){
          antecesoras.add(_antecesora);
      }
}