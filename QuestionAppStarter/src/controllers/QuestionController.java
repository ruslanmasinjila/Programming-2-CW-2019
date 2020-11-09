/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import helpers.InputHelper;

/**
 *
 * @author mga
 */
public class QuestionController {
    // private final Repository repository;
    
    /**
     *
     */
        
    public QuestionController() {
       // to be completed
    }
   
    /**
     *
     */
    public void run() {
        boolean finished = false;
        
        do {
            char choice = displayMenu();
            switch (choice) {
                case 'A': 
                    addQuestion();
                    break;
                case 'B':  
                    modifyQuestion();
                    break;
                case 'C': 
                    listTopicQuestionDataInTextOrder();
                    break;                    
                case 'Q': 
                    finished = true;
            }
        } while (!finished);
    }
    
    private char displayMenu() {
        listQuestionDataInIdOrder();
        InputHelper inputHelper = new InputHelper();
        System.out.print("\nA. Add Question");
        System.out.print("\tB. Modify Question");        
        System.out.print("\tC. List Topic Question Data In Text Order");     
        System.out.print("\tQ. Quit\n");         
        return inputHelper.readCharacter("Enter choice", "ABCQ");
    }    
    
    private void addQuestion() {
        System.out.format("\033[31m%s\033[0m%n", "Add Question");
        System.out.format("\033[31m%s\033[0m%n", "============");       
    }
    
    private void modifyQuestion() {        
        System.out.format("\033[31m%s\033[0m%n", "Modify Question");
        System.out.format("\033[31m%s\033[0m%n", "===============");       
    }    
      

    private void listTopicQuestionDataInTextOrder() {        
        System.out.format("\033[31m%s\033[0m%n", "Question Text Order");
        System.out.format("\033[31m%s\033[0m%n", "===================");
    }      
    
    private void listQuestionDataInIdOrder() {        
        System.out.format("\033[31m%s\033[0m%n", "Question Id Order");
        System.out.format("\033[31m%s\033[0m%n", "=================");
    }     
}
