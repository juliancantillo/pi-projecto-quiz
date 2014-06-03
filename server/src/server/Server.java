/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import entity.Quiz;
import gui.ServerForm;

/**
 *
 * @author Usuario
 */
public class Server {
  
  public static Quiz quiz = new Quiz();
  private final ServerForm mainForm;

  public Server() {
    
    mainForm = new ServerForm();
    mainForm.setVisible(true);
    
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    Server srv = new Server();
    
  }
  
}
