/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.brewingUniversityModel;

import info5100.university.brewingUniversityModel.CourseCatalog.Course;
import info5100.university.brewingUniversityModel.CourseSchedule.CourseLoad;
import info5100.university.brewingUniversityModel.CourseSchedule.CourseOffer;
import info5100.university.brewingUniversityModel.CourseSchedule.CourseSchedule;
import info5100.university.brewingUniversityModel.Department.Department;
import info5100.university.brewingUniversityModel.Persona.Person;
import info5100.university.brewingUniversityModel.Persona.PersonDirectory;
import info5100.university.brewingUniversityModel.Persona.StudentDirectory;
import info5100.university.brewingUniversityModel.Persona.StudentProfile;
import info5100.university.brewingUniversityModel.Placement.PlacementHistory;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kal bugrara
 */
public class brewingUniversityModel {

    private static ArrayList<Department> departmentDirectory = new ArrayList<Department>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //what all the things are in depart and college lvl?
        // I am able to create multiple departments , this makes one college
        // should be able to create multiple colleges and display, this makes university model
        //let go into sub details
        
        //in department, degree should be defined
        //degree is connected with completing all credits and covering all courses(core and elective)
        
        //create UI
        
        departmentDirectory.add(new Department("Information Systems"));
        
        Department department = getDepartmentFromDirectory("Information Systems");
        
//        Department department = new Department("Information Systems");

        Course course = department.newCourse("app eng", "info 5100", 4);

        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");

        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        
        PlacementHistory placementHistory = department.getPlacementHistory();
        
        courseoffer.generatSeats(10);
        
        PersonDirectory pd = department.getPersonDirectory();
        Person person = pd.newPerson("0112303");
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile student = sd.newStudentProfile(person);
        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
//        
        courseload.newSeatAssignment(courseoffer); //register student in class
        
        int total = department.calculateRevenuesBySemester("Fall2020");
        System.out.print("Total: " + total);
        
        
        while(showMainMenu());
        

    }
    
    private static Department getDepartmentFromDirectory(String department) {
        for(Department d: departmentDirectory) {
            if(d.getName().equals(department))
                return d;
        }
        return null;
    }

    private static Boolean showMainMenu() {
        int choice = 0;
        Boolean isError = false;
        System.out.println("Choose one option from below:\n");
        Boolean isValidChoice = false;
        
        while(!isValidChoice) {
            System.out.println(" 1. Show Departments");
            System.out.println(" 2. Show Courses");
            System.out.println(" 3. Show Placements");
            System.out.println(" 4. Show Student Performance provided by Employers");
            System.out.println(" 5. Show quality of Employers students are working for");
            System.out.println("99. Exit");

            Scanner scanner;
        
            while(!isError) {
                try {
                    scanner = new Scanner(System.in);
                    choice = scanner.nextInt();
                    isError = false;
                }
                catch (Exception e) {
                    isError = true;
                    System.out.println("\nGive Correct Input\n");
                }
            }

            switch(choice) {
                case 1:
                    isValidChoice = true;
                    showDepartmentsMenu(null);
                    break;

                case 2:
                    isValidChoice = true;
                    showCoursesMenu(null);
                    break;

                case 3:
                    isValidChoice = true;
                    showPlacementsMenu(null);
                    break;

                case 4:
                    isValidChoice = true;
                    showStudentPerformance(null);
                    break;

                case 5:
                    isValidChoice = true;
                    showEmployerQuality(null);
                    break;

                case 99:
                    isValidChoice = true;
                    System.out.println("Thanks for using my app..\nExiting...");
                    return false;
                
                default:
//                    isValidChoice = false;
                    System.out.println("Please choose one option from the below:\n");
                    break;
            }
        }
        return true;
    }

    private static int getYesOrNo(String question){
        System.out.println(question);
        System.out.println("\t1. Yes");
        System.out.println("\t2. No");
        int choice = new Scanner(System.in).nextInt();
        if(choice != 1 || choice != 2){
            System.out.println("\nChoose correct option...");
            choice = getYesOrNo(question);
        }
        return choice;
    }
    
    private static void showDepartmentsMenu(String department) {

        Department d = null;
        Boolean isValidChoice = false;
        
        if(departmentDirectory.isEmpty()) {
            System.out.println("There are no departments created yet.");
            if(department != null) {
                switch(getYesOrNo("Do you want to create " + department + " department?")) {
                    case 1:
                        d = new Department(department);
                        departmentDirectory.add(d);
                        System.out.println("Department " + department + " is created successfully..");
                        break;
                    case 2:
                        return;
                }
            }
            else 
                return;
        }
        
        if(department == null) {
            while(!isValidChoice) {
                try {
                    int choice;
                    chooseOption("department");
                    listDepartments();
                    choice = new Scanner(System.in).nextInt();
                    d = departmentDirectory.get(choice - 1);
                    isValidChoice = true;
                }
                catch(Exception e) {
                    System.out.println("Please choose a valid option.");
                }
            }
        }
        else {
            d = getDepartmentFromDirectory(department);
        }
        
        System.out.println("Choosen department is: " + d.getName());
        isValidChoice = false;
        chooseOption(null);
        
        while(!isValidChoice) {
            try {
//                int choice;
                System.out.println(" 1. Show Courses");
                System.out.println(" 2. Show Placements");
                System.out.println(" 3. Show Student Performance provided by Employers");
                System.out.println(" 4. Show quality of Employers students are working for");
                
                switch(new Scanner(System.in).nextInt()) {
                    case 1:
                        isValidChoice = true;
                        showCoursesMenu(d.getName());
                        break;
                    case 2:
                        isValidChoice = true;
                        showPlacementsMenu(d.getName());
                        break;
                    case 3:
                        isValidChoice = true;
                        showStudentPerformance(d.getName());
                        break;
                    case 4:
                        isValidChoice = true;
                        showEmployerQuality(d.getName());
                        break;
                    default:
                        System.out.println("Please choose a valid option.");
                        break;
                }
            }
            catch(Exception e) {
                System.out.println("Please choose a valid option.");
            }
        }
        //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void chooseOption(String s) {
        if(s == null)
            System.out.println("Choose an option from below: ");
        else
            System.out.println("Choose one " + s + " from below: ");
    }

    private static void showCoursesMenu(String department) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void showPlacementsMenu(String department) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void showStudentPerformance(String department) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void showEmployerQuality(String department) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void listDepartments() {
        int i = 0;
        for(Department d: departmentDirectory) {
            i++;
            System.out.println(i + " " + d.getName());
        }
    }

}
