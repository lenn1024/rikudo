package ai.code.practise.rikudo.java.test;

import lombok.Data;

@Data
public class Parent {

    private String name;

    private Boolean male;

    private boolean gentlemen;

    public Parent(String name){
        this.name = name;
    }

}
