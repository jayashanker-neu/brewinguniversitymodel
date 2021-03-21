/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.brewingUniversityModel.Persona;

import info5100.university.brewingUniversityModel.CourseSchedule.CourseLoad;
import info5100.university.brewingUniversityModel.CourseSchedule.SeatAssignment;
import info5100.university.brewingUniversityModel.Persona.EmploymentHistory.Employment;
import info5100.university.brewingUniversityModel.Persona.EmploymentHistory.EmploymentHistory;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author kal bugrara
 */
public class StudentProfile {

    Person person;
    Transcript transcript;
    EmploymentHistory employmenthistory; //track the employment of student irrespective of time
    

    public StudentProfile(Person p) {

        person = p;
        transcript = new Transcript();
        employmenthistory = new EmploymentHistory();
    }

    public String getName() {
        return person.getName();
    }
    
    public boolean isMatch(int id) {
        if (person.getPersonId() == id ) {
            return true;
        }
        return false;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {

        return transcript.getCourseLoadBySemester(semester);
    }

    public CourseLoad getCurrentCourseLoad() {

        return transcript.getCurrentCourseLoad();
    }

    public CourseLoad newCourseLoad(String s){
        
        return transcript.newCourseLoad(s);
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public EmploymentHistory getEmploymenthistory() {
        return employmenthistory;
    }
    
    public ArrayList<Employment> getEmploymentHistoryList() {
        return this.employmenthistory.getEmployments();
    }

    public void setEmploymenthistory(EmploymentHistory employmenthistory) {
        this.employmenthistory = employmenthistory;
    }
    
    public void addEmployment(String job){
        this.employmenthistory.newEmployment(job);
    }
    
    public float getGPAbyCourseName(String course) {
        for(Map.Entry<String, CourseLoad> cl: transcript.courseloadlist.entrySet()) {
            for(SeatAssignment sa: cl.getValue().getSeatAssignmentsForSemester(cl.getKey())) {
                if(sa.getCourseName().equals(course))
                    return sa.getGPA();
            }
        }
        return 4;
    }
    
    public float getGPAbyCourseName(String course, String semester) {
        for(Map.Entry<String, CourseLoad> cl: transcript.courseloadlist.entrySet()) {
            for(SeatAssignment sa: cl.getValue().getSeatAssignmentsForSemester(cl.getKey())) {
                if(sa.getCourseName().equals(course))
                    return sa.getGPA();
            }
        }
        return 4;
    }
    
}
