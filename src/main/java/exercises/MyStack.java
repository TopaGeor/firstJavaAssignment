package exercises;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MyStack {
    private List<Character> array;

    public MyStack(){
        array = new ArrayList<>();
    }

    public void push(Character s){
        array.add(s);
    }

    public void pushString(String string){
        for (char s: string.toCharArray()) {
            array.add(s);
        }
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
        return  array.get(size - 1);
    }
}
