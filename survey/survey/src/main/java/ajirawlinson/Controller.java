package ajirawlinson;

import java.text.DecimalFormat;
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

    public SurveyResponse createSurveyResponse(Survey survey) {
        SurveyResponse response = survey.generateResponse();
        return response;
    }

    public void addSurveyResponseAnswer(SurveyResponse response, int questionIndex, int answerValue) {
        response.addAnswer(answerValue, questionIndex);
    }

    public ArrayList<SurveyResponse> getAllResponsesForSurvey(Survey survey) {
        return survey.getAllResponses();
    }

    public ArrayList<Integer> getAllResponsesForSurveyQuestion(Survey survey, int index) {
        ArrayList<Integer> results = new ArrayList<>();
        results = survey.getAllResponsesForQuestionByIndex(index);
        return results;
    }

    public double getSurveyAverage(Survey survey) {
        double total = 0, count = 0;
        ArrayList<SurveyResponse> responses = survey.getAllResponses();
        for(SurveyResponse sr: responses) {
            ArrayList<Integer> results = sr.getAllAswers();
            for(int r: results) {
                total += r;
                count++;
            }
        }
        
        if(count > 0) { 
            double average = total / count;
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.parseDouble(df.format(average));
        }
        return 0;
    }

    public double getSurveyStdDeviation(Survey survey) {
        double sumOFDiffSquared = 0.0;
        int count = 0;
        double average = this.getSurveyAverage(survey);
        ArrayList<SurveyResponse> responses = survey.getAllResponses();
        for(SurveyResponse sr: responses) {
            ArrayList<Integer> results = sr.getAllAswers();
            for(int r: results) {
                double diffSquared = Math.pow((r - average), 2);
                sumOFDiffSquared += diffSquared;
                count++;
            }
        }
        if(count > 0) {
            double varience = sumOFDiffSquared / count;
            double stdDeviation = Math.sqrt(varience);
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.parseDouble(df.format(stdDeviation));
        }
        return 0;
    }

    public int getSurveyMinimumScore(Survey survey) {
        int minValue = 9999; //absordely high value
        ArrayList<SurveyResponse> responses = survey.getAllResponses();
        for(SurveyResponse sr: responses) {
            ArrayList<Integer> results = sr.getAllAswers();
            for(int r: results) {
                if (r < minValue) {minValue = r; }
            }
        }
        if(minValue != 9999) { return minValue; }
        return 0;
    }

    public int getSurveyMaximumScore(Survey survey) {
        int maxValue = 0;
        ArrayList<SurveyResponse> responses = survey.getAllResponses();
        for(SurveyResponse sr: responses) {
            ArrayList<Integer> results = sr.getAllAswers();
            for(int r: results) {
                if (r > maxValue) {maxValue = r; }
            }
        } 
        return maxValue; 
    }

    public double getSurveyQuestionAverage(Survey survey, int questionIndex) {
        double total = 0, count = 0;
        ArrayList<Integer> responses = survey.getAllResponsesForQuestionByIndex(questionIndex);
        for(int r: responses) {
            total += r;
            count++;
        }
        if(count > 0) { 
            double average = total / count;
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.parseDouble(df.format(average));
        }
        return 0;      
    }

    public double getSurveyQuestionStdDeviation(Survey survey, int questionIndex) {
        double sumOFDiffSquared = 0.0;
        int count = 0;
        double average = this.getSurveyQuestionAverage(survey, questionIndex);
        ArrayList<Integer> responses = survey.getAllResponsesForQuestionByIndex(questionIndex);
        for(int r: responses) {
            double diffSquared = Math.pow((r - average), 2);
            sumOFDiffSquared += diffSquared;
            count++;
        }
        if(count > 0) {
            double varience = sumOFDiffSquared / count;
            double stdDeviation = Math.sqrt(varience);
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.parseDouble(df.format(stdDeviation));
        }
        return 0;       
    }

    public int getSurveyQuestionMinimumScore(Survey survey, int questionIndex) {
        int minValue = 9999; //absordely high value
        ArrayList<Integer> responses = survey.getAllResponsesForQuestionByIndex(questionIndex);
        for(int r: responses) {
            if (r < minValue) {minValue = r; }
        }
        if(minValue != 9999) { return minValue; }
        return 0;       
    }

    public int getSurveyQuestionMaximumScore(Survey survey, int questionIndex) {
        int maxValue = 0;
        ArrayList<Integer> responses = survey.getAllResponsesForQuestionByIndex(questionIndex);
        for(int r: responses) {
                if (r > maxValue) { maxValue = r; }
        } 
        return maxValue;         
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

        s2.addQuestion("This is the 1st Question of Survey 2");
        s2.addQuestion("This is the 2nd Question of Survey 2");
        s2.addQuestion("This is the 3rd Question of Survey 2");
        s2.addQuestion("This is the 4th Question of Survey 2");
        s2.addQuestion("This is the 5th Question of Survey 2");

        s3.addQuestion("This is the 1st Question of Survey 3");
        s3.addQuestion("This is the 2nd Question of Survey 3");
        s3.addQuestion("This is the 3rd Question of Survey 3");
        s3.addQuestion("This is the 4th Question of Survey 3");
        s3.addQuestion("This is the 5th Question of Survey 3");

        surveys.add(s1);
        surveys.add(s2);
        surveys.add(s3);

        SurveyResponse r1 = s1.generateResponse();
        SurveyResponse r2 = s1.generateResponse();
        SurveyResponse r3 = s1.generateResponse();
        SurveyResponse r4 = s1.generateResponse();
        SurveyResponse r5 = s1.generateResponse();
        SurveyResponse r6 = s1.generateResponse();
        SurveyResponse r7 = s1.generateResponse();

        r1.addAnswer(4, 0); r1.addAnswer(3, 1); r1.addAnswer(1, 2); r1.addAnswer(1, 3); r1.addAnswer(3, 4); 
        r2.addAnswer(2, 0); r2.addAnswer(3, 1); r2.addAnswer(4, 2); r2.addAnswer(1, 3); r2.addAnswer(4, 4); 
        r3.addAnswer(1, 0); r3.addAnswer(3, 1); r3.addAnswer(4, 2); r3.addAnswer(1, 3); r3.addAnswer(5, 4); 
        r4.addAnswer(5, 0); r4.addAnswer(5, 1); r4.addAnswer(2, 2); r4.addAnswer(3, 3); r4.addAnswer(5, 4); 
        r5.addAnswer(2, 0); r5.addAnswer(4, 1); r5.addAnswer(3, 2); r5.addAnswer(2, 3); r5.addAnswer(3, 4); 
        r6.addAnswer(3, 0); r6.addAnswer(2, 1); r6.addAnswer(2, 2); r6.addAnswer(2, 3); r6.addAnswer(4, 4); 
        r7.addAnswer(2, 0); r7.addAnswer(2, 1); r7.addAnswer(3, 2); r7.addAnswer(3, 3); r7.addAnswer(5, 4); 
    }               //4+3+1+1+3[12]  2+3+4+1+4[14]  1+3+4+1+5[14]  5+5+2+3+5[20]  2+4+3+2+3[14]  3+2+2+2+4[13]  2+2+3+3+5[15]

}