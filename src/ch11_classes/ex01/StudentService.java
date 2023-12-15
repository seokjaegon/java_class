package ch11_classes.ex01;

public class StudentService {
    StudentRepository studentRepository = new StudentRepository();
    /**
     * method name: method1
     * parameter: x
     * return: x
     */
    public void method1() {
        System.out.println("StudentService.method1");
        // Repository의 method1을 호출
        studentRepository.method1();
    }

    public void method2() {
        System.out.println("StudentService.method2");
        String str1 = "집에 가고 싶다.";
        studentRepository.method2(str1);
    }

    /**
     * StudentDTO 객체를 생성하고
     * Repository의 method3로 DTO 객체를 전달함.
     */
    public void method3() {
        System.out.println("StudentService.method3");
        StudentDTO studentDTO = new StudentDTO("학생3", "20233333", "서양미술", "010-3333-3333");
        boolean result = studentRepository.method3(studentDTO);
        System.out.println(result);
        if (result) {
            System.out.println("학생등록 성공");
        } else {
            System.out.println("학생등록 실패");
        }
    }
}
