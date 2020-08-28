package exercises;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Data
public class MyStack {
    private ArrayList<Character> array;

    public MyStack(){
        array = new ArrayList<Character>();
    }

    public void push(Character s){
        array.add(s);
        return;
    }

    public void pushString(String string){
        for (char s: string.toCharArray()) {
            array.add(s);
        }
        return;
    }

    public Character pop(){
        int size = array.size();
        if (size < 1){
            return null;
        }
        char c = array.get(size - 1);
        array.remove(size - 1);
        return c;
    }

    public Character peek(){
        int size = array.size();
        if (size < 1){
            return null;
        }
        char c = array.get(size - 1);
        return c;
    }
}
