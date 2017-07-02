package com.hjn.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Created by xiaoz on 2017/6/19.
 */
@Entity
public class Boby {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Min(value = 18,message = "small age")
    private Integer age;

    public Boby() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
