//------------------------------------------------------------------------------------------------------
//Yousha Hyatoolla & ID:40099559
//comp 249
//Assignment #1
//Question 1 part 1
//Due date: February 1st, 2019.
//------------------------------------------------------------------------------------------------------
/**
 * @author yousha
 *@ID 40099559
 *@Date 01/31/2019
 *This is the book class.
 */
public class Book {
	
	private String title;
	private String author;
	private long ISBN;
	private double price;
	private static int nb;
	
//Constructors:
	
	/**
	 * Parametrized constructor.
	 * @param a1
	 * @param t1
	 * @param I1
	 * @param p1
	 */
	public Book(String a1,String t1,long I1,double p1) {
		author = a1;
		title = t1;
		ISBN = I1;
		price = p1;
		nb++;
	}
	
//Copy constructors:
	/**
	 * copy constructor
	 * @param x
	 */
	Book (Book x){
		title = x.title;
		author = x.author;
		ISBN = x.ISBN;
		price = x.price;
		nb++;
		}
	
//Accessors:
	
	/**
	 * To access the private variable title.
	 * @return title
	 */
	public String getTitle() {return title;}
	/**
	 * To access the private variable author.
	 * @return author
	 */
	public String getAuthor() {return author;}
	/**
	 * To access the private variable ISBN.
	 * @return ISBN
	 */
	public long getISBN() {return ISBN;}
	/**
	 * To access the private variable price.
	 * @return price
	 */
	public double getPrice() {return price;}
	
//Mutators:
	
	/**
	 * To set the title of a book.
	 * @param TT
	 */
	public void setTitle(String TT) {
		title = TT;
	}
	
	/**
	 * To set the author of a book.
	 * @param AA
	 */
	public void setAuthor(String AA) {
		author = AA;
	}
	
	/**
	 * To set the ISBN of a book.
	 * @param II
	 */
	public void setISBN(long II) {
		ISBN = II;
	}
	
	/**
	 * To set the price of a book.
	 * @param PP
	 */
	public void setPrice(double PP) {
		price = PP;
	}

//The toString() method:
	
	/* (non-Javadoc)
	 * Displaying the information of a book using the toString() method.
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String output = "Author: " + author +".\n"+"Title: "+ title + ".\n" + "ISBN: " + ISBN + ".\n" + "Price: " + price + "$.\n";
		return output;
	}
	
//The findNumberOfCreatedBooks () method:
	/**
	 * To find the number of created books.
	 * @return nb
	 */
	public  static int findNumberOfCreatedBooks() {
		return nb;
		
	}
	
//The equals() method:
	/**
	 * @param x
	 * @return true if they are equal and false if they are not equal.
	 */
	public boolean equals(Book x) {
		if ((ISBN==x.ISBN)&&(price==x.price))
			return true;
		else return false;
			}
	
	
}
