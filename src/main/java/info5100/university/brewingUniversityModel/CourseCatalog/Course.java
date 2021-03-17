/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.brewingUniversityModel.CourseCatalog;

/**
 *
 * @author kal bugrara
 */
public class Course {
    String number;
    String name;
    int credits;
    Boolean core = true;
    int price = 1500; //per credit hour
    //create boolean, method to check boolean is true or false
    
    public Course(){
        
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    public Course(String n, String numb, int ch){
        name = n;
        number = numb;
        credits = ch;


    }
    public String getCOurseNumber(){
        return number;
    }
    
    public void setCredits(int number) {
        this.credits = number;
    }
    public int getCredits(){
        return credits;
    }

    public int getCoursePrice(){
        return price*credits;

    }

    public Boolean isElective(){
        return true;
    }

    public Boolean isCore(){
        return true;
    }

    public String toString(){
        return this.name;
    }
}
