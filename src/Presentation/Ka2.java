/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import entity.*;
import facade.MyFacade;

/**
 *
 * @author jones
 */
public class Ka2 {
    public static void main(String[] args) {
        MyFacade f = new MyFacade();
        
        Person p = new Person("test1", "test2");
        InfoEntity info = new InfoEntity("mailTest");
        Phone phone = new Phone(11, "testNubmer");
        
        Address add = new Address("test1", "tesst1");
        Cityinfo cityInfo = new Cityinfo("1111", "testby");
        
        Hobby hobby = new Hobby("Fodbold","Arsenal er bedst");
        
        f.addPerson(info, p, phone, add, cityInfo, hobby);
        
        System.out.println("Person"+  f.getPerson(3));
    }
}
