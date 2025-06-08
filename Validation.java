
public class Validation {

    //Makes sure an entered string can be parsed into an int
    public Integer tryParseInt(String someText) {
        try {
            return Integer.parseInt(someText);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}
