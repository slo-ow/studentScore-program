package school;

import utils.Define;

import java.util.ArrayList;

public class Subject {
    private String subjectName; //科目名
    private int subjectId;      //科目固有番号
    private int gradType;       //関目評価の方法、基本はA,B方法

    //受講申請した覚醒のリスト
    //register()関数呼ぶとリストに追加される
    private ArrayList<Student> studentList = new ArrayList<>();

    public Subject(String subjectName, int subjectId) {
        this.subjectName = subjectName;
        this.subjectId = subjectId;
        this.gradType = Define.AB_TYPE; //基本的にA, Bタイプ
    }

    public String getSubjectName() {return subjectName;}

    public void setSubjectName(String subjectName) {this.subjectName = subjectName;}

    public int getSubjectId() {return subjectId;}

    public void setSubjectId(int subjectId) {this.subjectId = subjectId;}

    public int getGradType() {return gradType;}

    public void setGradType(int gradType) {this.gradType = gradType;}

    public ArrayList<Student> getStudentList() {return studentList;}

    public void setStudentList(ArrayList<Student> studentList) {this.studentList = studentList;}

    public void register(Student student) { studentList.add(student);}
}
