import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Interface for book management
interface BookManagement {
    void addBook(Book book);
    void removeBook(String bookId);
    Book getBook(String bookId);
}

// Interface for member management
interface MemberManagement {
    void addMember(Member member);
    void removeMember(String memberId);
    Member getMember(String memberId);
}

// Interface for borrowing management
interface BorrowingManagement {
    void borrowBook(String memberId, String bookId);
    void returnBook(String memberId, String bookId);
}

// Book class
class Book {
    private String id;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}

// Member class
class Member {
    private String id;
    private String name;
    private List<String> borrowedBooks;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(String bookId) {
        borrowedBooks.add(bookId);
    }

    public void returnBook(String bookId) {
        borrowedBooks.remove(bookId);
    }
}

// Implementation of BookManagement
class BookManagementImpl implements BookManagement {
    private Map<String, Book> books = new HashMap<>();

    @Override
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    @Override
    public void removeBook(String bookId) {
        books.remove(bookId);
    }

    @Override
    public Book getBook(String bookId) {
        return books.get(bookId);
    }
}

// Implementation of MemberManagement
class MemberManagementImpl implements MemberManagement {
    private Map<String, Member> members = new HashMap<>();

    @Override
    public void addMember(Member member) {
        members.put(member.getId(), member);
    }

    @Override
    public void removeMember(String memberId) {
        members.remove(memberId);
    }

    @Override
    public Member getMember(String memberId) {
        return members.get(memberId);
    }
}

// Implementation of BorrowingManagement
class BorrowingManagementImpl implements BorrowingManagement {
    private BookManagement bookManagement;
    private MemberManagement memberManagement;

    public BorrowingManagementImpl(BookManagement bookManagement, MemberManagement memberManagement) {
        this.bookManagement = bookManagement;
        this.memberManagement = memberManagement;
    }

    @Override
    public void borrowBook(String memberId, String bookId) {
        Member member = memberManagement.getMember(memberId);
        Book book = bookManagement.getBook(bookId);

        if (member != null && book != null && !book.isBorrowed()) {
            member.borrowBook(bookId);
            book.setBorrowed(true);
        }
    }

    @Override
    public void returnBook(String memberId, String bookId) {
        Member member = memberManagement.getMember(memberId);
        Book book = bookManagement.getBook(bookId);

        if (member != null && book != null && book.isBorrowed()) {
            member.returnBook(bookId);
            book.setBorrowed(false);
        }
    }
}

// Main class to demonstrate the Library Management System
public class LibraryManagementSystem {
    public static void main(String[] args) {
        BookManagement bookManagement = new BookManagementImpl();
        MemberManagement memberManagement = new MemberManagementImpl();
        BorrowingManagement borrowingManagement = new BorrowingManagementImpl(bookManagement, memberManagement);

        Book book1 = new Book("B001", "1984", "George Orwell");
        Book book2 = new Book("B002", "To Kill a Mockingbird", "Harper Lee");

        Member member1 = new Member("M001", "Alice");
        Member member2 = new Member("M002", "Bob");

        bookManagement.addBook(book1);
        bookManagement.addBook(book2);

        memberManagement.addMember(member1);
        memberManagement.addMember(member2);

        borrowingManagement.borrowBook("M001", "B001");
        System.out.println("Alice's Borrowed Books: " + member1.getBorrowedBooks());
        System.out.println("Is '1984' Borrowed: " + book1.isBorrowed());

        borrowingManagement.returnBook("M001", "B001");
        System.out.println("Alice's Borrowed Books after returning: " + member1.getBorrowedBooks());
        System.out.println("Is '1984' Borrowed after returning: " + book1.isBorrowed());
    }
}
