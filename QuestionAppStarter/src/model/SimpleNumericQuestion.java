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
public class SimpleNumericQuestion extends Question {
    
    private int simpleNumericResponse;
    
    static final char EOLN='\n';       
    static final String QUOTE="\""; 

    /**
     *
     */
    public SimpleNumericQuestion() {
        super();
        this.simpleNumericResponse = -1;
    }

    /**
     *
     * @param questionText
     * @param topicArea
     * @param simpleNumericResponse
     */
    public SimpleNumericQuestion(String questionText, String topicArea, int simpleNumericResponse) {
        super(questionText, topicArea);
        this.simpleNumericResponse = simpleNumericResponse;
    }

    /**
     *
     * @param id
     * @param questionText
     * @param topicArea
     * @param simpleNumericResponse
     */
    public SimpleNumericQuestion(int id, String questionText, String topicArea, int simpleNumericResponse) {
        super(id, questionText, topicArea);
        this.simpleNumericResponse = simpleNumericResponse;
    }
    
    // Methods required: getters, setters

    @Override
    public String toString() {
        return  "\nQuestion Id: " + id + " - Question Text: " + questionText +            
                " - Topic Area: " + topicArea + " - Simple Numeric Response: " + simpleNumericResponse + "\n";
    }   
}
