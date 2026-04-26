package ProjectMain;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
public class Teacher {

    private String teacherPassword;
    private String teacherNum;
    private String teacherName;
    private String teacherSurName;
    private String teacherMail;
    private String teacherField;
    private String teacherLessons;

    public Teacher(String teacherNum, String teacherPassword, String teacherName, String teacherSurName, String teacherMail, String teacherField, String teacherLessons) {
        setName(teacherName);
        setNum(teacherNum);
        setMail(teacherMail);
        setSurName(teacherSurName);
        setField(teacherField);
        setTeacherLessons(teacherLessons);

    }

    private String getName() {return this.teacherName;}
    private String getNum() {return this.teacherNum;}
    private String getSurName() {return this.teacherSurName;}
    private String getMail() {return this.teacherMail;}
    private String getTeacherField() {return this.teacherField;}
    private String getLessons() {return this.teacherLessons;}

    private void setName(String newName) {this.teacherName = newName;}
    private void setSurName(String newSurName) {this.teacherSurName = newSurName;}
    private void setNum(String newNum) {this.teacherNum = newNum;}
    private void setMail(String newMail) {this.teacherMail = newMail;}
    private void setField(String newField) {this.teacherField = newField;}
    private void setTeacherLessons(String newLessons){this.teacherLessons = newLessons;}

    public void menu() {
        String menuChose = " ";
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("Welcome to TEACHER MENU");
        System.out.println("-----------------------");
        while (true) {
            System.out.println("1-)EDIT-QUIZ\n2-)LESSONS\n3-)PROFİLE\n4-)EXIT");
            System.out.print("Your Chose: ");
            menuChose = input.nextLine();
            if (menuChose.equals("1"))
                editQuiz();
            else if (menuChose.equals("2"))
                showLessons();
            else if (menuChose.equals("3"))
                showProfile();
            else if (menuChose.equals("4")) {
                System.out.println("QUITING...");
                System.out.println("QUIT IS SUCCESSFULY COMPLETE!");
                System.exit(0);
            } else
                System.out.println("Invalid Choose!");
        }
    }

    public void editQuiz(){
        //burada ogretmenın verdiği dersler gozukecek
        Scanner input = new Scanner(System.in);
        try{
            //ogretmen dersi seçsin
            String[] lessons = this.getLessons().split("\\|");
            for(int i = 0; i < lessons.length; i++) {

                String[] lessonData = lessons[i].split(":");

                String lessonName = lessonData[0];

                System.out.println((i+1) + "- " + lessonName);
            }
            int lessonChoice = 0;
            System.out.println("Which one of you chose on lessons: ");
            lessonChoice = (Integer.parseInt(input.nextLine())-1);
            String selectedLesson = lessons[lessonChoice].split(":")[0];
            //dosyayı okuma ve ogrencı fıltrele
            BufferedReader reader = new BufferedReader(new FileReader("src/ProjectMain/txts/Students.txt"));
            String line;
            String[] matchedStudents = new String[100];
            int count = 0;
            System.out.println("\n--- Students with " + selectedLesson + " ---");

            while((line = reader.readLine()) != null){
                if (line.trim().isEmpty())
                    continue;
                String[] data = line.split(",");
                String studentLessons = data[8];

                if(studentLessons.contains(selectedLesson + ":")){

                    matchedStudents[count] = line;

                    System.out.println((count+1) + "- " + data[2] + " " + data[3]);

                    count++;
                }
            }
            System.out.print("Select student: ");
            int studentChoice = Integer.parseInt(input.nextLine()) - 1;

            String selectedStudent = matchedStudents[studentChoice];
            String[] studentData = selectedStudent.split(",");

            String[] lessonParts = studentData[8].split("\\|");

            String[] grades = null;
            int lessonIndex = -1;

            for(int i=0; i<lessonParts.length; i++){

                if(lessonParts[i].startsWith(selectedLesson + ":")) {

                    String[] temp = lessonParts[i].split(":");
                    grades = temp[1].split("-");
                    lessonIndex = i;
                    break;
                }
            }
            System.out.println("\n--- Grades ---");

            for(int i=0; i<grades.length; i++){
                System.out.println((i+1) + "- " + grades[i]);
            }

            System.out.print("Which quiz to change: ");
            int quizIndex = Integer.parseInt(input.nextLine()) - 1;

            System.out.print("New grade: ");
            String newGrade = input.nextLine();

            grades[quizIndex] = newGrade;

            String newGrades = String.join("-", grades);

            lessonParts[lessonIndex] = selectedLesson + ":" + newGrades;

            String newLessonData = String.join("|", lessonParts);
            studentData[8] = newLessonData;

            BufferedReader reader2 = new BufferedReader(new FileReader("src/ProjectMain/txts/Students.txt"));
            StringBuilder sb = new StringBuilder();

            while((line = reader2.readLine()) != null){

                String[] data = line.split(",");

                if(data[0].equals(studentData[0])){

                    sb.append(
                            String.join(",",
                                    studentData[0],
                                    studentData[1],
                                    studentData[2],
                                    studentData[3],
                                    studentData[4],
                                    studentData[5],
                                    studentData[6],
                                    studentData[7],
                                    studentData[8]
                            )
                    ).append("\n");

                } else {
                    sb.append(line).append("\n");
                }
            }
            reader2.close();

            FileWriter writer = new FileWriter("src/ProjectMain/txts/Students.txt");
            writer.write(sb.toString());
            writer.close();



        }
        catch (IOException e){
            System.out.println("Error reading file: " + e.getMessage());}
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
        System.out.println("Field: " + getTeacherField());
        System.out.println("----------------------------");
    }




}

