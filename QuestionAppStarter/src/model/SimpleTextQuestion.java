/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mga
 */
public class SimpleTextQuestion extends Question {
    
    private String simpleTextResponse;
    
    static final char EOLN='\n';       
    static final String QUOTE="\""; 

    /**
     *
     */
    public SimpleTextQuestion() {
        super();
        this.simpleTextResponse = "TBC";
    }

    /**
     *
     * @param questionText
     * @param topicArea
     * @param simpleTextResponse
     */
    public SimpleTextQuestion(String questionText, String topicArea, String simpleTextResponse) {
        super(questionText, topicArea);
        this.simpleTextResponse = simpleTextResponse;
    }

    /**
     *
     * @param id
     * @param questionText
     * @param topicArea
     * @param simpleTextResponse
     */
    public SimpleTextQuestion(int id, String questionText, String topicArea, String simpleTextResponse) {
        super(id, questionText, topicArea);
        this.simpleTextResponse = simpleTextResponse;
    }
    
    // Methods required: getters, setters

    @Override
    public String toString() {
        return  "\nQuestion Id: " + id + " - Question Text: " + questionText +            
                " - Topic Area: " + topicArea + " - Simple Text Response: " + simpleTextResponse + "\n";
    }   
}
