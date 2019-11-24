public class AlgumMaior {

    public static void main(String[] args) {

        System.out.println(algumMaior(5,10 ,6 ,7 ));
        System.out.println(numeroMaior(5,6,7));
    }

    public static boolean algumMaior(int umNumeroA, int umNumeroB, int umNumeroC, int umNumeroD) {

        return (umNumeroA > umNumeroC && umNumeroA > umNumeroD) && (umNumeroB > umNumeroC && umNumeroB > umNumeroD);
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
