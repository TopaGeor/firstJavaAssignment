import exercises.ArraysCollections;
import exercises.PasswordCheck;
import exercises.SimpleAlgorithms;

public class Main {
    public static void main(String args[]){
        SimpleAlgorithms set1 = new SimpleAlgorithms();
        //set1.runAllFunctions();

        ArraysCollections set2 = new ArraysCollections();
        //set2.runAllFuctions();

        //!#$%^&*_+=<>,.?/;:|
        PasswordCheck set3 = new PasswordCheck("Lalilulelo1.");
        set3.testPassword();

    }
}
