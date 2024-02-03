// ---------------------------------
// Assignment #0
// Question: 1
// Written by: Étienne Beaumier 40211362
// ----------------------------------

/**
 * This class is used to create Book objects. A book will contain a title, author, ISBN and price of the book.
 * It also contains a counter that keeps track of the number of books created.
 * It contains a constructor, getters, setters, a method to find the number of books created,
 * a method to compare two books and a toString method.
 */
public class Book {

    private String title;
    private String author;
    private long ISBN;
    private double price;
    public static int counter = 0;

    public Book() {
        title = "Unknown";
        author = "Unknown";
        ISBN = 0;
        price = 0.0;
        counter++;
    }

    public Book(String title, String author, long ISBN, double price) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
        counter++;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getISBN() {
        return ISBN;
    }

    public double getPrice() {
        return price;
    }

    public static int findNumberOfCreatedBooks() {
        return counter;
    }

    public boolean equals(Book book) {
        return (this.ISBN == book.ISBN && this.price == book.price);
    }

    public String toString() {
        return "\nAuthor: " + author + "\nTitle: " + title + "\nISBN: " + ISBN + "#\nPrice: $" + price;
    }
}
