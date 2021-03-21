/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.brewingUniversityModel.Persona;

/**
 *
 * @author kal bugrara
 */
public class Person {
    static int idSeq = 0;
    int id;
    String name;
    public Person (String name){
        idSeq++;
        this.id = idSeq;
        this.name = name;
    }
    public int getPersonId(){
        return id;
    }

    public boolean isMatch(int id){
        if(this.id == id) return true;
        return false;
    }
    
    public String getName() {
        return this.name;
    }
    
}
