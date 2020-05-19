package ajirawlinson;


import java.util.ArrayList;

public class Survey {
    private String name;
    private ArrayList<Question> questions;

    public Survey(String name) {
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addQuestion(String questionText) {
        Question question = new Question(questionText);
        questions.add(question);
    }

    public Question getQuestionByIndex(int index) {
        return questions.get(index);
    }
}