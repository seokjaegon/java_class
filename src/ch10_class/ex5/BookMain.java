package ch10_class.ex5;

public class BookMain {
    public static void main(String[] args) {
        // 책 정보는 시중에 있는 실제 책으로 해봅시다.

        // 기본생성자로 객체 만들고 필드값 채우기
        Book book1 = new Book();
        book1.bookTitle = "더 마인드";
        book1.bookAuthor = "하와이 대저택";
        book1.bookPublisher = "지식하우스";
        book1.isbn = "1290";
        book1.bookPrice = 17820;
        // 매개변수 2개 있는 생성자를 객체 만들고 필드값 채우기
        Book book2 = new Book("마흔에 읽은 쇼펜하우어","강용수");
        book2.bookPublisher = "유노북스";
        book2.isbn = "12345678";
        book2.bookPrice = 15300;
        // 모든 매개변수 있는 생성자로 객체 만들고 필드값 채우기
        Book book3 = new Book("트렌드 코리아 2024","김난도","미래의 창","5678",17100);
    }
}
