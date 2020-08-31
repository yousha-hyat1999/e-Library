//------------------------------------------------------------------------------------------------------
//Yousha Hyatoolla & ID:40099559
//comp 249
//Assignment #1
//Question 1 part 2
//Due date: February 1st, 2019.
//------------------------------------------------------------------------------------------------------
import java.util.Scanner;
public class Library {
	/**
	 * @author yousha
	 * @ID 40099559
	 * @Date 01/31/2019
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("***************Welcome to my electronic library***************");
		Scanner kb = new Scanner(System.in);
		System.out.print("\n\nPlease enter the maximum number of books your bookstore will contain: ");
		int maxNumber = kb.nextInt();
		
		Book[] inventory = new Book[maxNumber];
		
		
		int booksLeft=maxNumber;
		int mainPr = 0;
		
		while (true) {//The main while loop.
		if (mainPr >= 12) {//To make sure that the user has 4 chances to enter the correct password.
				System.out.print("\nProgram detected suspicious activities and must terminate immediately!");
				break;
			}
		//the menu that displays all options
		System.out.print("\nWhat do you want to do?" );
		System.out.print("\n1. Enter new books (password required)\n2. Change information of a book (password required)\n3. Display all books by a specific author ");
		System.out.print("\n4. Display all books under a certain price\n5. Quit");
		
		System.out.print("\n\nPlease enter your choice: ");
		int decision = kb.nextInt();//Choosing the option.
		int process=0,process1 = 0;//These variables make sure that the password system for options 1 and 2 work.
		
		System.out.println();
		
		switch (decision) {//Making the option chosen work.
//------------------------------------------------case 1-----------------------------------------------------------------------
		case 1:{
			while (process < 3) {//Making sure that the user has 3 chances to enter the correct password.
			System.out.print("Password: ");
			String password = kb.next();
			
			if (password.compareTo("password")==0) {
				break;}
			else {
				process++;
				mainPr++;}
			}
			if (process>3) {
				break;}
			else {
				while (true) {//This whole process is to create new books
				System.out.print("\nHow many books do you want to create? ");
				int numB = kb.nextInt();
				if (numB>booksLeft && booksLeft!=0) {
					System.out.print("\nSorry, that's more than your number of spaces left to add a book("+booksLeft+"). Please try again.");}
				else if (numB<=booksLeft){
					System.out.print("\nYou had "+booksLeft+" spot(s) left to add book(s) but now you'll have "+(booksLeft-numB)+" space(s) left");
					booksLeft=booksLeft-numB;
					System.out.print("\nPlease enter all attributes for your book(s): ");
					for (int z=0;z<numB;z++) {
						System.out.print("\nBook #"+z);
						System.out.print("\nAuthor: ");
						String AUT = kb.next();
						System.out.print("\nTitle: ");
						String TITL = kb.next();
						System.out.print("\nISBN: ");
						long nIS = kb.nextLong();
						System.out.print("\nPrice: ");
						double PRI = kb.nextDouble();
						
						inventory[z] = new Book(AUT,TITL,nIS,PRI);
						
					}
					break;}

				else if (booksLeft==0) {
					System.out.print("\nYour library has reached the maximum number of books. ");
				}
				}
				}
			}
		break;
//------------------------------------------End of case 1------------------------------------------------	
//---------------------------------------------case 2----------------------------------------------------
		case 2:{
			
			while (process1 < 3) {//Making sure the user enters the correct password within 3 times.
				System.out.print("Password: ");
				String password = kb.next();
				
				if (password.compareTo("password")==0) {
					break;}
				else {
					process1++;}
			}
			if (process1>=3)
				break;
			int breaker=0;
			int br = 0;
			while (true) {
			System.out.print("\n\nWhich book would you like to update? Please enter -1 if you don't want to update any books or else enter the number: ");
			int zeBook = kb.nextInt();
			if (zeBook == -1) {
				br++;
				break;}
			else if (zeBook>=Book.findNumberOfCreatedBooks()) {
				System.out.print("\nSorry, but there is no book at this location. Would you like to try another book? ");
				
				String response = kb.next();
				if (response.compareToIgnoreCase("yes")==0) {
					continue;}
				else {
					breaker++;
					break;}
				}
			else {
				System.out.print("\nBook #"+zeBook);
				System.out.print("\n"+inventory[zeBook].toString());
				while (true) {//This whole process is to make sure that the user changes an information of book.
					int breaker1=0;
					System.out.print("\nWhich information would you like to change? \n1. Author\n2. Title\n3. ISBN\n4. Price\n5. Quit");
					System.out.print("\nEnter your choice> ");
					int choice = kb.nextInt();
					switch (choice) {//Choosing which one to change.
					
					case 1:{
						System.out.print("\nPlease enter the name of the author: ");
						String aut = kb.next();
						inventory[zeBook].setAuthor(aut);
						System.out.print("\n"+inventory[zeBook].toString());//Displaying the info after the change is made.
						break;
					}
					case 2:{
						System.out.print("\nPlease enter the title of the book: ");
						String titl = kb.next();
						inventory[zeBook].setTitle(titl);
						System.out.print("\n"+inventory[zeBook].toString());//Displaying the info after the change is made.
						break;
					}
					case 3:{
						System.out.print("\nPlease enter the ISBN number: ");
						long isb = kb.nextLong();
						inventory[zeBook].setISBN(isb);
						System.out.print("\n"+inventory[zeBook].toString());//Displaying the info after the change is made.
						break;
					}
					case 4:{
						System.out.print("\nPlease enter the price of the book: ");
						double pri = kb.nextDouble();
						inventory[zeBook].setPrice(pri);
						System.out.print("\n"+inventory[zeBook].toString());//Displaying the info after the change is made.
						break;
					}
					case 5:{//To quit option 2.
						breaker1++;
						break;
						
					}
						
					}//for switch
					if (breaker1 != 0)
						break;
				}//for while loop
				
			}//if-else statement
			}//main while loop of case 2
			if (breaker != 0 || br !=0)
				break;
		}
		
//----------------------------------------------End of case 2--------------------------------------------------	
//--------------------------------------------------case 3-----------------------------------------------------
		case 3:{//Displaying books with the same author chosen by the user.
		System.out.print("\nEnter the name of the author: ");
		String auChoice = kb.next();
		
		for (int i=0;i<Book.findNumberOfCreatedBooks();i++) {
			if (auChoice.equalsIgnoreCase(inventory[i].getAuthor())) {
				System.out.print("\n"+inventory[i].toString());}
		}
		break;
		}
		
//-------------------------------------------------end of case 3------------------------------------------------
//--------------------------------------------------case 4-------------------------------------------------------
		case 4:{//Displaying books with a lower price than the one chosen by the user.
			System.out.print("\nPlease enter a price: ");
			double prChoice = kb.nextDouble();
			
			for (int i=0;i<Book.findNumberOfCreatedBooks();i++) {
				if (inventory[i].getPrice()<prChoice) {
					System.out.print("\n"+inventory[i].toString());}
			}
			break;}
//-------------------------------------------------end of case 4---------------------------------------------------
//--------------------------------------------------case 5----------------------------------------------------
		case 5:{//Exiting the library.
			System.out.print("\nThank you for using my electronic library, hope to see you soon");
			System.exit(0);
			break;
		}
//-----------------------------------------End of case 5------------------------------------------------------		

		
		}
		
		}// while statement
		
		
		
		
		
	kb.close();	
		
	}

}

//-----------------------------------------------END OF THE PROGRAM----------------------------------------------------
