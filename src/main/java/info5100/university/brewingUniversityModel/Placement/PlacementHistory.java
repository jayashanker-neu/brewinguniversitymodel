/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.brewingUniversityModel.Placement;

import info5100.university.brewingUniversityModel.Department.Department;
import info5100.university.brewingUniversityModel.Persona.EmploymentHistory.Employment;
import info5100.university.brewingUniversityModel.Persona.StudentProfile;
import java.util.ArrayList;

/**
 *
 * @author jayas
 */
public class PlacementHistory {
    Department department;
    String semester;
    ArrayList<Placement> placementList;
    
    public PlacementHistory(Department d) {
        department = d;
        placementList = new ArrayList();
    }
    
    public Placement newPlacement(StudentProfile student, Employment emp){
        Placement p = new Placement(student,emp);
        placementList.add(p);
        return p;
    }
    
}
