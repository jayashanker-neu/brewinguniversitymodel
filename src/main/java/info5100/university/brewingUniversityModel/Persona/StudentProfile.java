/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.brewingUniversityModel.Persona;

import info5100.university.brewingUniversityModel.CourseSchedule.CourseLoad;
import info5100.university.brewingUniversityModel.Persona.EmploymentHistory.Employment;
import info5100.university.brewingUniversityModel.Persona.EmploymentHistory.EmploymentHistory;

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

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
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

    public void setEmploymenthistory(EmploymentHistory employmenthistory) {
        this.employmenthistory = employmenthistory;
    }
    
    public void addEmployment(String job){
        this.employmenthistory.newEmployment(job);
    }
}
