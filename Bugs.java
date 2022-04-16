/**
  *Bugs.java
  *@description Generates "Bugs in the code" song
  *@author Ricardo Salazar
  *@version 1.0 2022-01-31
*/

import java.util.Scanner;

public class Bugs{
  // --- attributes ---
  private int bugs;
    Scanner scan = new Scanner(System.in);

  // --- methods ---

  /** constructor*/
  public Bugs(){

  }

  public void setBugs(){
    Scanner scan = new Scanner(System.in);
    System.out.print("Hi, what's your name?: ");
    String s = scan.nextLine();
    System.out.println("Hi " + s + "!");
    System.out.println("How many bugs do you have?");
    bugs = scan.nextInt();
    scan.nextLine();

  }

  public void printSong(){
    while (bugs > 0){
        System.out.println("");
        switch(bugs){
          case 1:
            System.out.println("♬ There is " + bugs + " bugs in my code\n" + bugs + " bug in my code ♬");
            System.out.println("♬ I found it and I solved it ♬");
            bugs--;
            System.out.println("♬ Now there are no bugs in my code ♬");
            break;
          case 2:
            System.out.println("♬ There are " + bugs + " bugs in my code\n" + bugs + " bugs in my code ♬");
            System.out.println("♬ I found one and I solved it ♬");
            bugs--;
            System.out.println("♬ Now there is " + bugs + " bug in my code ♬");
            System.out.print("Please press enter to continue. ");
            scan.nextLine();
            break;
          default:
            System.out.println("♬ There are " + bugs + " bugs in my code\n" + bugs + " bugs in my code ♬");
            System.out.println("♬ I found one and I solved it ♬");
            bugs--;
            System.out.println("♬ Now there are " + bugs + " bugs in my code ♬");
            System.out.print("Please press enter to continue. ");
            scan.nextLine();
            break;
        }


    }
  }

  public static void main(String[] args) {
    Bugs bugs1 = new Bugs();
    bugs1.setBugs();
    bugs1.printSong();
  }
}
