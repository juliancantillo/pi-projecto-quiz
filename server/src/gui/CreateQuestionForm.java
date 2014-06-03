/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import gui.helpers.GBHelper;
import gui.helpers.Gap;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import resources.R;

/**
 * Universidad del Valle
 * @author Julian Andres Cantillo // cod: 1431263 - 3743
 */
public class CreateQuestionForm extends JFrame{
  
  private JTextField fldQText;

  public CreateQuestionForm() {
    super( R.STR_CREATE_QUESTION );
    
    add(pnlFields());
    
    setSize(500,400);
  }
  
  private JPanel pnlFields(){
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    
    JLabel lblQText = new JLabel(R.STR_QUESTION_TEXT);
    
    fldQText = new JTextField();
    
    GBHelper pos = new GBHelper();
    
    panel.add( lblQText, pos );
    panel.add( new Gap(R.W), pos.nextCol() );
    panel.add( fldQText, pos.nextCol() );
    
    return panel;
  }

  
}
