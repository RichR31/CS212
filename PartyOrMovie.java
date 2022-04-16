import java.util.Random;
public class PartyOrMovie{

  public static void main(String[] args) {

    Random choice = new Random();
    if(choice.nextBoolean()){
      System.out.println("Cats");
    }else{
      System.out.println("Strawberrys");
    }

  }
}
