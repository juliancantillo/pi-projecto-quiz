/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import gui.helpers.GBHelper;
import gui.helpers.Gap;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import resources.R;

/**
 * Universidad del Valle
 * @author Julian Andres Cantillo // cod: 1431263 - 3743
 */
public class CreateQuizForm extends JFrame implements ActionListener{

  private JTextField fldTitle;
  private JList lstQuestions;
  
  public CreateQuizForm() {
    super(R.STR_CREATE_QUIZ);
    
    setLayout(new BorderLayout(R.W, R.H));
    
    add(pnlFields(), BorderLayout.NORTH);
    add(pnlQuestions(), BorderLayout.CENTER);
    
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(500,300);
  }
  
  private JPanel pnlFields(){
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    
    JLabel lblTitle = new JLabel(R.STR_TITLE);
    fldTitle = new JTextField();
    
    GBHelper pos = new GBHelper();
    
    panel.add( lblTitle, pos );
    panel.add( new Gap(R.W), pos.nextCol() );
    panel.add( fldTitle, pos.nextCol().expandW() );
    
    return panel;
  }
  
  private JPanel pnlQuestions(){
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    
    lstQuestions = new JList();
    
    GBHelper pos = new GBHelper();
    
    panel.add(new JScrollPane(lstQuestions), pos.expandH().expandW());
    
    return panel;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    
  }
  
}
