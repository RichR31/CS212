/**
  *Registrar.java
  *@description A class for hypotetical Registrar
  *@authorn Ricardo Salazar
  *@version 1.0 2022-01-28
*/

public class Registrar{
  // --- attributes ---

  private String firstName, lastName, classStanding;
  private  int enrollmentYear, currentNumberOfClasses;
  private final ID_NUMBER;
  private  double gpa;
  private static int numberOfEnrolledStudents = 0;

  // --- methods ---

  /** contructor*/
  public Registrar(String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
    numberOfEnrolledStudents++;
    ID_NUMBER = numberOfEnrolledStudents;

    /** Getter for the attribute firstName*/

    /** Getter for the attribute lastName*/

    /** Getter for the attribute classStanding*/

    /** Getter for the attribute enrollmentYear*/

    /** Getter for the attribute currentNumberOfClasses*/

    /** Getter for the attribute credits*/

    /** Getter for the attribute ID_NUMBER*/

    /** Getter for the attribute gpa*/

    /** Getter for the attribute numberOfEnrolledStudents*/

    /** Setter for the attribute firstName*/

    /** Setter for the attribute lastName*/

    /** Setter for the attribute classStanding*/

    /** Setter for the attribute currentNumberOfClasses*/

    /** Setter for the attribute credits*/

    /** Setter for the attribute gpa*/

  }
}
