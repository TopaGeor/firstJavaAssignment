package exercises;

import java.util.*;

public class ArraysCollections {
    private ArrayList<Integer> anArray;
    private SimpleAlgorithms simpleAlgo;
    private List<Integer> testingInput = Arrays.asList(1, 2, 3, 4, 5);
    private String testString = "AbdBa";

    public ArraysCollections(){
        anArray = new ArrayList<Integer>(testingInput);
        simpleAlgo = new SimpleAlgorithms();
    }

    public void runAllFuctions(){
        System.out.println(onlyPrimes(anArray));

        System.out.println("Find the prime numbers of the array:");
        System.out.println(anArray);
        System.out.println("The prime numbers are:");
        anArray.addAll(testingInput);

        System.out.println("Array for the second question:");
        System.out.println(anArray);
        System.out.println("The result is:");
        System.out.println(eliminateDuplicates(anArray));

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

    /*
    Given a list of integers, return a sub list that contains only the prime numbers
    */
    public ArrayList<Integer> onlyPrimes(ArrayList<Integer> aList){
        ArrayList<Integer> returnArray = new ArrayList<Integer>();
        for (Integer i: aList) {
            if (simpleAlgo.isPrime(i)){
                returnArray.add(i);
            }
        }
        return returnArray;
    }

    /*
    Implement a way of finding a list eliminating the duplicates from a list.
    */
    public ArrayList<Integer> eliminateDuplicates(ArrayList<Integer> aList){
        HashSet<Integer> aSet = new HashSet<Integer>(aList);
        ArrayList<Integer> returnArray = new ArrayList<Integer>(aSet);
        return returnArray;
    }

    /*
    Write a program that returns the digits of number in descending order
    */
    public ArrayList<Integer> digitsDescendingOrder(int n){
        ArrayList<Integer> digits = new ArrayList<>();
        while(n > 1) {
            digits.add(n % 10);
            n /= 10;
        }
        Collections.sort(digits, Collections.reverseOrder());
        return digits;
    }

    /*
    Write a program that check if a word is symmetric,  ignoring cases (i.e. AbdBa is symmetric).
     */
    public void checkWordSymmetric(String word){
        MyStack localStack = new MyStack();
        word = word.toLowerCase();
        for (int i = 0; i < word.toCharArray().length / 2; i++){
            localStack.push(word.toCharArray()[i]);
        }

        int startPos = 0;
        if (word.length() % 2 == 0) {
            startPos = word.length() / 2;
        } else {
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
        return;
    }
}