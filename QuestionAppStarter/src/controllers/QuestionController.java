/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import helpers.InputHelper;
import model.SimpleNumericQuestion;
import model.SimpleTextQuestion;
import repositories.Repository;

/**
 *
 * @author mga
 */
public class QuestionController {

    private final Repository repository;

    /**
     *
     */
    public QuestionController() {
        InputHelper inputHelper = new InputHelper();
        char c = inputHelper.readCharacter("Load an already existing Questions File (Y/N)?");
        if (c == 'Y' || c == 'y') {
            String fileName = inputHelper.readString("Enter filename");
            this.repository = new Repository(fileName);
        } else {
            this.repository = new Repository();
        }
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
                    InputHelper inputHelper = new InputHelper();
                    String fileName = inputHelper.readString("Enter filename (eg saved.txt)");                
                    repository.store(fileName);  
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
        InputHelper inputHelper = new InputHelper();
        
        System.out.format("\033[31m%s\033[0m%n", "Add Question");
        System.out.format("\033[31m%s\033[0m%n", "============");
        
        String questionTypePrompt = "Which type of Question are you goint to add?" + "\n" +
                                     "A: Simple Text Question" + "\n" + 
                                     "B: Simple Numeric Question";
                                     
        char questionType = inputHelper.readCharacter(questionTypePrompt);
        
        if(questionType == 'A'|| questionType=='a')
        {
            // Create a new Simple Text Question and add to repository
            String questionText = inputHelper.readString("Please Enter the Question Text");
            String topicArea = inputHelper.readString("Please Enter the topic Area");
            String simpleTextResponse = inputHelper.readString("Please Enter the text response to the question");
            
            SimpleTextQuestion simpleTextQuestion = new SimpleTextQuestion(questionText,topicArea, simpleTextResponse);
            repository.add(simpleTextQuestion);
        }
        
        else if(questionType == 'B'|| questionType=='b')
        {
            // Create a new Simple Numeric Question and add to repository
            String questionText = inputHelper.readString("Please Enter the Question Text");
            String topicArea = inputHelper.readString("Please Enter the topic Area");
            int simpleNumericResponse = inputHelper.readInt("Please Enter the numeric response to the question");
            
            SimpleNumericQuestion simpleNumericQuestion = new SimpleNumericQuestion(questionText,topicArea, simpleNumericResponse);
            repository.add(simpleNumericQuestion);
        }
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
