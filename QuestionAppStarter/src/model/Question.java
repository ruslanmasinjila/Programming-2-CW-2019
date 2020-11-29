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
abstract public class Question {

    /**
     *
     */
    protected final int id;

    /**
     *
     */
    protected String questionText;

    /**
     *
     */
    protected String topicArea;

    /**
     *
     */
    protected static int lastIdAllocated = 0;

    static final char EOLN = '\n';
    static final String QUOTE = "\"";

    /**
     *
     */
    public Question() {
        this.id = ++lastIdAllocated;
        this.questionText = "TBC";
        this.topicArea = "TBC";
    }

    /**
     *
     * @param questionText
     * @param topicArea
     */
    public Question(String questionText, String topicArea) {
        this.id = ++lastIdAllocated;
        this.questionText = questionText;
        this.topicArea = topicArea;
    }

    /**
     *
     * @param id
     * @param questionText
     * @param topicArea
     */
    public Question(int id, String questionText, String topicArea) {
        this.id = id;
        this.questionText = questionText;
        this.topicArea = topicArea;
        if (id > Question.lastIdAllocated) {
            Question.lastIdAllocated = id;
        }
    }

    public int getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getTopicArea() {
        return topicArea;
    }

    public void setTopicArea(String topicArea) {
        this.topicArea = topicArea;
    }

    public static int getLastIdAllocated() {
        return lastIdAllocated;
    }

    /**
     * @return the id
     */
    public static void setLastIdAllocated(int lastIdAllocated) {
        Question.lastIdAllocated = lastIdAllocated;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "\nQuestion Id: " + getId() + " - Question Text: " + getQuestionText()
                + " - Topic Area: " + getTopicArea() + "\n";
    }

    public abstract String toString(Character delimiter);

    @Override
    public int hashCode() {

        return getId() * 31
                + getQuestionText().hashCode() * 31
                + getTopicArea().hashCode() * 31;
    }

    public boolean equals(Object o) {
        if (o instanceof Question) {
            Question q = (Question) o;

            return q.getId() == this.getId()
                    && q.getQuestionText() == this.getQuestionText()
                    && q.getTopicArea() == this.getTopicArea();

        } else {
            return false;
        }
    }
}
