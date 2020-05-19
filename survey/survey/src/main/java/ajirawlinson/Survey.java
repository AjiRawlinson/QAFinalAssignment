package ajirawlinson;


import java.util.ArrayList;

public class Survey {
    private String name;
    private final int QUESTIONS_LIMIT = 10;
    private ArrayList<Question> questions;

    public Survey(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addQuestion(String questionText) {
        if(questions.size() < QUESTIONS_LIMIT) {
            Question question = new Question(questionText);
            questions.add(question);
        }
    }

    public ArrayList<Question> getQuestionList() {
        return questions;
    }

    public Question getQuestionByIndex(int index) {
        return questions.get(index);
    }
}