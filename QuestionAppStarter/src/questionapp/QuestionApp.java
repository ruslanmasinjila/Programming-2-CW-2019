/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questionapp;

import controllers.QuestionController;

/**
 *
 * @author mga
 */
public class QuestionApp {

    /**
     *
     */
    public static void run() {    
        System.out.println("Question App\n============\n\n");
        
        QuestionController questionController = new QuestionController();  
        
        questionController.run();
        
        System.out.println("Thank you for using Question App. Good bye.\n");        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        QuestionApp questionApp = new QuestionApp();
        questionApp.run();
    }
    
}
