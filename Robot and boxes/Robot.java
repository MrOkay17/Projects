import java.util.*;

/**
 * Robot
 */
public class Robot {
    
    private String name;
    private List<Box> transferlist;
    private Map<String, Integer> labelPriorities;

    public Robot(String name){
        this.name = name;
        this.transferlist = new ArrayList<>();
        this.labelPriorities = new HashMap<>();
    }

    public boolean addToTransferList(Box box) {
        try {
            transferlist.add(box);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

    public void printTransferList() {
        for (Box box : transferlist) {
            System.out.println(box.toString());
        }
        
    }

    public void moveForward(Box box, int steps) {
        for (int i = 0; i < steps; i++) {
            if (box.getPosition() < box.getDestination()) {
                box.forward();
            }
        }

        
    }

    public void setlabelPriority(String label, int priority) {
        if (!(label.equals(null))){
            labelPriorities.put(label, priority);
        }
        
    }


    public int getBoxPriority(String label) {
        if (labelPriorities.containsKey(label)) {
            return labelPriorities.get(label);
        } 
        else{
            throw new IllegalArgumentException("Invalid label!");
        }
        
    }

    public Box selectNextBox() {
        String output = "";
        int num = 0;
        int destination = 0;
        
        if (!transferlist.isEmpty()) {
         
            for (Box box : transferlist) {
                if (getBoxPriority(box.getLabel()) > num ) {
                    num = getBoxPriority(box.getLabel());
                    destination = box.getDestination();
                    output = box.getLabel();

                }
            }
            
            Box return_box = new Box(destination, output);

            for (Box box : transferlist) {
                if (output.equals(box.getLabel())) {
                    transferlist.remove(box);
                }
            
            }
            
            return return_box;
        } 
        else{
            return null;
        }
    

        
     }

    public void removeFromTransferlist(String labelRem) {
        for (Box box : transferlist) {
            if (box.getLabel().equals(labelRem)){
                transferlist.remove(box);
            }
            
        }
        
    }

    public static void main(String[] args) {
        Robot robot = new Robot("MrRobot");
        Box box1 = new Box(5, "Box1");
        Box box2 = new Box(5, "Box2");
        // robot.addToTransferList(box1);
        // robot.addToTransferList(box2);
        // robot.moveForward(box2, 3);
        
        robot.printTransferList();

        robot.setlabelPriority("Box1", 12);
        robot.setlabelPriority("Box2", 4);
        System.out.println();

        System.out.println(robot.selectNextBox()); 

        System.out.println();
        robot.printTransferList();

    }


    
}