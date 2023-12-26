package ch13_map.ex02;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BookService {
    Scanner scanner = new Scanner(System.in);
    BookRepository bookRepository = new BookRepository();
    public void save() {
        System.out.print("도서명: ");
        String bookTitle = scanner.next();
        System.out.print("저자: ");
        String bookAuthor = scanner.next();
        System.out.print("가격: ");
        int bookPrice = scanner.nextInt();
        System.out.print("출판사: ");
        String bookPublisher = scanner.next();
        BookDTO bookDTO = new BookDTO(bookTitle, bookAuthor, bookPrice, bookPublisher);
        boolean result = bookRepository.save(bookDTO);
        if (result) {
            System.out.println("등록성공");
        } else {
            System.out.println("등록실패");
        }
    }

    public void findAll() {
        Map<Long, BookDTO> bookDTOMap = bookRepository.findAll();
        for (Long i: bookDTOMap.keySet()) {
            System.out.println(bookDTOMap.get(i));
            // 도서 제목만 본다면
            System.out.println(bookDTOMap.get(i).getBookTitle());
        }
    }

    public void findById() {
        System.out.print("조회할 id: ");
        Long id = scanner.nextLong();
        BookDTO bookDTO = bookRepository.findById(id);
        if (bookDTO != null) {
            System.out.println(bookDTO);
        } else {
            System.out.println("조회한 id에는 정보가 없음.");
        }
    }

    public void priceUpdate() {
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
}
