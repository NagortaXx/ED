package debug;

class Alumno{
   private String nombre;
   private float nota;
   
   Alumno(String nomb){
      nombre = nomb;
   }
   
   public void setNota(float n){
      nota = n;
   }
   
   public float getNota(){
      return nota;
   }
}
   

class Asignatura{

   private String nombre;
   private Alumno[] alumnos;
   private boolean ordenado = false;
   private int posicion;
   private int nAlumnos;
   
   Asignatura(String nomb, int nAl){
      nombre = nomb;
      posicion=0;
      nAlumnos = nAl;
      alumnos = new Alumno[nAlumnos];
   }
   
   public void addAlumno(Alumno al){
      if (posicion<nAlumnos)
         alumnos[posicion] = al;
      posicion++;
   }
   
   private void ordena(){
      if (ordenado == false){
         ordenado = true;
         Alumno aux;
         int N = alumnos.length;
         
         for (int i=0;i<(N-2);i++)
            for (int j=(N-1);j>i;j--)
               if (alumnos[j].getNota()<alumnos[j-1].getNota()){
                  aux = alumnos[j-1];
                  alumnos[j-1] = alumnos[j];
                  alumnos[j] = aux;
                  System.out.print(alumnos[j].getNota());
               }               
      }
   }
   
   public float mediana(){
      ordena();      
      return alumnos[Math.round(alumnos.length/2)].getNota();
   }
}   

public class Ejemplo{
   public static void main(String[] args){
      Asignatura as = new Asignatura("LP", 5);
      
      Alumno a = new Alumno("A");
      a.setNota(6.5f);      
      as.addAlumno(a);
      
      a = new Alumno("B");
      a.setNota(6.2f);      
      as.addAlumno(a);
      
      a = new Alumno("C");
      a.setNota(8.2f);      
      as.addAlumno(a);
      
      a = new Alumno("D");
      a.setNota(5.2f);      
      as.addAlumno(a);
      
      a = new Alumno("E");
      a.setNota(7.2f);      
      as.addAlumno(a);
      
      System.out.println(as.mediana());
      
   }
}