package school;

import java.util.ArrayList;

public class School {
    private static School instance = new School();

    private static String SCHOOL_NAME = "Good School";
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Subject> subjectList = new ArrayList<>();

    private School(){}

    public static School getInstance(){
        if(instance == null)
            instance = new School();
        return instance;
    }

    public static void setInstance(School instance) {School.instance = instance;}

    public static String getSchoolName() {return SCHOOL_NAME;}

    public static void setSchoolName(String schoolName) {SCHOOL_NAME = schoolName;}

    public ArrayList<Student> getStudentList() {return studentList;}

    public void setStudentList(ArrayList<Student> studentList) {this.studentList = studentList;}

    public ArrayList<Subject> getSubjectList() {return subjectList;}

    public void setSubjectList(ArrayList<Subject> subjectList) {this.subjectList = subjectList;}
}