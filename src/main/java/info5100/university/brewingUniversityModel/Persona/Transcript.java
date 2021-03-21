/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.brewingUniversityModel.Persona;

import info5100.university.brewingUniversityModel.CourseSchedule.CourseLoad;
import info5100.university.brewingUniversityModel.CourseSchedule.SeatAssignment;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kal bugrara
 */
public class Transcript {
    
    
    HashMap<String, CourseLoad> courseloadlist;
    
    CourseLoad currentcourseload;
    
    public Transcript(){
        
        courseloadlist = new HashMap<String, CourseLoad>();
        
    }
    
    public CourseLoad newCourseLoad(String sem){
        
        currentcourseload = new CourseLoad(sem);
        courseloadlist.put(sem, currentcourseload);
        return currentcourseload;
    }
    
    public CourseLoad getCurrentCourseLoad(){
        
        return currentcourseload;
        
    }
    public CourseLoad getCourseLoadBySemester(String semester){
        
        return courseloadlist.get(semester);
        
    }
    
    public float getOverallGPA() {
        int courseCount = 0;
        float cumulativeGPA = 0;
        for(Map.Entry<String, CourseLoad> cl: courseloadlist.entrySet()) {
            for(SeatAssignment sa: cl.getValue().getSeatAssignmentsForSemester(cl.getKey())) {
                courseCount++;
                cumulativeGPA += sa.getGPA();
            }
        }
        return (float)(cumulativeGPA/courseCount);
    }
    
}
