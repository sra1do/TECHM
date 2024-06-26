package Data;
import java.util.*;
class Book {
	private int bookId;
	private String bookTitle;
	private String publisher;
	private double price;
	private int edition;
	private int publishedYear;
	//add getter setter
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public int getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
	//add constructor
	public Book(int bookId, String bookTitle, String publisher, double price, int edition, int publishedYear) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.publisher = publisher;
		this.price = price;
		this.edition = edition;
		this.publishedYear = publishedYear;
	}
	public Book() {
		super();
	}
	//add toString()
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", publisher=" + publisher + ", price=" + price
				+ ", edition=" + edition + ", publishedYear=" + publishedYear + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookId, bookTitle, edition, price, publishedYear, publisher);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return bookId == other.bookId && Objects.equals(bookTitle, other.bookTitle) && edition == other.edition
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& publishedYear == other.publishedYear && Objects.equals(publisher, other.publisher);
	}
	public int compareto(Book second) {
		return Integer.compare(this.bookId, second.bookId);
	}
	
}
public class Test9 {
	public static void main(String[] args) {
		
		Set<String> strings=new HashSet<String>();
		strings.add("Sravan");
		strings.add("Sravan");
		strings.add("Sravan");
		strings.add("Sravan");
		System.out.println(strings);
		
      //creating set of books
		
		Set<Book> books=new HashSet<Book>();
		books.add(new Book(1001,"Pride and Prejudice","whitehall",823,1,1813));
		books.add(new Book(1002,"The great gatsby","printmedia",1000,1,1900));
		books.add(new Book(1003,"To kill a mockingbird","Roll books",823,1,1913));
		books.add(new Book(1004,"1984","Rupa Publication",823,1,1913));
		books.add(new Book(1005,"Animal Farm","Apk Publishers",823,1,1927));
		books.add(new Book(1006,"Anna Karenina","Agarwal Publishers",823,2,1923));
		System.out.println(books);
		
		//remove a book
		
		boolean res=books.remove(new Book(1006,"Anna Karenina","Agarwal Publishers",823,2,1923));
		System.out.println(res);
		System.out.println("After removals "+books);
		
		//search a book
		
		res=books.contains(new Book(1006,"Anna Karenina","Agarwal Publishers",823,2,1923));
		System.out.println(res);
		
		//search a book with less price
		
		Book lesspricedbook=books.stream()
				.min((x,y)->Double.compare(x.getPrice(), y.getPrice()))
						.get();
		System.out.println("Book with less price is "+lesspricedbook);
		
		//search a book with less price
		
		Book morepricedbook=books.stream()
						.max((x,y)->Double.compare(x.getPrice(), y.getPrice()))
								.get();
				System.out.println("Book with more price is "+morepricedbook);
		//sort all book by name 
		//reduce to reduce cost which is double
		//map books to double
		double totalprice=books.stream()
				.mapToDouble(x->x.getPrice())
				.reduce(0, (sum,y)->sum+y);
		System.out.println("Total Price is "+totalprice);
		//Print Distint Publishers
		books.stream()
				.distinct().forEach(x->System.out.println(x.getPublisher()));
		//to be Updated
		TreeSet<String> sortedstrings= new TreeSet<String>();
		sortedstrings.add("Kalluru");
		sortedstrings.add("Sravan");
		sortedstrings.add("Kumar");
		sortedstrings.add("Reddy");
		System.out.println("Sorted String : "+sortedstrings);
		TreeSet<Book> sortedbooks = new TreeSet<Book>();
		sortedbooks.add(new Book(1001,"Pride and Prejudice","whitehall",823,1,1813));
		sortedbooks.add(new Book(1002,"The great gatsby","printmedia",1000,1,1900));
		sortedbooks.add(new Book(1003,"To kill a mockingbird","Roll books",823,1,1913));
		sortedbooks.add(new Book(1004,"1984","Rupa Publication",823,1,1913));
		sortedbooks.add(new Book(1005,"Animal Farm","Apk Publishers",823,1,1927));
		sortedbooks.add(new Book(1006,"Anna Karenina","Agarwal Publishers",823,2,1923));
		System.out.println(books);
		//printing smallest in the greatest
		System.out.println(sortedbooks.ceiling(new Book(1003,"To kill a mockingbird","Roll books",823,1,1913)));
		System.out.println(sortedbooks.first());
		System.out.println(sortedbooks.last());
	}

}