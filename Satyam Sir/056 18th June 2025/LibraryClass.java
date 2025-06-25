// UML DIAGRAM-3

/*
Implement a program with two classes according to the following UML diagram:


REQUIREMENTS
-------------
● The constructor Library(String, String, int, int) shall create two component objects of type Book , 
  i.e., the first book and the second book, and initialize them using corresponding title and book ID.
  
● The program shall create in the main() function an object of type Library using its constructor 
  with four parameters that contain titles and book IDs of two books (the first book and the second 
  book), your code should use the following given book information:
  Alice in Wonderland, 30184 – for the 1st book 
  Hamlet, 30219 – for the 2nd book
  
● The constructor Book(String, int) shall initialize the book’s title and book ID, and store the title in 
  the field title and store the book ID in the field bookID.
  
● Then the main() method shall call the printBooks() method to print information about the books 
  in the following example format.
  
● Your code must work exactly as the specification and the output should be exactly the 
  same as the output example.
  
  
  Example of the program output:
  ------------------------------
  The first book: Alice in Wonderland, 30184
  The second book: Hamlet, 30219

*/


public class LibraryClass {
    public static void main(String[] args) {
        Library library = new Library("Alice in Wonderland", "Hamlet", 30184, 30219);
        library.printBooks();
    }
}

class Book {
    private String title;
    private int bookID;

    public Book(String title, int bookID) {
        this.title = title;
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public int getBookID() {
        return bookID;
    }
}

class Library {
    private Book firstBook;
    private Book secondBook;

    public Library(String title1, String title2, int id1, int id2) {
        firstBook = new Book(title1, id1);
        secondBook = new Book(title2, id2);
    }

    public void printBooks() {
        System.out.println("The first book: " + firstBook.getTitle() + ", " + firstBook.getBookID());
        System.out.println("The second book: " + secondBook.getTitle() + ", " + secondBook.getBookID());
    }
}

