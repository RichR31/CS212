/**
*/

public enum Grades {
  A (4.0),
  A_MINUS (3.7),
  B_PLUS (3.3),
  B (3.0),
  B_MINUS (2.7),
  C_PLUS (2.3),
  C (2.0),
  C_MINUS (1.7),
  D_PLUS (1.3),
  D (1.0),
  F (0.0);

  private final double POINTS;

  /** constructor for enum fields */
  Grades(double points){
    POINTS = points;
  }

  /** getter for points */
  public double getPoints(){
    return POINTS;
  }


  public static void main(String[] args) {
    Grades myGrade = Grades.A_MINUS;
    System.out.println(myGrade.getPoints());
  }

}
