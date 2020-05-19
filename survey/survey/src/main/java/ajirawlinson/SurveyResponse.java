package ajirawlinson;


import java.util.ArrayList;

public class SurveyResponse {
    public Survey survey;
    public ArrayList<Integer> answers;

    public SurveyResponse(Survey survey) {
        this.survey = survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Survey getSurvey() {
        return this.survey;
    }

    public void addAnswer(int answer) {
        answers.add(answer);
    }

    public ArrayList<Integer> getAllAswers() {
        return this.answers;
    }

    public int getAswersByIndex(int index) {
        return this.answers.get(index);
    }
}