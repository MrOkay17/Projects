import java.util.*;


/**
 * Lab
 */
public class Lab {

    private String name;
    private int capacity;
    private List<Student> students;
    private Set<String> availableEquipment;
    private Map<Student, Set<String>> studentEquipment;

    public Lab(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.students = new ArrayList<>();
        this.availableEquipment = new HashSet<>();
        this.studentEquipment = new HashMap<>();
    }

    public boolean register(Student student) {
        if (students.size() < capacity && !students.contains(student)) {
            students.add(student);
            return true;
        }
        return false;
        
    }

    public boolean remove(Student student){
        if (students.contains(student)) {
            students.remove(student);
            return true;
        }
        return false;
    }

    public void addEquipment(){
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();

        for (int i = 0; i < amount; i++) {
            availableEquipment.add(sc.nextLine());
        }
        sc.close();
    }

    public boolean bookEquipment(Student student, String equipmentName){
        if (availableEquipment.contains(equipmentName)) {
            studentEquipment.get(student).add(equipmentName);
            availableEquipment.remove(equipmentName);
            return true;
        }
        else {
            throw new IllegalArgumentException("Equipment not available!");

        }
    }

    public void returnEquipment(Student student) {
        for (String equipment : studentEquipment.get(student)) {
            studentEquipment.get(student).remove(equipment);
            availableEquipment.add(equipment);
        }
        
    }


}