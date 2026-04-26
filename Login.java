package ProjectMain;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
public class Login {

    public  void mainMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------");
        System.out.println("Welcome to Univercity INFORMATION SYSTEM");
        System.out.println("----------------------------------------");


        String role = " ";
        System.out.println("Welcome To Login Screen");

        while(true) {
            role = " ";
            System.out.println("1-)Student ");
            System.out.println("2-)Teacher ");
            System.out.println("3-)Admin ");
            System.out.print("What's Your Role(): ");
            role = input.nextLine();
            String fileName = " ";
            if(role.equals("1")){
                fileName = "src/ProjectMain/txts/Students.txt";
                loginProccess(fileName);
                break;}
            else if(role.equals("2")){
                fileName = "src/ProjectMain/txts/Teachers.txt";
                loginProccess(fileName);
                break;}
            else if(role.equals("3")){
                fileName = "src/ProjectMain/txts/Admins.txt";
                loginProccess(fileName);
                break;}
            else{
                System.out.println("Invalid Role!");
                System.exit(0);}
        }
    }

    public void loginProccess(String fileName){
        Scanner input = new Scanner(System.in);
        String num = " ";
        String password = " ";

        System.out.print("* User Num: ");
        num = input.nextLine();
        System.out.print("* User Password: ");
        password = input.nextLine();

        boolean isSuccess = false;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line = " ";
            while((line = reader.readLine()) != null){
                String[] data = line.split(",");//veri ayırma
                if(data[0].trim().equals(num.trim()) &&
                        data[1].trim().equals(password.trim())) {
                    isSuccess = true;
                    System.out.println("Login Successful! Welcome, " + data[2]);
                    if (fileName.equals("src/ProjectMain/txts/Students.txt")) {
                        Student currentStudent = new Student(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]);
                        currentStudent.menu();
                    }
                    else if (fileName.equals("src/ProjectMain/txts/Teachers.txt")) {
                        Teacher currentTeacher = new Teacher(data[0],data[1],data[2],data[3],data[4],data[5],data[6]);
                        currentTeacher.menu();
                    }
                    else if (fileName.equals("src/ProjectMain/txts/Admins.txt")) {
                        Admin currentAdmin = new Admin(data[0],data[1],data[2],data[3],data[4],data[5]);
                        currentAdmin.menu();
                    }
                    break;
                }
            }
        }
        catch (IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
        if(!isSuccess)
            System.out.println("Invalid NUM or PASSWORD!");
    }




    public void signProccess(){

        System.out.println("Welcome To Signup Screen");
        System.out.println("User Name: ");
        System.out.println("User Surname: ");
        System.out.println("User Mail: ");
        System.out.println("User Num: ");
        System.out.println("User Password: ");
        System.out.println("User : ");
    }







}
