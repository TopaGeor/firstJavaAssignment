package exercises;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MyStack {
    private List<Character> array;

    /**
     * Constructor for the class, initialization of data
     */
    public MyStack(){
        array = new ArrayList<>();
    }

    /**
     * Add a character to the data
     * @param s the character to be added
     */
    public void push(Character s){
        array.add(s);
    }

    /**
     * Add a string to the data
     * @param string the string to be added
     */
    public void pushString(String string){
        for (char s: string.toCharArray()) {
            array.add(s);
        }
    }

    /**
     * Remove and return the last character from the data
     * @return the last character of the data
     */
    public Character pop(){
        int size = array.size();
        if (size < 1){
            return null;
        }
        char c = array.get(size - 1);
        array.remove(size - 1);
        return c;
    }

    /**
     * Return the last character
     * @return the last character of the data
     */
    public Character peek(){
        int size = array.size();
        if (size < 1){
            return null;
        }
        return  array.get(size - 1);
    }
}
