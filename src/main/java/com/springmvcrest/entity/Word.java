package com.springmvcrest.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "word")
public class Word implements Serializable{
    private static final long serialVersionUID = -5527566248002296042L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    @Column(name = "word_ru",nullable = false)
    private String word_ru;
    @Column(name = "word_en",nullable = false)
    private String word_en;

    public Word(String word_ru, String word_en) {
        this.word_ru = word_ru;
        this.word_en = word_en;
    }

    public Word() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWord_ru() {
        return word_ru;
    }

    public void setWord_ru(String word_ru) {
        this.word_ru = word_ru;
    }

    public String getWord_en() {
        return word_en;
    }

    public void setWord_en(String word_en) {
        this.word_en = word_en;
    }
}
