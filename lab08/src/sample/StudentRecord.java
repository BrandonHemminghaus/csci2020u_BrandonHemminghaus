package sample;

public class StudentRecord {
    private String SI;
    private float Assignments;
    private float Midterms;
    private float FinalExam;
    private double FinalMark;
    private String LetterGrade;

    public StudentRecord(String SI, float Assignments, float Midterms, float FinalExam) {
        this.SI = SI;
        this.Assignments = Assignments;
        this.Midterms = Midterms;
        this.FinalExam = FinalExam;
        FinalMark = Assignments * 0.2 + Midterms * 0.3 + FinalExam * 0.5;
        if (FinalMark >= 0 && FinalMark <= 49) {
            LetterGrade = "F";
        }
        else if (FinalMark >= 50 && FinalMark <= 59) {
            LetterGrade = "D";
        }
        else if (FinalMark >= 60 && FinalMark <= 69) {
            LetterGrade = "C";
        }
        else if (FinalMark >= 70 && FinalMark <= 79) {
            LetterGrade = "B";
        }
        else if (FinalMark >= 80 && FinalMark <= 100) {
            LetterGrade = "A";
        }
        else{
            LetterGrade = "Not a possible mark to get";
        }
    }

    //get and set functions
    public String getSI(){
        return SI;
    }
    public void setSI(String SI) {
        this.SI = SI;
    }

    public float getAssignments() {
        return Assignments;
    }
    public void setAssignments(float Assignments) {
        this.Assignments = Assignments;
    }

    public float getMidterms() {
        return Midterms;
    }
    public void setMidterms(float Midterms) {
        this.Midterms = Midterms;
    }

    public float getFinalExam() {
        return FinalExam;
    }
    public void setFinalExam(float FinalExam) {
        this.FinalExam = FinalExam;
    }

    public double getFinalMark() {
        return FinalMark;
    }
    public void setFinalMark(double FinalMark) {
        this.FinalMark = FinalMark;
    }

    public String getLetterGrade() {
        return LetterGrade;
    }
    public void setLetterGrade(String LetterGrade) {
        this.LetterGrade = LetterGrade;
    }
}
