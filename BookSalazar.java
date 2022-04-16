/**
  *BookSalazar.java
  *@description A book class to create book objects
  *@author Ricardo Salazar
  *@version 1.0 2022-01-22
*/

import java.util.Scanner;

public class BookSalazar{

  // ----attributes----
  private String author;
  private String title;
  private String publisher;
  private int year;
  private int pages;
  private double price;

  // ----methods----


  /** Constructor class */
  public BookSalazar(String a, String t){
    author = a;
    title = t;
  }

  /** returns author attribute */
  public String getAuthor(){
    return author;
  }

  /** returns title attribute */
  public String getTitle(){
    return title;
  }

  /** Sets the publisher attribute*/
  public void setPublisher(String p){
    publisher = p;
  }

  /** returns publisher attribute */
  public String getPublisher(){
    return publisher;
  }

  /** Sets the year attribute*/
  public void setYear(int y){
    year = y;
  }

  /** returns year attribute */
  public int getYear(){
    return year;
  }

  /** Sets the pages attribute*/
  public void setPages(int p){
    pages = p;
  }

  /** returns pages attribute */
  public int getPages(){
    return pages;
  }

  /** Sets the price attribute*/
  public void setPrice(double p){
    price = p;
  }

  /** returns price attribute */
  public double getPrice(){
    return price;
  }
  /** returns the information of the book in a string */
  public String toString(){
    String b;
    b = "The book \"" + title + "\" by " + author;
    b += " was published by " + publisher + " in " + year;
    b += ", it has a total of " + pages + " pages, and its price is $" + price + ".";

    return b;
  }

  /** main method */
  public static void main(String[] args){
    BookSalazar book1 = new BookSalazar("Antoine de Saint-Exupéry", "The Little Prince");
    BookSalazar book2 = new BookSalazar("George Orwell", "1984");

    book1.setPublisher("Harvest Book Harcourt Inc.");
    book1.setYear(1943);
    book1.setPages(96);
    book1.setPrice(6.81);

    book2.setPublisher("Signet Classics");
    book2.setYear(1950);
    book2.setPages(328);
    book2.setPrice(7.84);

    System.out.println(book1.toString());
    System.out.println(book2.toString());



  }// end of main method
}// end of class
