/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.brewingUniversityModel.Persona.EmploymentHistory;

import info5100.university.brewingUniversityModel.CourseSchedule.CourseOffer;
import info5100.university.brewingUniversityModel.Employer.EmployerProfile;
import info5100.university.brewingUniversityModel.Persona.StudentProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Employment {
    ArrayList<CourseOffer> relevantcourseoffers; //which course number is giving more employments
    int weight; // idk as of now
    String quality; //quality of job
    String job; //job role
    Employment nextemplyment;  //next job so they are in a sequence 
    
    EmployerProfile employer;
    public Employment(String j){
        this.job = j;
        this.weight = 10;
        this.quality = "Very Good";
        ArrayList relevantcourseoffers = new ArrayList();
        
    }

    public String getJobRole() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public EmployerProfile getEmployer() {
        return employer;
    }
    
    public String getEmployerName() {
        return employer.getName();
    }

    public void setEmployer(EmployerProfile employer) {
        this.employer = employer;
    }
    
    public String getStudentQualityAtJob(){
        return quality;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
    
    

}
