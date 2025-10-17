public class Student {
    private final String name;
    private final int age;
    private final String studentID;

    public Student(String name, int age, String studentID) {
        this.name = name;
        this.age = age;
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getStudentID(){
        return studentID;
    }
}
