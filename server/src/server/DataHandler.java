/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import entity.Option;
import entity.Question;
import entity.Quiz;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Universidad del Valle
 *
 * @author Julian Andres Cantillo // cod: 1431263 - 3743
 */
public class DataHandler {

  public DataHandler() {
  }

  public JSONObject loadData(String file) throws FileNotFoundException, IOException {
    URL filePath = getClass().getResource(file);
    JSONObject data = null;

    JSONTokener tokener = new JSONTokener(filePath.openStream());
    data = new JSONObject(tokener);

    return data;
  }

  public JSONObject loadData(File file) throws FileNotFoundException, IOException {
    JSONObject data = null;
    
    File ofile = new File("E:/questions.json");
    
    FileReader r = new FileReader(file);
    
    FileInputStream is = new FileInputStream(file);

    JSONTokener tokener = new JSONTokener(r);
    data = new JSONObject(tokener);

    return data;
  }
  
  public Quiz loadQuiz(File file) throws IOException{
    Quiz quiz = new Quiz();
    ArrayList questions = new ArrayList();
   
    JSONObject quizData = loadData(file);

    quiz.setTitle(quizData.getString("title"));

    JSONArray questionsData = quizData.getJSONArray("questions");

    for (int i = 0; i < questionsData.length(); i++) {
      JSONObject question = questionsData.getJSONObject(i);
      questions.add(questionFromJSON(question));
    }

    quiz.setQuestions(questions);
    
    return quiz;
  }
  
  public Question questionFromJSON(JSONObject obj){
    Question question = new Question();
    ArrayList options = new ArrayList();
    
    question.setText( obj.getString("text") );
    
    JSONArray optionsData = obj.getJSONArray("options");
      
      for (int i = 0; i < optionsData.length(); i++) {
        JSONObject option = optionsData.getJSONObject(i);
        options.add(optionFromJSON(option));
      }
      
    question.setOptions(options);
    
    return question;
  }
  
  public Option optionFromJSON(JSONObject obj){
    Option option = new Option();
    
    option.setText( obj.getString("text") );
    if(obj.has("valid")){
      option.setValid( obj.getBoolean("valid") );
    }
    
    return option;
  }

}
