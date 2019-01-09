import java.math.BigInteger;
import java.util.ArrayList;

public class Komponente52 {

    public static void main(String args[]) {
        ArrayList<BigInteger> primes = Komponente52.getInstance().innerMethodExecute(new BigInteger("2") , new BigInteger("293"));
        for(BigInteger bigint : primes) {
            System.out.println(bigint.intValue());
        }
    }

    private static Komponente52 instance = new Komponente52();
    public Port port;

    private Komponente52() {
        port = new Port();
    }

    public static Komponente52 getInstance() {
        return instance;
    }

    public class Port implements IKomponente52 {
        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return innerMethodExecute(rangeFrom, rangeTo);
        }
    }

    public ArrayList<BigInteger> innerMethodExecute(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> candidates = generatePrimes(rangeFrom, rangeTo);
        ArrayList<BigInteger> solution = new ArrayList<>();
        for (BigInteger number: candidates) {
            if(checkNumber(number)) {
                solution.add(number);
            }
        }
        return solution;
    }

    private boolean checkNumber(BigInteger candidate) {
        System.out.println(candidate.intValue());
        char[] candidateChars = candidate.toString().toCharArray();
        StringBuilder reverse = new StringBuilder();
        for (int i = (candidateChars.length - 1); i >= 0; i--) {
            reverse.append(candidateChars[i]);
        }
        BigInteger reveseBigInteger = new BigInteger(reverse.toString());
        return isPrime(reveseBigInteger);
    }

    private ArrayList<BigInteger> generatePrimes(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> list = new ArrayList();
        BigInteger counter = new BigInteger(rangeFrom.toString());
        while (counter.compareTo(rangeTo.add(new BigInteger("1"))) != 0) {
            if(isPrime(counter)) {
                list.add(counter);
            }
            counter = counter.add(new BigInteger("1"));
        }
        return list;
    }

    private boolean isPrime(BigInteger testNumber){
        int divisorCounter=1;
        BigInteger index,i ;

        for ( index= new BigInteger("2"); index.compareTo(testNumber) !=1; index=index.add(new BigInteger("1"))){
            for(i= new BigInteger("2"); i.compareTo(index) != 1; i=i.add(new BigInteger("1"))){
                if((testNumber.mod(i).equals(BigInteger.ZERO) )){
                    divisorCounter++;
                }
                if(divisorCounter>2){
                    return false;
                }
            }
        }
        return true;
    }
}
