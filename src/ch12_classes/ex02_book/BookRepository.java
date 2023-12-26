package ch12_classes.ex02_book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    BookDTO bookId = null ;
    // 도서 정보를 관리하는 bookDTOList
    private static List<BookDTO> bookDTOList = new ArrayList<>();
    /**
     * 도서등록 메서드
     * name: save
     * parameter: BookDTO
     * return: boolean
     * 실행내용
     *      Service로 부터 전달 받은 DTO 객체를 리스트에 저장하고 결과를 리턴
     */
    public boolean save(BookDTO bookDTO) {
        boolean result = bookDTOList.add(bookDTO);
        return result;
    }

    /**
     * 도서목록 메서드
     * name: findAll
     * parameter: x
     * return: List<BookDTO>
     * 실행내용
     *      Service로 부터 호출되면 리스트를 리턴
     */
    public List<BookDTO> findAll() {
        List<BookDTO> result = bookDTOList;
        return result;
    }

    /**
     * 도서조회 메서드
     * name: findById
     * parameter: Long
     * return: BookDTO
     * 실행내용
     *      Service로 부터 id를 전달받고 일치하는 결과를 찾아서 DTO를 리턴
     *      없으면 null 리턴
     */
    public BookDTO findById(Long id) {
        BookDTO result = null;
        for (int i = 0; i < bookDTOList.size(); i++) {
            if(id.equals(bookDTOList.get(i).getId())) {
                result = bookDTOList.get(i);
            }
        }
        return result;
    }

    /**
     * 도서조회 메서드
     * name: findByTitle
     * parameter: String
     * return: BookDTO
     * 실행내용
     *      Service로 부터 도서제목을 전달받고 일치하는 결과를 찾아서 DTO를 리턴
     *      없으면 null 리턴
     */
    public BookDTO findByTitle(String bookTitle) {
        BookDTO result = null;
        for (int i = 0; i < bookDTOList.size(); i++) {
            if (bookTitle.equals(bookDTOList.get(i).getBookTitle())) {
                result = bookDTOList.get(i);
            }
        }
        return result;
    }

    public boolean priceUpdate (Long id, int bookPrice) {
        boolean result = false;
        for (int i = 0; i < bookDTOList.size(); i++) {
            if (id.equals(bookDTOList.get(i).getId())) {
                bookDTOList.get(i).setBookPrice(bookPrice);
                result = true;
            }
        }
        return result;
    }

    public boolean bookDelete(Long id2) {
        boolean result = false;
        for (int i = 0; i < bookDTOList.size(); i++) {
            if(id2.equals(bookDTOList.get(i).getId())) {
                bookDTOList.remove(i);
                result = true;
            }
        }
        return result;
        // 리턴을 리스트로 받아 재곤!!와라라라라랄 ㅇㅁㅇ !!
        // 꽈라라라라라랄라라라라라라라 ㅍㅂㅍ!
    }

    public List<BookDTO> search(String bookTitle) {
        // 검색결과를 담은 List 선언
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (int i = 0; i < bookDTOList.size(); i++) {
            // 저장되어 있는 도서명에 검색어가 포함되어 있으면 true
            if(bookDTOList.get(i).getBookTitle().contains(bookTitle)){
                // 조건을 만족하면 bookDTOS 에 추가
                //BookDTO bookDTO = bookDTOList.get(i);
                //bookDTOS.add(bookDTO);
                bookDTOS.add(bookDTOList.get(i));
            }
        }
        return bookDTOS;
    }
}
