package exercises;

import java.util.*;

public class ArraysCollections {
    private List<Integer> classList;
    private SimpleAlgorithms simpleAlgo;
    private List<Integer> testingInput = Arrays.asList(1, 2, 3, 4, 5);
    private String testString = "AbdBa";

    public ArraysCollections(){
        classList = new ArrayList<>(testingInput);
        simpleAlgo = new SimpleAlgorithms();
    }

    /**
     * Run all functions
     */
    public void runAllFunctions(){
        System.out.println(onlyPrimes(classList));

        System.out.println("Find the prime numbers of the array:");
        System.out.println(classList);
        System.out.println("The prime numbers are:");
        classList.addAll(testingInput);

        System.out.println("Array for the second question:");
        System.out.println(classList);
        System.out.println("The result is:");
        System.out.println(eliminateDuplicates(classList));

        System.out.println("Find the digits of the number 234145 and return them in reverse order:");
        System.out.println(digitsDescendingOrder(234145));

        MyStack myStack = new MyStack();
        System.out.println("Reversing string:");
        System.out.println(testString);

        myStack.pushString(testString);
        int size = myStack.getArray().size();
        String reverseString = "";
        for (int i = 0; i < size; i++){
            reverseString += myStack.pop();
        }
        System.out.println("The reversed string is:");
        System.out.println(reverseString);

        checkWordSymmetric(testString);
    }

    /**
     * Given a list of integers, return a sub list that contains only the prime numbers
     * @param aList a list of integers
     * @return return an ArrayList with the prime numbers from the aList
     */
    public List<Integer> onlyPrimes(List<Integer> aList){
        List<Integer> returnArray = new ArrayList<>();
        for (Integer i: aList) {
            if (simpleAlgo.isPrime(i)){
                returnArray.add(i);
            }
        }
        return returnArray;
    }

    /**
     * Implement a way of finding a list eliminating the duplicates from a list.
     * @param aList a list of integers
     * @return return an ArrayList with the unique elements from aList
     */
    public ArrayList<Integer> eliminateDuplicates(List<Integer> aList){
        Set<Integer> aSet = new HashSet<>(aList);
        return new ArrayList<>(aSet);
    }


    /**
     * Write a program that returns the digits of number in descending order
     * @param n an integer
     * @return a list of integers that are in reverse order
     */
    public List<Integer> digitsDescendingOrder(int n){
        List<Integer> digits = new ArrayList<>();
        while(n > 1) {
            digits.add(n % 10);
            n /= 10;
        }
        digits.sort(Comparator.reverseOrder());
        return digits;
    }

    /**
     * Write a program that check if a word is symmetric,  ignoring cases (i.e. AbdBa is symmetric).
     * @param word the word that we will check if it is symmetric
     */
    public void checkWordSymmetric(String word){
        MyStack localStack = new MyStack();
        word = word.toLowerCase();
        for (int i = 0; i < word.toCharArray().length / 2; i++){
            localStack.push(word.toCharArray()[i]);
        }

        int startPos;
        if (word.length() % 2 == 0) {
            startPos = word.length() / 2;
        }
        else {
            startPos = (word.length() + 1) / 2;
        }

        for (int i = startPos; i < word.toCharArray().length; i++){
            Character c1 = word.toCharArray()[i];
            Character c2 = localStack.pop();
            if(!c1.equals(c2)){
                System.out.println("Word is not Symmetric");
                return;
            }
        }
        System.out.println("Word is symmetric");
    }
}
