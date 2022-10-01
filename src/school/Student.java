package school;

import java.util.ArrayList;

public class Student {
    private int studentId; //各番
    private String studentName; //名前
    private Subject majorSubject; //専攻科目

    //学生の成績リスト
    //addSubjectScore()　関数が呼ばれるとリストに追加される。
    private ArrayList<Score> scoreList = new ArrayList<>();
    public Student(int studentId, String studentName, Subject majorSubject) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.majorSubject = majorSubject;
    }

    public void addSubjectScore(Score score){
        scoreList.add(score);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Subject getMajorSubject() {
        return majorSubject;
    }

    public void setMajorSubject(Subject majorSubject) {
        this.majorSubject = majorSubject;
    }

    public ArrayList<Score> getScoreList(){
        return scoreList;
    }

    public void setScoreList(ArrayList<Score> scoreList) {
        this.scoreList = scoreList;
    }
}
