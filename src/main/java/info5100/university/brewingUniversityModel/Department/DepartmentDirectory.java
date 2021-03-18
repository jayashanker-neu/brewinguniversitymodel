/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.brewingUniversityModel.Department;

import java.util.ArrayList;
import java.util.List;
import info5100.university.brewingUniversityModel.Department.*;

/**
 *
 * @author umair
 */
public class DepartmentDirectory {

    private List<Department> departmentList;

    public DepartmentDirectory() {
        departmentList = new ArrayList<Department>();
    }

    public List<Department> getDepartmentlist() {
        return departmentList;
    }

    public Department addDepartment(String n) {
        Department newDepartment = new Department(n);
        departmentList.add(newDepartment);
        return newDepartment;
    }

//    public Department addDepartment() {
//        Department newDepartment = new Department();
//        departmentList.add(newDepartment);
//        return newDepartment;
//    }
    public void removeDepartment(Department d) {
        departmentList.remove(d);
    }

    public Department searchDepartment(String departmentName) {
        for (Department department : departmentList) {
            if (department.getName().equals(departmentName)) {
                return department;
            }
        }
        return null;
    }
}


