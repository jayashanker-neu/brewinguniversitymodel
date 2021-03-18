/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentEmployment;

import info5100.university.brewingUniversityModel.Persona.EmploymentHistory.Employment;
import info5100.university.brewingUniversityModel.Persona.StudentProfile;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author umair
 */
public class StudentEmployment {
    /*
    should have all unique employments and all students in it
    */
    static int count = 0;
    ArrayList<StudentProfile> employedStudent;
    ArrayList<Employment> allEmployments;
    HashMap<Employment, ArrayList<StudentProfile>> map = new HashMap<Employment, ArrayList<StudentProfile>>();
    
    public void addEmploymentRecord(Employment e){
        if(!allEmployments.isEmpty()){
            for(Employment check:allEmployments){
                if((check.getJob().equals(e.getJob())) && (check.getEmployer().equals(e.getEmployer()))){
                       count++;
                }
            }
        }
        if(count!=0){
        allEmployments.add(e);
        }
    }
    
    
    
    
}
