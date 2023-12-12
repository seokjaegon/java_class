package ch10_class.ex5;

public class Book {
    /**
     * 제목(bookTitle)
     * 저자(bookAuthor)
     * 출판사(bookPublisher)
     * isbn(isbn)
     * 가격(boookPrice)
     */

    String bookTitle;
    String bookAuthor;
    String bookPublisher;
    String isbn;
    int bookPrice;
    // 기본 생성자
    public Book() {
        System.out.println();
    }
    // 제목, 저자를 매개변수로 하는 생성자(매개변수 값을 필드에 담아야함)
    public Book(String bookTitle, String bookAuthor) {
//        System.out.println("bookTitle = " + bookTitle);
//        System.out.println("bookAuthor = " + bookAuthor);
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }
    // 모든 필드값을 매개변수로 하는 생성자(매개변수 값을 필드에 담아야함)
    public Book(String bookTitle, String bookAuthor, String bookPublisher, String isbn, int bookPrice){
//        System.out.println("bookTitle = " + bookTitle);
//        System.out.println("bookAuthor = " + bookAuthor);
//        System.out.println("bookPublisher = " + bookPublisher);
//        System.out.println("isbn = " + isbn);
//        System.out.println("bookPrice = " + bookPrice);
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.isbn = isbn;
        this.bookPrice = bookPrice;
    }
}
