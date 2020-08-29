package exercises;

public class SimpleAlgorithms {
    private final String negativeInput = "This math function is for non negatives numbers";
    private final String nonPositiveInput = "This math function is only for positives numbers";
    private final String resultIsOne = "The result is: 1";
    private final String result = "The result is: ";

    public SimpleAlgorithms(){
    }

    public void runAllFunctions(){
        System.out.println("Calculate factorial of 2");
        calculateFactorial(2);

        System.out.println("Calculate factorial of 20");
        calculateFactorial(20);

        System.out.println("Check if number 20 is prime");
        System.out.println(isPrime(20));

        System.out.println("Check if number 11 is prime");
        System.out.println(isPrime(11));

        System.out.println("Calculate harmonic series for number 12");
        calculateHarmonicSeries(12);

        System.out.println("Find how many digits 100000001 has:");
        countDigits(100000001);

        System.out.println("Find the decimals of number 4.23");
        findDecimalPart(4.23);
    }


    /**
     * 1. Write a program that calculates the factorial of a number n (n!).
     * 2. Find the maximum value of n as int so that the calculated output is valid.
     * @param n is the integer that we want to find the factorial for
     */
    public void calculateFactorial(int n){

        if (n < 0){
            System.out.println(negativeInput);
            return;
        }

        if (n == 0){
            System.out.println(resultIsOne);
            return;
        }

        int factorial = 1;
        int tempFactorial = 1;
        while (n > 0){
            tempFactorial *= n;
            if (tempFactorial > factorial){
                factorial = tempFactorial;
                n--;
            }
            else {
                break;
            }
        }

        System.out.println(result + factorial);
    }

    /*

    * */

    /**
     * 3.Write a program that returns true or false depending on if the number is prime or not.
     * @param n an integer
     * @return true if n is prime else false
     */
    public boolean isPrime(int n){
        double root = Math.pow(n, 0.5);

        for(int i = 2; i <= root; i++){
            if ((n % i) == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 4.Write a program that, for a given n, it calculates the following value: 1 + ½ + ⅓+ ... + 1/n.
     * @param n is how far the big sum will go in order to calculate the Harmonic Series
     */
    public void calculateHarmonicSeries(int n){
        if (n < 1){
            System.out.println(nonPositiveInput);
            return;
        }

        double harmonicSeries = 1;
        for (double i = 2; i <= n; i++){
            harmonicSeries += 1 / i;
        }
        System.out.println(result + harmonicSeries);
    }

    /**
     * 5.Write a program that counts the digits of a long number.
     * @param n finds how many digits the n has
     */
    public void countDigits(long n){
        int digits = 0;
        while (n >= 1){
            digits++;
            n /= 10;
        }
        System.out.println(digits);
    }

    /**
     * 6.Given a positive float number, print its decimal part. For example, given the number 2.31, the output should be 0.31.
     * @param n if a float number, and here we show the decimal part of it
     */
    public void findDecimalPart(double n){
        if (n <= 0){
            System.out.println(nonPositiveInput);
        }

        int nAsInt = (int)n;
        System.out.println(result + (n - nAsInt));
    }
}
