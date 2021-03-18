/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.brewingUniversityModel.Placement;

import info5100.university.brewingUniversityModel.Persona.EmploymentHistory.Employment;
import info5100.university.brewingUniversityModel.Persona.StudentProfile;

/**
 *
 * @author jayas
 */
public class Placement {
    StudentProfile student;
    Employment employment;

    public Placement(StudentProfile student, Employment emp) {
        this.student = student;
        this.employment = emp;
    }
    
}
