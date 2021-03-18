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

/**
 *
 * @author kal bugrara
 */
public class brewingUniversityModel {

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
        
        Department department = new Department("Information Systems");

        Course course = department.newCourse("app eng", "info 5100", 4);

        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");

        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        
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

    }

}
