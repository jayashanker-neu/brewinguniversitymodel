/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.brewingUniversityModel.CourseCatalog;

import info5100.university.brewingUniversityModel.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseCatalog {
    Department department;
    String lastupdated;
    ArrayList<Course> courselist;  //will have all courses
    ArrayList<Course> coreList; //core subjects from courses
    ArrayList<Course> electiveList; //core subjects from courses
    public CourseCatalog(Department d){
        courselist = new ArrayList();
        department = d;
    }
    
    //write a method taht takes arraylist and loop them to add core and elective for hardcoded
    
    public ArrayList<Course> getCourseList(){
        return courselist;
    }
    
    public void removeCourse(Course c) {
        courselist.remove(c);
    }
    
    public Course addCourse() {
        Course p = new Course();
        courselist.add(p);
        return p;
    }
    
    public Course newCourse(String n, String nm, int cr){
        Course c = new Course(n, nm, cr);
        courselist.add(c);
        return c;
    }
    
    public Course getCourseByNumber(String n){
        
        for( Course c: courselist){
            
            if(c.getCOurseNumber().equals(n)) return c;
        }
        return null;
    }
    
    public Course searchCourse(int id) {
        for (Course product : courselist) {
            if(product.getNumber().equals(String.valueOf(id))){
                return product;
            }
        }
        return null;
    }

}