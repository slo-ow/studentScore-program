package school.report;

import grade.BasicEvaluation;
import grade.GradeEvaluation;
import grade.MajorEvaluation;
import school.School;
import school.Score;
import school.Student;
import school.Subject;
import utils.Define;

import java.util.ArrayList;

public class GenerateGradeReport {
    School school = School.getInstance();
    public static final String TITLE = " 受講生 単位 \t\t\n";
    public static final String HEADER = " 名前  |  学番  |重点科目| 点数   \n";
    public static final String LINE = "-------------------------------------\n";
    private StringBuffer buffer = new StringBuffer();

    public String getReport(){
        ArrayList<Subject> subjectList = school.getSubjectList();  // 全ての科目に対した単位の算出
        for( Subject subject : subjectList) {
            makeHeader(subject);
            makeBody(subject);
            makeFooter();
        }
        return buffer.toString();  // String に返還
    }

    public void makeHeader(Subject subject){
        buffer.append(GenerateGradeReport.LINE);
        buffer.append("\t" + subject.getSubjectName());
        buffer.append(GenerateGradeReport.TITLE );
        buffer.append(GenerateGradeReport.HEADER );
        buffer.append(GenerateGradeReport.LINE);
    }

    public void makeBody(Subject subject){

        ArrayList<Student> studentList = subject.getStudentList();  // 各々の科目の学生達

        for(int i=0; i<studentList.size(); i++){
            Student student = studentList.get(i);
            buffer.append(student.getStudentName());
            buffer.append(" | ");
            buffer.append(student.getStudentId());
            buffer.append(" | ");
            buffer.append(student.getMajorSubject().getSubjectName() + "\t");
            buffer.append(" | ");

            getScoreGrade(student, subject.getSubjectId());  //学生達の該当科目の単位の計算
            buffer.append("\n");
            buffer.append(LINE);
        }
    }

    public void getScoreGrade(Student student, int subjectId){

        ArrayList<Score> scoreList = student.getScoreList();
        int majorId = student.getMajorSubject().getSubjectId();

        GradeEvaluation[] gradeEvaluation = {new BasicEvaluation(), new MajorEvaluation()};  //単位評価クレス達

        for(int i=0; i<scoreList.size(); i++){  // 学生が持ってる点数達

            Score score = scoreList.get(i);
            if(score.getSubject().getSubjectId() == subjectId) {  //　現在の単位を算出する科目
                String grade;
                if(score.getSubject().getSubjectId() == majorId)  // 重点科目の場合
                    grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());  //重点科目の単位の評価方法
                else
                    grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint()); // 重点科目ではない場合
                buffer.append(score.getPoint());
                buffer.append(":");
                buffer.append(grade);
                buffer.append(" | ");
            }
        }
    }

    public void makeFooter(){
        buffer.append("\n");
    }
}
