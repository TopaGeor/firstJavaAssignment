package exercises;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.StrictMath.abs;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordCheck {
    private String password;


    public void testPassword(){
        int score = 0;
        boolean uppercase = checkUppercase();
        if(uppercase) score++;

        boolean lowercase = checkLowercase();
        if(lowercase) score++;

        boolean hasNumber = checkForNumber();
        if(hasNumber) score++;

        boolean hasSpecialCharacter = checkForSpecialCharacter();
        if (hasSpecialCharacter) score++;

        boolean hasWhiteSpaces = checkForWhiteSpace();
        if (!hasWhiteSpaces) score++;

        boolean hasSequence = checkThreeRepeatedCharacters();
        boolean hasConsecutiveCharacters = checkForConsecutiveCharacters();
        if (!hasSequence && !hasConsecutiveCharacters) score++;

        if(checkLength()){
            score++; // if the function checkLength is true then the password has one more point
            if (score < 5) System.out.println("Password OK");
            else if (score == 5) System.out.println("Strong Password");
            else if (score == 6) System.out.println("Very Strong Password");
        }
        else System.out.println("Invalid password");
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
        int repeats = 1;
        char old_char = ' ';
        for (char c: this.password.toCharArray()){
            if (c == old_char){
                repeats++;
                if (repeats >= 3){
                    return true;
                }
            }
            else {
                old_char = c;
                repeats = 1;
            }
        }
        return false;
    }

    public boolean checkForConsecutiveCharacters(){
        char[] letters = password.toCharArray();
        List<Integer> numericList = new ArrayList<>();
        for(Character c: letters){
            numericList.add(Character.getNumericValue(c));
        }

        int repeats = 0;
        System.out.println(numericList);
        for(int i = 0; i < numericList.size() - 1; i++){
            if (abs(numericList.get(i) - numericList.get(i + 1)) == 1) {
                repeats++;
                if (repeats >= 3) {
                    return true;
                }
            }
            else {
                repeats = 0;
            }
        }
        return true;
    }
}
