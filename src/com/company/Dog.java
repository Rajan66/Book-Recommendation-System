package com.company;

class Animal{
    private String color = "white";
    public void display(){
        System.out.println(color);
    }
}

public class Dog extends Animal{
    private String color = "brown";
    public void display(){
        super.display();
        System.out.println(color);
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.display();
    }
}
