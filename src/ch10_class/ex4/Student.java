package ch10_class.ex4;

public class Student {
    //이름(studentName), 학번(studentNumber), 학과(studentMajor) 필드
    String studentName;
    String studentNumber;
    String studentMajor;

    // 기본생성자
    public Student() {

    }

    // 이름, 학번, 학과를 매개변수로 하는 생성자
    public Student(String studentName, String studentNumber, String studentMajor) {
//        System.out.println("studnetName = " + studnetName + ", studentNumber = " + studentNumber + ", studentMajor = " + studentMajor);
        // 잔달받은 매개변수 값을 필드에 담기
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.studentMajor = studentMajor;
    }

}
