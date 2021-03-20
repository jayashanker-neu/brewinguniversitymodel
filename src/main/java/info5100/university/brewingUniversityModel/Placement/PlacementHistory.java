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
import java.util.HashMap;

/**
 *
 * @author jayas
 */
public class PlacementHistory {
    Department department;
    HashMap<String, ArrayList<Placement>> placementList;
    
    public PlacementHistory(Department d) {
        department = d;
        placementList = new HashMap<String, ArrayList<Placement>>();
    }
    
    public PlacementHistory(Department d, String semester) {
        department = d;
        placementList = new HashMap<String, ArrayList<Placement>>(){{
            put(semester,null);
        }};
    }
    
    public Placement newPlacement(StudentProfile student, Employment emp, String semester){
        Placement p = new Placement(student,emp,semester);
        ArrayList<Placement> placements = placementList.get(semester);
        if (placements.isEmpty()) {
            placements = new ArrayList<Placement>();
            placements.add(p);
            placementList.put(semester,placements);
        }
        else{
            placements.add(p);
        }
        
        return p;
    }
    
    public ArrayList<Placement> getPlacementList(String semester) {
        return placementList.get(semester);
    }
    
}
