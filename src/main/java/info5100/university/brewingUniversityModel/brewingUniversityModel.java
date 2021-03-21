/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.brewingUniversityModel;

import com.github.javafaker.Faker;
import info5100.university.brewingUniversityModel.CourseCatalog.Course;
import info5100.university.brewingUniversityModel.CourseSchedule.CourseLoad;
import info5100.university.brewingUniversityModel.CourseSchedule.CourseOffer;
import info5100.university.brewingUniversityModel.CourseSchedule.CourseSchedule;
import info5100.university.brewingUniversityModel.Department.Department;
import info5100.university.brewingUniversityModel.Employer.EmployerDirectory;
import info5100.university.brewingUniversityModel.Employer.EmployerProfile;
import info5100.university.brewingUniversityModel.Persona.EmploymentHistory.Employment;
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
        
        Faker faker = new Faker();
        
        departmentDirectory.add(new Department("Information Systems"));
        
        Department department = getDepartmentFromDirectory("Information Systems");
        
//        Department department = new Department("Information Systems");

        Course course = department.newCourse("app eng", "info 5100", 4);

        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");

        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        
        PlacementHistory placementHistory = department.getPlacementHistory();
        
        courseoffer.generatSeats(10);
        
        EmployerDirectory employerDirectory = new EmployerDirectory(department);
        
        PersonDirectory pd = department.getPersonDirectory();
        Person person = pd.newPerson("0112303");
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile student = sd.newStudentProfile(person);
        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
//        
        courseload.newSeatAssignment(courseoffer); //register student in class
        
        int total = department.calculateRevenuesBySemester("Fall2020");
//        System.out.print("Total: " + total);
        

// creating new departments
        ArrayList<String> departmentList = new ArrayList<>();
        departmentList.add("INFO");
        departmentList.add("CSYE");
        departmentList.add("MGEN");

        for(String s: departmentList) {
            addDepartment(s);
        }

// creating new courses
        ArrayList<String> courseList = new ArrayList<>();
        
        for(String d: departmentList) {
            for(int i = 0; i < 4; i++) {
                String n = faker.funnyName().name();
                courseList.add(n);
                getDepartmentFromDirectory(d).getCourseCatalog().newCourse(n,n,4);
            }
        }
        
        showCoursesMenu(null);
        // creating new semesters
        ArrayList<String> semesterList = new ArrayList<String>() {
            {
                add("Fall2020");
                add("Spring2021");
            }
        };
        
        ArrayList<String> personList = new ArrayList<>();
        
        ArrayList<String> facultyList = new ArrayList<>();

        // creating new faculty
        for(Department d: departmentDirectory) {
            for(int i = 0; i < 5; i++) {
                String name = faker.name().fullName();
                personList.add(name);
                facultyList.add(name);
                d.getFacultydirectory().newFacultyProfile(pd.newPerson(name));
            }
        }
        
        ArrayList<String> studentList = new ArrayList<>();
        
        // creating new students
        for(Department d: departmentDirectory) {
            for(int i = 0; i < 20; i++) {
                String name = faker.name().fullName();
                studentList.add(name);
                d.getStudentDirectory().newStudentProfile(pd.newPerson(name));
            }
        }
        
        // creating new course schedules
        for(String sem: semesterList) {
            for(Department d:departmentDirectory) {
                d.newCourseSchedule(sem);
            }
        }
        
        // creating new courses
        for(Department d:departmentDirectory) {
            for(int i = 0; i < 4; i++) {
                String n = faker.funnyName().name();
                courseList.add(n);
//                    String cNum = getDepartmentFromDirectory(d.getName()).getCourseCatalog().newCourse(n,n,4).getCourseNumber();
                getDepartmentFromDirectory(d.getName()).getCourseCatalog().newCourse(n,n,4);
                for(String semester: semesterList) {
                    getDepartmentFromDirectory(d.getName()).getCourseSchedule(semester).newCourseOffer(n).generatSeats(20);
                }
            }
        }
        
        
        
        
//        
//        while(showMainMenu());
        

    }
    
    public static Department addDepartment(String n) {
        Department newDepartment = new Department(n);
        departmentDirectory.add(newDepartment);
        return newDepartment;
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
        Boolean isError = true;
        System.out.println("Choose one option from below:\n");
        Boolean isValidChoice = false;
        
        while(!isValidChoice) {
            System.out.println(" 1. Show Departments");
            System.out.println(" 2. Show Courses");
            System.out.println(" 3. Show Placements");
            System.out.println(" 4. Show Student Performance provided by Employers");
            System.out.println(" 5. Create Department");
            System.out.println(" 6. Show Employers"); //TODO: Implement
            System.out.println("99. Exit");

            Scanner scanner;
        
            while(isError) {
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
                    System.out.println("Enter the new department name: ");
                    String newDepartmentName = new Scanner(System.in).nextLine();
                    createDepartment(newDepartmentName);
                    break;
                    
//                case 6:
//                    isValidChoice = true;
//                    System.out.println("Below are all employers: ");
//                    for(EmployerProfile 
//                    }

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

    private static Department createDepartment(String department) {
        Department d = null;
        if(getDepartmentFromDirectory(department) == null) {
            d = new Department(department);
            departmentDirectory.add(d);
            System.out.println("Department " + department + " successfully created..");
        }
        else {
            d = getDepartmentFromDirectory(department);
            System.out.println("Department " + department + " already exists..");
            System.out.println("Department creation failed...");
        }
        return d;
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
                        createDepartment(department);
//                        System.out.println("Department " + department + " is created successfully..");
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
                    System.out.println(e);
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
            isValidChoice = true;
            try {
//              int choice;
                System.out.println(" 1. Show Courses");
                System.out.println(" 2. Show Placements");
                System.out.println(" 3. Show Student Performance provided by Employers");
                System.out.println(" 4. Add Course");
//                System.out.println(" 6. See Students"); //TODO: Implement   // See student history, assign GPA
//                System.out.println(" 7. Add Student");  //TODO: Implement
//                System.out.println(" 8. Show Faculty"); //TODO: Implement
//                System.out.println(" 9. Create Faculty");   //TODO: Implement
//                System.out.println("10. Create course offer"); //TODO: Implement
//                System.out.println("11. Assign courseoffer to student"); //TODO:  alongwith with seat assignment
////                System.out.println("12. Assign GPA");       //TODO: Implement
//                System.out.println("13. Show Employers"); //TODO: Implement
//                System.out.println("14. Add Employer"); //TODO: Implement
//                System.out.println("15. Show Job Roles"); //TODO: Implement
//                System.out.println("16. Add New Jobs"); //TODO: Implement
//                System.out.println("17. Assign a job to Student"); //TODO: Implement
//                System.out.println("18. Show Employers"); //TODO: Implement
                
                System.out.println("99. Go Back");
                
                switch(new Scanner(System.in).nextInt()) {
                    case 1:
//                        isValidChoice = true;
                        showCoursesMenu(d.getName());
                        break;
                    case 2:
//                        isValidChoice = true;
                        showPlacementsMenu(d.getName());
                        break;
                    case 3:
//                        isValidChoice = true;
                        showStudentPerformance(d.getName());
                        break;
                    case 4:
                        System.out.println("Enter course name to add: ");
                        String newCourseName = new Scanner(System.in).nextLine();
                        createCourse(d,newCourseName);
                        break;
                    case 99:
                        return;
                    default:
                        isValidChoice = false;
                        System.out.println("Please choose a valid option.");
                        break;
                }
            }
            catch(Exception e) {
                isValidChoice = false;
                System.out.println(e);
                System.out.println("Please choose a valid option.");
            }
        }
        //To change body of generated methods, choose Tools | Templates.
    }
    
    public static Course createCourse(Department d,String newCourseName) {
        Course c = null;
        if(d.getCourseCatalog().hasCourse(newCourseName)) {
            System.out.println("Course " + newCourseName + " already present in " + d.getName() + " department");
            System.out.println("Course creation failed..");
        }
        else {
//          System.out.println("Enter course number: ");
            c = d.getCourseCatalog().newCourse(newCourseName, newCourseName, 4);
            System.out.println("Course " + newCourseName + " created successfully in " + d.getName() + " department");
        }
        return c;
    }
    
    public static void chooseOption(String s) {
        if(s == null)
            System.out.println("Choose an option from below OR 99 to go back: ");
        else
            System.out.println("Choose one " + s + " from below OR 99 to go back: ");
    }

    private static void listCourses(String department) {
        String printFormat = "%4s. %15s\t%15s\n";
        System.out.printf(printFormat, "S.No","Course","Department");
        System.out.println("--------------------------------------");
        if(department == null) {
            int i = 0;
            for(Department d: departmentDirectory) {

                for(Course c: d.getCourseCatalog().getCourseList()) {
                    i++;
                    System.out.printf(printFormat,i,c.getName(),d.getName());
                }
                
            }
        }
        else {
            Department d = getDepartmentFromDirectory(department);
            int i = 0;
            for(Course c: d.getCourseCatalog().getCourseList()) {
                i++;
                System.out.printf(printFormat,i,c.getName(),d.getName());
            }
        }
    }
    
    private static void showCoursesMenu(String department) {
        int choice;
        chooseOption("course");
        listCourses(department);
        Boolean isValidChoice = false;
        Course selectedCourse = null;
        Department selectedDepartment = null;
        while(!isValidChoice) {
            try {
                choice = new Scanner(System.in).nextInt();
                if(choice == 99) {
                    System.out.println("Going back..\n");
                    return;
                }
                if(department == null) {
                    while(choice > 0) {
                        for(Department d: departmentDirectory) {
                            for(Course c: d.getCourseCatalog().getCourseList()) {
                                choice--;
                                if(choice == 0) { 
                                    selectedCourse = c;
                                    selectedDepartment = d;
                                }
                            }
                        }
                    }
                    if(selectedCourse == null) {
                        new Exception();
                    }
                }
                else {
                    Department d = getDepartmentFromDirectory(department);
                    selectedCourse = d.getCourseCatalog().getCourseList().get(choice - 1);
                }
                isValidChoice = true;
            }
            catch (Exception e) {
                chooseOption("course");
            }
        }
        System.out.println("Selected Course: " + selectedCourse.getName());
        
//        System.out.println("Below are the course offers: ");
//        for(CourseOffer co: selectedDepartment.getCourseCatalog().)
        
        System.out.println("\n\n  1. See all students\nAny. Go back");
        if(new Scanner(System.in).nextLine() == "1") {
            int i = 0;
            String printFormat = "%-4s. %20s %4s";
            for(StudentProfile s: selectedDepartment.getStudentDirectory().getStudentlist()) {
                if(i == 0) {
                    System.out.printf(printFormat,"S.No","Name","GPA");
                    System.out.println("-----------------------------------");
                }
                i++;
                System.out.printf(printFormat,i,s.getName(),s.getGPAbyCourseName(selectedCourse.getName()));
            }
        }
        else
            return;
    }

    private static void showPlacementsMenu(String department) {
        System.out.println("Below are all the placements: ");
        int i = 0;
        String printFormat = "%4s. %20s\t%20s\t%20s";
        System.out.printf(printFormat,"S.No","Job Role","Employer","Student Name");
        System.out.println("---------------------------------------------------------------------");
        for(StudentProfile sp: getDepartmentFromDirectory(department).getStudentDirectory().getStudentlist()) {
            for(Employment e: sp.getEmploymentHistoryList()) {
                i++;
                System.out.printf(printFormat,i,e.getJobRole(),e.getEmployerName(),sp.getName());
            }
        }
    }

    private static void showStudentPerformance(String department) {
        System.out.println("Below are all the placements: ");
        int i = 0;
        String printFormat = "%4s. %20s\t%20s\t%20s\t%10s";
        System.out.printf(printFormat,"S.No","Student Name","Department","Employer","Performance Rating");
        System.out.println("------------------------------------------------------------------------");
        if(department != null)
            for(StudentProfile sp: getDepartmentFromDirectory(department).getStudentDirectory().getStudentlist()) {
                for(Employment e: sp.getEmploymentHistoryList()) {
                    i++;
                    System.out.printf(printFormat,i,sp.getName(),department,e.getEmployerName(),e.getStudentQualityAtJob());
                }
            }
        else {
            for(Department d: departmentDirectory){
                for(StudentProfile sp: getDepartmentFromDirectory(d.getName()).getStudentDirectory().getStudentlist()) {
                    for(Employment e: sp.getEmploymentHistoryList()) {
                        i++;
                        System.out.printf(printFormat,i,sp.getName(),d.getName(),e.getEmployerName(),e.getStudentQualityAtJob());
                    }
                }
            }
        }
    }

    private static void listDepartments() {
        int i = 0;
        for(Department d: departmentDirectory) {
            i++;
            System.out.println(i + " " + d.getName());
        }
    }

}
