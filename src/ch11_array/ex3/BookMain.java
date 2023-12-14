package ch11_array.ex3;

import java.util.ArrayList;
import java.util.List;

public class BookMain {
    public static void main(String[] args) {
        // Book 객체를 담기 위한 bookList 객체 선언
        List<Book> bookList = new ArrayList<>();

        // 기본생성자로 Book 객체(book1) 생성 후 bookList에 추가
        Book book1 = new Book();
        book1.setId(1L);
        book1.setBookTitle("퓨처셀프");
        book1.setBookAuthor("벤자민 하디");
        book1.setBookPrice(17820);
        book1.setBookPublisher("상상스웨어");
        bookList.add(book1);

        // 매개변수 생성자로 Book 객체(book2) 생성 후 bookList에 추가
        Book book2 = new Book(2L, "마흔에 읽은 쇼펜하우어", "강용수", 15300, "유노북스");
        bookList.add(book2);

        // for를 이용하여 bookList의 전체 데이터 출력
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println("bookList["+i+"] = " + bookList.get(i));
        }
        System.out.println();

        // for each를 이용하여 bookList의 전체 데이터 출력
        for (Book book: bookList) {
            System.out.println("bookList = " + book);
        }
        System.out.println();

        // list의 0번 인덱스에 담긴 책의 가격을 50000으로 변경
        bookList.get(0).setBookPrice(50000);

        // list의 1번 인덱스에 담긴 출판사의 제목을 "안녕출판사"로 번경
        bookList.get(1).setBookPublisher("안녕출판사");

        // for를 이용하여 bookList의 전체 데이터 출력
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println("bookList["+i+"] = " + bookList.get(i));
        }
        System.out.println();

        // for each를 이용하여 bookList의 전체 데이터 출력
        for (Book book: bookList) {
            System.out.println("book = " + book);
        }
    }
}
