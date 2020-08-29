import exercises.ArraysCollections;
import exercises.PasswordCheck;
import exercises.SimpleAlgorithms;

public class Main {
    public static void main(String[] args){
        System.out.println("First Chapter");
        SimpleAlgorithms set1 = new SimpleAlgorithms();
        set1.runAllFunctions();

        System.out.println();
        System.out.println("Second Chapter");
        ArraysCollections set2 = new ArraysCollections();
        set2.runAllFunctions();

        System.out.println();
        System.out.println("Third Chapter");
        PasswordCheck set3 = new PasswordCheck("Lalilulelo1.");
        set3.testPassword();

    }
}
