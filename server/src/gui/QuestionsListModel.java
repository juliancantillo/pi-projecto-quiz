/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import entity.Question;
import entity.Quiz;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 * Universidad del Valle
 * @author Julian Andres Cantillo // cod: 1431263 - 3743
 */
public class QuestionsListModel implements ListModel<Question>{
  
  private Quiz quiz;

  public QuestionsListModel(Quiz quiz) {
    this.quiz = quiz;
  }

  @Override
  public int getSize() {
    return this.quiz.getQuestions().size();
  }

  @Override
  public Question getElementAt(int index) {
    return this.quiz.getQuestions().get(index);
  }

  @Override
  public void addListDataListener(ListDataListener l) {
    
  }

  @Override
  public void removeListDataListener(ListDataListener l) {
    
  }

}
