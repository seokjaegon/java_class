package ch11_array.ex2;

public class Student {
    /**
     * 필드
     *  관리번호(id)
     *  이름(studentName)
     *  학번(studentNumber)
     *  학과(studentMajor)
     *  전화번호(studentMoblie)
     *
     *  getter/setter
     *
     *  생성자 2가지
     *
     *  toString
     */
    private Long id;
    private String studentName;
    private String studentNumber;
    private String studentMajor;
    private String studentMoblie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public String getStudentMoblie() {
        return studentMoblie;
    }

    public void setStudentMoblie(String studentMoblie) {
        this.studentMoblie = studentMoblie;
    }

    public Student() {

    }

    public Student(Long id, String studentName, String studentNumber, String studentMajor, String studentMoblie) {
        this.id = id;
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.studentMajor = studentMajor;
        this.studentMoblie = studentMoblie;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", studentMajor='" + studentMajor + '\'' +
                ", studentMoblie='" + studentMoblie + '\'' +
                '}';
    }
}
