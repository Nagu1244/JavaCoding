package java8;

class InvalidAgeExcetion extends Exception {
    public InvalidAgeExcetion(String message) {
        super(message);
    }
}
public class CustomException {
    public static void main(String args[]) throws InvalidAgeExcetion {
        int voteingAge = 17;
        if(voteingAge<18) {
            throw new InvalidAgeExcetion("Not valid for voting");
        } else {
            System.out.println("Eligeble for voting");
        }
    }
}
