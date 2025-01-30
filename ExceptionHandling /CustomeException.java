//program to create custome Exception in java 

class SemesterException extends Exception{
    public SemesterException ( String msg){
        super(msg);
    }
}


class Student{
    String name ;
    int sem;

    public Student(String name, int sem) throws SemesterException{
        if(sem>8|| sem<1){
            throw new SemesterException("invalid sem !! \n please enter correct sem");
        }
         this.name= name;
         this.sem= sem;
    }
}

class CustomeException{
    public static void main ( String [] args){
        try{
            Student s = new Student( " Ramesh ", -2);

        }catch(SemesterException e){
        System.out.println(e.getMessage());

        }
    }
}