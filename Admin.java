package ProjectMain;
import java.io.*;
import java.util.*;
public class Admin {


    private String adminPassword;
    private String adminNum;
    private String adminName;
    private String adminSurName;
    private String adminMail;
    private String adminField;

    public Admin(String adminNum,String adminPassword,String adminName,String adminSurName,String adminMail,String adminField){
        setName(adminName);
        setNum(adminNum);
        setMail(adminMail);
        setSurName(adminSurName);
        setField(adminField);
    }


    private String getName() {return this.adminName;}
    private String getNum() {return this.adminNum;}
    private String getSurName() {return this.adminSurName;}
    private String getMail() {return this.adminMail;}
    private String getField() {return this.adminField;}

    private void setName(String newName) {this.adminName = newName;}
    private void setSurName(String newSurName) {this.adminSurName = newSurName;}
    private void setNum(String newNum) {this.adminNum = newNum;}
    private void setMail(String newMail) {this.adminMail = newMail;}
    private void setField(String newField) {this.adminField = newField;}






    public void menu(){
        String menuChose = " ";
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("Welcome to ADMIN MENU");
        System.out.println("-----------------------");
        while (true) {
            System.out.println("1-)ADD/CHANGE-STUDENT\n2-)ADD/CHANGE-TEACHER\n3-)ADD/CHANGE-ADMIN\n4-)PROFILE\n5-)EXIT");
            System.out.print("Your Chose: ");
            menuChose = input.nextLine();
            if (menuChose.equals("1")) {
                String filePath = "src/ProjectMain/txts/Students.txt";
                System.out.println("1-)ADD\n2-)CHANGE\n3-)DELETE");
                String selected = input.nextLine();
                if(selected.equals("1")){
                    addStudent(filePath);
                    break;}

                else if(selected.equals("2")){
                    changeStudent(filePath);
                    break;}
                else if(selected.equals("3")){
                    deleteStudent(filePath);
                    break;}
            }
            else if (menuChose.equals("2")){
                String filePath = "src/ProjectMain/txts/Teachers.txt";
                System.out.println("1-)ADD\n2-)CHANGE\n3-)DELETE");
                String selected = input.nextLine();
                if(selected.equals("1"))
                    addTeacher(filePath);

                else if(selected.equals("2"))
                    changeTeacher(filePath);

                else if(selected.equals("3"))
                    deleteTeacher(filePath);

            }

            else if (menuChose.equals("3")){
                String filePath = "src/ProjectMain/txts/Admins.txt";
                System.out.println("1-)ADD\n2-)CHANGE\n3-)DELETE");
                String selected = input.nextLine();
                if(selected.equals("1"))
                    addAdmin(filePath);

                else if(selected.equals("2"))
                    changeAdmin(filePath);

                else if(selected.equals("3"))
                    deleteAdmin(filePath);

            }

            else if(menuChose.equals("4"))
                showProfile();
            else if (menuChose.equals("5")) {
                System.out.println("QUITING...");
                System.out.println("QUIT IS SUCCESSFULY COMPLETE!");
                System.exit(0);
            } else
                System.out.println("Invalid Choose!");
        }
    }


    public void addStudent(String filePath){
        Scanner input = new Scanner(System.in);
        System.out.print("NUM:");
        String num = input.nextLine();

        System.out.print("PASSWORD:");
        String password = input.nextLine();

        System.out.print("NAME:");
        String name = input.nextLine();

        System.out.print("SURNAME:");
        String surname = input.nextLine();

        System.out.print("MAİL:");
        String mail = input.nextLine();

        System.out.print("FİELD:");
        String field = input.nextLine();//hangi alansa o dersleri eklesin

        System.out.print("CLASS(1-2-3-4):");
        String clasS = input.nextLine();

        System.out.print("FİELD PART(A-B):");
        String fieldPart = input.nextLine();

        try {
            FileWriter fw = new FileWriter(filePath,true);
            fw.write(num+","+password+","+name+","+surname+","+mail+","+field+","+clasS+","+fieldPart);
            fw.close();
            System.out.println("Added Successfully!");
        }
        catch (Exception e){
            System.out.println("Error!");
        }
    }


    public void changeStudent(String filePath){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Num to Change: ");
        String target = input.nextLine();

        ArrayList<String> lines = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;

            while((line = br.readLine()) != null){

                String[] data = line.split(",");

                if(data[0].equals(target)){

                    System.out.print("New Password: ");
                    String pass = input.nextLine();

                    System.out.print("New Name: ");
                    String name = input.nextLine();

                    System.out.print("New Surname: ");
                    String surname = input.nextLine();

                    System.out.print("New Mail: ");
                    String mail = input.nextLine();

                    System.out.print("New Field: ");
                    String field = input.nextLine();

                    line = target + "," + pass + "," + name + "," + surname + "," + mail + "," + field;
                }

                lines.add(line);
            }

            br.close();

            FileWriter fw = new FileWriter(filePath,false);

            for(String l : lines){
                fw.write(l + "\n");
            }

            fw.close();

            System.out.println("Changed Successfully.");
        }
        catch(Exception e){
            System.out.println("Error!");
        }
    }


    public void deleteStudent(String filePath){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Num to Delete: ");
        String target = input.nextLine();

        ArrayList<String> lines = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;

            while((line = br.readLine()) != null){
                String[] data = line.split(",");

                if(!data[0].equals(target)){
                    lines.add(line);
                }
            }
            br.close();

            FileWriter fw = new FileWriter(filePath,false);

            for(String l : lines){
                fw.write(l + "\n");
            }

            fw.close();

            System.out.println("Deleted Successfully.");
        }
        catch(Exception e){
            System.out.println("Error!");
        }
    }


    public void addTeacher(String filePath){
        Scanner input = new Scanner(System.in);
        System.out.print("NUM:");
        String num = input.nextLine();

        System.out.print("PASSWORD:");
        String password = input.nextLine();

        System.out.print("NAME:");
        String name = input.nextLine();

        System.out.print("SURNAME:");
        String surname = input.nextLine();

        System.out.print("MAİL:");
        String mail = input.nextLine();

        System.out.print("FİELD:");
        String field = input.nextLine();

        String lessons = " ";
        while(true) {
            System.out.println("LESSONS(quit = -1)");
            String selected = " ";
            if(selected.equals("-1")){
                if(lessons.endsWith("|"))
                    lessons.substring(0);
                break;}
            else
                lessons = lessons + selected + "|";
        }
        try {
            FileWriter fw = new FileWriter(filePath,true);
            fw.write(num+","+password+","+name+","+surname+","+mail+","+field+",");
            fw.close();
            System.out.println("Added Successfully!");
        }
        catch (Exception e){
            System.out.println("Error!");
        }
    }


    public void changeTeacher(String filePath){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Num to Change: ");
        String target = input.nextLine();

        ArrayList<String> lines = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;

            while((line = br.readLine()) != null){

                String[] data = line.split(",");

                if(data[0].equals(target)){

                    System.out.print("New Password: ");
                    String pass = input.nextLine();

                    System.out.print("New Name: ");
                    String name = input.nextLine();

                    System.out.print("New Surname: ");
                    String surname = input.nextLine();

                    System.out.print("New Mail: ");
                    String mail = input.nextLine();

                    System.out.print("New Field: ");
                    String field = input.nextLine();

                    line = target + "," + pass + "," + name + "," + surname + "," + mail + "," + field;
                }

                lines.add(line);
            }

            br.close();

            FileWriter fw = new FileWriter(filePath,false);

            for(String l : lines){
                fw.write(l + "\n");
            }

            fw.close();

            System.out.println("Changed Successfully.");
        }
        catch(Exception e){
            System.out.println("Error!");
        }
    }


    public void deleteTeacher(String filePath){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Num to Delete: ");
        String target = input.nextLine();

        ArrayList<String> lines = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;

            while((line = br.readLine()) != null){
                String[] data = line.split(",");

                if(!data[0].equals(target)){
                    lines.add(line);
                }
            }
            br.close();

            FileWriter fw = new FileWriter(filePath,false);

            for(String l : lines){
                fw.write(l + "\n");
            }

            fw.close();

            System.out.println("Deleted Successfully.");
        }
        catch(Exception e){
            System.out.println("Error!");
        }
    }


    public void addAdmin(String filePath){
        Scanner input = new Scanner(System.in);
        System.out.print("NUM:");
        String num = input.nextLine();

        System.out.print("PASSWORD:");
        String password = input.nextLine();

        System.out.print("NAME:");
        String name = input.nextLine();

        System.out.print("SURNAME:");
        String surname = input.nextLine();

        System.out.print("MAİL:");
        String mail = input.nextLine();

        System.out.print("FİELD:");
        String field = input.nextLine();

        try {
            FileWriter fw = new FileWriter(filePath,true);
            fw.write(num+","+password+","+name+","+surname+","+mail+","+field);
            fw.close();
            System.out.println("Added Successfully!");
        }
        catch (Exception e){
            System.out.println("Error!");
        }
    }
    public void changeAdmin(String filePath){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Num to Change: ");
        String target = input.nextLine();

        ArrayList<String> lines = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;

            while((line = br.readLine()) != null){

                String[] data = line.split(",");

                if(data[0].equals(target)){

                    System.out.print("New Password: ");
                    String pass = input.nextLine();

                    System.out.print("New Name: ");
                    String name = input.nextLine();

                    System.out.print("New Surname: ");
                    String surname = input.nextLine();

                    System.out.print("New Mail: ");
                    String mail = input.nextLine();

                    System.out.print("New Field: ");
                    String field = input.nextLine();

                    line = target + "," + pass + "," + name + "," + surname + "," + mail + "," + field;
                }

                lines.add(line);
            }

            br.close();

            FileWriter fw = new FileWriter(filePath,false);

            for(String l : lines){
                fw.write(l + "\n");
            }

            fw.close();

            System.out.println("Changed Successfully.");
        }
        catch(Exception e){
            System.out.println("Error!");
        }
    }


    public void deleteAdmin(String filePath){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Num to Delete: ");
        String target = input.nextLine();

        ArrayList<String> lines = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;

            while((line = br.readLine()) != null){
                String[] data = line.split(",");

                if(!data[0].equals(target)){
                    lines.add(line);
                }
            }
            br.close();

            FileWriter fw = new FileWriter(filePath,false);

            for(String l : lines){
                fw.write(l + "\n");
            }

            fw.close();

            System.out.println("Deleted Successfully.");
        }
        catch(Exception e){
            System.out.println("Error!");
        }
    }















    public void showProfile(){
        System.out.println("----------------------------");
        System.out.println("Name: " + getName());
        System.out.println("SurName: " + getSurName());
        System.out.println("Student Num: " + getNum());
        System.out.println("Mail: " + getMail());
        System.out.println("Field: " + getField());
        System.out.println("----------------------------");
    }






}

