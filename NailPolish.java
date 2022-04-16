import java.util.Random;
public class NailPolish{


  public static void main(String[] args) {
    Random rand = new Random();
    int random = rand.nextInt(3)+1; //starts at 0, so add 1
    System.out.println("ELLA LOCA!!!!!!!!");
    switch (random){
      case 1:
        System.out.println("Píntatelas de Negro, Mariam!, Te va a quedar bien");
        break;
      case 2:
        System.out.println("Píntatelas de Azulito, Mariam!, o te ahuevas?");
        break;
      case 3:
        System.out.println("Píntatelas de Rosa, Mariam!, no te lo pienses mucho");
        break;

    }
  }
}
