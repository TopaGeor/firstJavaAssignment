package exercises;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordCheck {
    private String password;


    public void testPassword(){
        boolean uppercase = checkUppercase();
        System.out.println("Has an uppercase character");
        System.out.println(uppercase);

        boolean lowercase = checkLowercase();
        System.out.println("Has a lowercase character");
        System.out.println(lowercase);

        boolean hasNumber = checkForNumber();
        System.out.println("Has a number");
        System.out.println(hasNumber);

        boolean hasSpecialCharacter = checkForSpecialCharacter();
        System.out.println("Has a special character");
        System.out.println(hasSpecialCharacter);

        boolean hasWhiteSpaces = checkForWhiteSpace();
        System.out.println("Has white space character");
        System.out.println(hasWhiteSpaces);

        boolean longPassword = checkLength();
        System.out.println("Is a long password");
        System.out.println(longPassword);

        boolean hasSequence = checkThreeRepeatedCharacters();


    }

    public boolean checkUppercase(){
        Pattern pattern = Pattern.compile("(?=.*[A-Z])");
        Matcher matcher = pattern.matcher(this.password);
        return matcher.lookingAt();
    }

    public boolean checkLowercase(){
        Pattern pattern = Pattern.compile("(?=.*[a-z])");
        Matcher matcher = pattern.matcher(this.password);
        return matcher.lookingAt();
    }

    public boolean checkForNumber(){
        Pattern pattern = Pattern.compile("(?=.*[0-9])");
        Matcher matcher = pattern.matcher(this.password);
        return matcher.lookingAt();
    }

    public boolean checkForSpecialCharacter(){
        Pattern pattern = Pattern.compile("(?=.*[~!@#$%^&*_+=<>,.?/;:|])");
        Matcher matcher = pattern.matcher(this.password);
        return matcher.lookingAt();
    }

    public boolean checkForWhiteSpace(){
        Pattern pattern = Pattern.compile("(?=\\S+$)");
        Matcher matcher = pattern.matcher(this.password);
        return !matcher.lookingAt();
    }

    public boolean checkLength(){
        Pattern pattern = Pattern.compile(".{8,}");
        Matcher matcher = pattern.matcher(this.password);
        return matcher.lookingAt();
    }

    public boolean checkThreeRepeatedCharacters(){
        int repeats = 0;

        for (char c: this.password.toCharArray()){
            System.out.println("LALILULELO");
        }
        return true;
    }

}
