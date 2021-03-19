/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.brewingUniversityModel.faker;

import com.github.javafaker.Faker;

/**
 *
 * @author jayas
 */
public class MyFaker {
    Faker faker;
    
    public static void main(String args[]){
        Faker faker = new Faker();
        System.out.println(faker.university().name());
    }
    
}
