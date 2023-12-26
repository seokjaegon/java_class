package ch12_classes.ex02_book;

import java.util.List;
import java.util.Scanner;

public class BookService {
    BookDTO bookDTO = null;
    BookRepository bookRepository = new BookRepository();
    Scanner scanner = new Scanner(System.in);
    /**
     * 도서등록 메서드
     * name: save
     * parameter: x
     * return: x
     * 실행내용
     *      스캐너로 도서명, 저자, 가격, 출판사정보를 입력받고
     *      BookDTO 객체에 담아서 Repository로 전달하여 저장이 되도록 함
     *      등록 여부를 출력한다.(등록성공 or 등록실패)
     */
    public void save() {
        System.out.print("도서명: ");
        String bookTitle = scanner.next();
        System.out.print("저자: ");
        String bookAuthor = scanner.next();
        System.out.print("가격: ");
        int bookPrice = scanner.nextInt();
        System.out.print("출판사: ");
        String bookPublisher = scanner.next();
        bookDTO = new BookDTO(bookTitle, bookAuthor, bookPrice, bookPublisher);
        boolean result = bookRepository.save(bookDTO);
        if (result) {
            System.out.println("등록성공");
        } else {
            System.out.println("등록실패");
        }
    }

    /**
     * 도서목록 메서드
     * name: findAll
     * parameter: x
     * return: x
     * 실행내용
     *      Repository로 부터 목록을 리턴 받아서 목록에 있는 모든 정보를 출력
     */
    public void findAll() {
        List<BookDTO> bookDTOList = bookRepository.findAll();
        for (BookDTO bookList: bookDTOList) {
            System.out.println(bookList);
        }
    }

    /**
     * 도서조회 메서드
     * name: findById
     * parameter: x
     * return: x
     * 실행내용
     *      id를 입력받고 Repository로 부터 id에 해당 하는 도서 정보를 출력
     *      없으면 없다고 출력
     */
    public void findById() {
        System.out.print("조회할 id: ");
        Long id = scanner.nextLong();
        BookDTO result = bookRepository.findById(id);
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("조회한 id에는 정보가 없음.");
        }
    }

    /**
     * 도서조회 메서드
     * name: findByTitle
     * parameter: x
     * return: x
     * 실행내용
     *      도서제목을 입력받고 Repository로 부터 해당 하는 도서 정보를 출력(제목이 정확히 일치하는 것만)
     *      없으면 없다고 출력
     */
    public void findByTitle() {
        System.out.print("조회할 책제목: ");
        String bookTitle = scanner.next();
        BookDTO result = bookRepository.findByTitle(bookTitle);
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("조회한 책제목은 없음.");
        }
    }
    public void search() {
        System.out.print("검색어: ");
        String bookTitle = scanner.next();
        List<BookDTO> bookDTOList = bookRepository.search(bookTitle);
        if (bookDTOList.size() > 0) {
            for (BookDTO bookDTO : bookDTOList) {
                System.out.println(bookDTO);
            }
        }else {
            // bookDTOList.size() == 0 => 결과가 없다.
            System.out.println("검색 결과가 없습니다!");
        }

    }

    public void priceUpdate() {
        // 수정할 id를 입력받음
        // 해당 id 도서가 있다면 수정할 가격을 입력받고 수정 처리
        // 없으면 없다고 출력
        System.out.print("수정할 id: ");
        Long id = scanner.nextLong();
        BookDTO result = bookRepository.findById(id);
        if (result != null) {
            System.out.println("수정할 가격: ");
            int bookPrice = scanner.nextInt();
            boolean updateResult = bookRepository.priceUpdate(id, bookPrice);
            if (updateResult) {
                System.out.println("수정 성공");
            } else {
                System.out.println("수정 실패");
            }
        } else {
            System.out.println("수정할 id가 없음");
        }
    }

    public void bookDelete() {
        System.out.print("삭제할 책id: ");
        Long id2 = scanner.nextLong();
        boolean result = bookRepository.bookDelete(id2);
        if (result) {
            System.out.println("삭제 성공");
        } else {
            System.out.println("삭제 실패");
        }
    }

}
