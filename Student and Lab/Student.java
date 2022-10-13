/**
 * Student
 */
public class Student {

    private String name;
    private int age;

    public Student(String name){
        this.name = name;
        
    }

    public void setAge(int age) {
        this.age = age;
        
    }

    public int getAge() {
        return age;
    }

    public void signUp(Lab lab, Student student) {
        lab.register(student);
        
    }

    public void signOff(Lab lab, Student student) {
        lab.remove(student);
    }
    
}