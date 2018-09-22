package Datos;

import java.util.*;

public class Actividad {
    private String id;
    private int duracion;
    private int IC;
    public int contador;
    public int contador1;
//    private int TC;
    private int IL;
//    private int TL;
   
    private ArrayList<Actividad> antecesoras;    
    private ArrayList<Actividad> sucesoras;
       public Actividad(){
            id=" ";
            duracion=0;
            antecesoras=new ArrayList();
            sucesoras=new ArrayList();
            IC=0;
//            TC=0;
            IL=0;
//            TL=0;
            contador=0;
            contador1=0;
        }
        public Actividad(String _id, int _duracion){
            id=_id;
            duracion=_duracion;
         antecesoras=new ArrayList();
         sucesoras=new ArrayList();
         IC=0;
//         TC=0;
         IL=0;
//         TL=0;
        contador=0;
        contador1=0;
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
          return sucesoras;
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
      public int getIC(){
          return IC;
      }
      public void setIC(int _IC){
          IC=_IC;
      }
      public int getIL(){
          return IL;
      }
      public void setIL(int _IL){
          IL=_IL;
      }
      public int getcontador(){
          return contador;
      }
//      public int  getTC(){
//          return TC;
//      }
//      public void setTC(int _TC){
//          TC=_TC;
//      }
//      public int getTL(){
//          return TL;
//      }
//      public void setTL(int _TL){
//          TL=_TL;
//      }
      public int TC(){
          return this.IC+this.duracion;
      }
      public int TL(){
          return this.IL+this.duracion;
      }
      public boolean holgura(){
          int x=IC-IL;
          int y=this.TC()-this.TL();      
          return ((x==0)&&(y==0));
      }
      @Override
      public String toString(){
          String x=("Id: "+this.getId()+"  "+this.getIC()+" "+this.TC()+" "+this.getIL()+" "+this.TL()/*+"Duracion: "+this.getDuracion()*/);
          return x;
      }
}