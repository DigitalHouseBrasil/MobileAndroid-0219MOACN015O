
public class NumeroMaior {

    public static void main (String [] args) {
        System.out.println(numeroMaior(5,20,10));

    }

    public static int numeroMaior(int numA, int numB, int numC){
       if(numA > numB && numA> numC){
           return numA;
       } else if(numB > numC && numB > numA){
           return numB;
       } else {
          return numC;
       }
    }

}
