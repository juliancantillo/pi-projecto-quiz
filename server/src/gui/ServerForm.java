/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entity.Quiz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import resources.R;
import server.DataHandler;

/**
 * Universidad del Valle
 *
 * @author Julian Andres Cantillo // cod: 1431263 - 3743
 */
public class ServerForm extends JFrame implements ActionListener {

  public ServerForm() {
    super("Server");

    setJMenuBar(mnActions());
    add(pnlStatus());

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 300);
  }

  private JMenuBar mnActions() {
    JMenuBar menu = new JMenuBar();

    JMenu mnFile = new JMenu(R.STR_FILE);
    JMenu mnQuiz = new JMenu(R.STR_QUIZ);

    JMenuItem mnItemExit = new JMenuItem(R.STR_EXIT);
    JMenuItem mnItemLoad = new JMenuItem(R.STR_LOAD);
    JMenuItem mnItemNQuiz = new JMenuItem(R.STR_NEW);

    mnItemExit.addActionListener(this);
    mnItemLoad.addActionListener(this);
    mnItemNQuiz.addActionListener(this);

    mnItemExit.setActionCommand(R.CMD_EXIT);
    mnItemLoad.setActionCommand(R.CMD_LOAD_FILE);
    mnItemNQuiz.setActionCommand(R.CMD_NEW_QUIZ);

    mnQuiz.add(mnItemNQuiz);
    mnQuiz.add(mnItemLoad);

    mnFile.add(mnQuiz);
    mnFile.add(mnItemExit);

    menu.add(mnFile);

    return menu;
  }

  private JPanel pnlStatus() {
    JPanel panel = new JPanel();

    JLabel lblStatus = new JLabel(String.format(R.STR_STATUS, "Prueba"));

    panel.add(lblStatus);

    return panel;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();

    if (cmd.equals(R.CMD_EXIT)) {
      System.exit(0);
    }
    if (cmd.equals(R.CMD_NEW_QUIZ)) {
      CreateQuizForm quizForm = new CreateQuizForm();
      quizForm.setVisible(true);
    }
    if (cmd.equals(R.CMD_LOAD_FILE)) {

      JFileChooser fileChooser = new JFileChooser();
      DataHandler dataHandler = new DataHandler();

      int result = fileChooser.showOpenDialog(this);

      // if user clicked Cancel button on dialog, return
      if (result != JFileChooser.CANCEL_OPTION) {
        File file = fileChooser.getSelectedFile(); // get File

        try {
          Quiz quiz = dataHandler.loadQuiz(file);
          
          JOptionPane.showMessageDialog(this, String.format(R.QUIZ_LOADED, quiz.getTitle()));
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(this, R.FILE_NOT_FOUND);
        }
      }

    }

  }

}
