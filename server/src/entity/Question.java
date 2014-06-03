/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.ArrayList;

/**
 * Universidad del Valle
 * @author Julian Andres Cantillo // cod: 1431263 - 3743
 */
public class Question {
  
  private String text;
  private ArrayList<Option> options;

  public Question(){
    
  }
  
  public Question(String text, ArrayList options) {
    this.text = text;
    this.options = options;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public ArrayList getOptions() {
    return options;
  }

  public void setOptions(ArrayList options) {
    this.options = options;
  }

  @Override
  public String toString() {
    return text;
  }

}
