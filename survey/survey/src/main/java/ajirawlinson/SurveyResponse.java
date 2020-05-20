package ajirawlinson;


import java.util.ArrayList;

public class SurveyResponse {
    // public Survey survey;
    public ArrayList<Integer> answers;
    public final int ANSWER_MIN = 0, ANSWER_MAX = 5;

    public SurveyResponse(int numOfQuestions) {
        // this.survey = survey;
        this.answers = new ArrayList<>();
        for(int i = 0; i < numOfQuestions; i++) { answers.add(0); }
    }

    public void addAnswer(int answer, int index) {
        if(answer >= ANSWER_MIN  && answer <= ANSWER_MAX) {
            answers.set(index, answer);
        }
    }

    public ArrayList<Integer> getAllAswers() {
        return this.answers;
    }

    public int getAswersByIndex(int index) {
        return this.answers.get(index);
    }
}