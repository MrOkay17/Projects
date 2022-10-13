public class GradStudent extends Student {

    private int num;

    public GradStudent(String name) {
        super(name);
        this.num = 0;
    }
    
    @Override
    public void signUp(Lab lab, Student student){
        if (num < 3 ) {
            super.signUp(lab, student);
            num++;
        }
        
    
    }

    @Override
    public void signOff(Lab lab, Student student){
        if (num > 0) {
            super.signOff(lab, student);
            num--;   
        }
    
    }
}