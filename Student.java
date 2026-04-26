package ProjectMain;

import java.util.Scanner;

public class Student {

    private String studentNum;
    private String studentName;
    private String studentSurName;
    private String studentMail;
    private String studentField;
    private String fieldPart;
    private String studentClass;
    private String lessons;

    public Student(String studentNum,String studentPassword,String studentName,String studentSurName,String studentMail,String studentField, String studentClass,String fieldPart,String lessons){
        setName(studentName);
        setNum(studentNum);
        setSurName(studentSurName);
        setMail(studentMail);
        setField(studentField);
        setFieldPart(fieldPart);
        setClass(studentClass);
        setLessons(lessons);
    }

    private String getName(){return this.studentName;}
    private String getNum(){return this.studentNum;}
    private String getSurName(){return this.studentSurName;}
    private String getMail(){return this.studentMail;}
    private String getStudentField(){return this.studentField;}
    private String getStudentClass(){return this.studentClass;}
    private String getFieldPart(){return this.fieldPart;}
    private String getLessons(){return this.lessons;}

    private void setName(String newName){this.studentName = newName;}
    private void setSurName(String newSurName){this.studentSurName = newSurName;}
    private void setNum(String newNum){this.studentNum = newNum;}
    private void setMail(String newMail){this.studentMail = newMail;}
    private void setField(String newField){this.studentField = newField;}
    private void setFieldPart(String newFieldPart){this.fieldPart = newFieldPart;}
    private void setLessons(String newLessons){this.lessons = newLessons;}
    private void setClass(String newClass){this.studentClass = newClass;}

    public void menu(){
        String menuChose = " ";
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("Welcome to STUDENT MENU");
        System.out.println("-----------------------");
        while(true){
            System.out.println("1-)QUIZ RESULTS\n2-)LESSONS\n3-)PROFİLE\n4-)EXIT");
            System.out.print("Your Chose: ");
            menuChose = input.nextLine();
            if(menuChose.equals("1"))
                showQuiz();
            else if(menuChose.equals("2"))
                showLessons();
            else if(menuChose.equals("3"))
                showProfile();
            else if(menuChose.equals("4")){
                System.out.println("QUITING...");
                System.out.println("QUIT IS SUCCESSFULY COMPLETE!");
                System.exit(0);
            }else
                System.out.println("Invalid Choose!");}
        }

    public void showQuiz(){
        String[] lessons = this.getLessons().split("\\|");
        System.out.println("------ LESSONS ------");
        for(int i = 0;i<lessons.length;i++){
            String[] lessonData = lessons[i].split(":");
            String lessonName = lessonData[0];
            String[] grades = lessonData[1].split("-");

            System.out.print((i+1) + "- " + lessonName + " -> ");

            for(int j=0; j<grades.length; j++) {
                System.out.print(grades[j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }

    public void showLessons(){
        String[] lessons = this.getLessons().split("\\|");

        System.out.println("------ LESSONS ------");

        for(int i = 0; i < lessons.length; i++) {

            String[] lessonData = lessons[i].split(":");

            String lessonName = lessonData[0];

            System.out.println((i+1) + "- " + lessonName);
        }
        System.out.println("----------------------------");
    }

    public void showProfile(){
        System.out.println("----------------------------");
        System.out.println("Name: " + getName());
        System.out.println("SurName: " + getSurName());
        System.out.println("Student Num: " + getNum());
        System.out.println("Mail: " + getMail());
        System.out.println("Field: " + getStudentField());
        System.out.println("Field Part: " + getFieldPart());
        System.out.println("Class Level: " + getStudentClass());
        System.out.println("----------------------------");
    }













}
