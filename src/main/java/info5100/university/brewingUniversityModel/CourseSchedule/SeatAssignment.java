/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.brewingUniversityModel.CourseSchedule;

/**
 *
 * @author kal bugrara
 */
public class SeatAssignment {
    
    Seat seat;
    CourseLoad courseload;
    float GPA;
    
    public SeatAssignment(CourseLoad cl, Seat s){
        seat = s;
        courseload = cl;
    }
        public SeatAssignment(){

    }
    public void assignSeatToStudent(CourseLoad cl){
        courseload = cl;
    }
    
    public String getCourseName() {
        return this.seat.courseoffer.getCourseName();
    }

    public float getGPA() {
        return GPA;
    }
    
    public void setGPA(float GPA) {
        this.GPA = GPA;
    }
    
    public Seat getSeat() {
        return seat;
    }
}
