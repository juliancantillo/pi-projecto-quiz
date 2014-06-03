/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import entity.Quiz;
import gui.helpers.GBHelper;
import java.awt.GridBagLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Universidad del Valle
 * @author Julian Andres Cantillo // cod: 1431263 - 3743
 */
public class QuestionsList extends JPanel{
  
  private JList lstQuestions;

  public QuestionsList(Quiz quiz) {
    this.setLayout(new GridBagLayout());
    
    lstQuestions = new JList(new QuestionsListModel(quiz));
    
    GBHelper pos = new GBHelper();
    
    this.add(new JScrollPane(lstQuestions), pos.expandH().expandW());
  }

  public JList getLstQuestions() {
    return lstQuestions;
  }

  public void setLstQuestions(Quiz quiz) {
    this.lstQuestions.setModel(new QuestionsListModel(quiz));
  } 
  
}
