package com.example.jwt3.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
public class Test
{
    @Id
    @GeneratedValue
    private int id;
    private String tittle;
    @ManyToMany
    private List<Quiz> questions;
}
