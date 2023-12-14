package ch11_classes.ex01;

public class StudentDTO {
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

    public StudentDTO() {

    }

    private static Long idValue = 1L;

    public StudentDTO(String studentName, String studentNumber, String studentMajor, String studentMoblie) {
        this.id = idValue++;
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.studentMajor = studentMajor;
        this.studentMoblie = studentMoblie;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", studentMajor='" + studentMajor + '\'' +
                ", studentMoblie='" + studentMoblie + '\'' +
                '}';
    }
}
