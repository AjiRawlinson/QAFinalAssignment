package ajirawlinson;

import java.util.ArrayList;

public class Controller {

    ArrayList<Survey> surveys;

    public Controller() {
        this.surveys = new ArrayList<>();
    }

    public Survey createSurvey(String name) {
        Survey survey = new Survey(name);
        surveys.add(survey);
        return survey;
    }

    public void addQuestionToSurvey(String questionText, Survey survey) {
        survey.addQuestion(questionText);
    }

    public ArrayList<Survey> getAllSurveys() {
        return surveys;
    }

    public Survey getSurveyByName(String name) {
        for(Survey s: surveys) {
            if(s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public void createSurveyResponse() {
        //TODO
    }

    public void addSurveyResponseAnswer() {
        //TODO
    }

    public void getAllResponsesForSurvey(Survey survey) {
        //TODO
    }

    public double getSurveyAverage(Survey survey) {
        //TODO
        return 0;
    }

    public double getSurveyStdDeviation(Survey survey) {
        //TODO
        return 0;
    }

    public double getSurveyMinimumScore(Survey survey) {
        //TODO
        return 0;
    }

    public double getSurveyMaximumScore(Survey survey) {
        //TODO
        return 0;
    }

    public double getSurveyQuestionAverage(Survey survey) {
        //TODO
        return 0;       
    }

    public double getSurveyQuestionStdDeviation(Survey survey) {
        //TODO
        return 0;        
    }

    public double getSurveyQuestionMinimumScore(Survey survey) {
        //TODO
        return 0;        
    }

    public double getSurveyQuestionMaximumScore(Survey survey) {
        //TODO
        return 0;        
    }

    //********************Mocked Data********************
    public void generateMockedData() {
        Survey s1 = new Survey("Survey 1");
        Survey s2 = new Survey("Survey 2");
        Survey s3 = new Survey("Survey 3");
    
        s1.addQuestion("This is the 1st Question of Survey 1");
        s1.addQuestion("This is the 2nd Question of Survey 1");
        s1.addQuestion("This is the 3rd Question of Survey 1");
        s1.addQuestion("This is the 4th Question of Survey 1");
        s1.addQuestion("This is the 5th Question of Survey 1");
        s1.addQuestion("This is the 6th Question of Survey 1");

        s2.addQuestion("This is the 1st Question of Survey 2");
        s2.addQuestion("This is the 2nd Question of Survey 2");
        s2.addQuestion("This is the 3rd Question of Survey 2");
        s2.addQuestion("This is the 4th Question of Survey 2");
        s2.addQuestion("This is the 5th Question of Survey 2");
        s2.addQuestion("This is the 5th Question of Survey 2");

        s3.addQuestion("This is the 1st Question of Survey 3");
        s3.addQuestion("This is the 2nd Question of Survey 3");
        s3.addQuestion("This is the 3rd Question of Survey 3");
        s3.addQuestion("This is the 4th Question of Survey 3");
        s3.addQuestion("This is the 5th Question of Survey 3");
        s3.addQuestion("This is the 6th Question of Survey 3");

        surveys.add(s1);
        surveys.add(s2);
        surveys.add(s3);
    }

}