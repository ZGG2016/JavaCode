public class Student {
    private Student(){}

    private static Student s = null;

    public synchronized static  Student getStudent(){
        if(s==null){
            return new Student();
        }
        return s;
    }
}
