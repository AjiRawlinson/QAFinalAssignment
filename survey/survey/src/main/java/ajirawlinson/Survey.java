package ajirawlinson;


import java.util.ArrayList;

public class Survey {
    private String name;
    private final int QUESTIONS_LIMIT = 10;
    private ArrayList<Question> questions;
    private ArrayList<SurveyResponse> responses;

    public Survey(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
        this.responses = new ArrayList<>();
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

    public int getNumberOfQuestions() {
        return questions.size();
    }

    public SurveyResponse generateResponse() {
        if(this.getNumberOfQuestions() > 0 ) {
            SurveyResponse response = new SurveyResponse(this.getNumberOfQuestions());
            responses.add(response);
            return response;
        }
        return null;
    }

    public ArrayList<SurveyResponse> getAllResponses() {
        return responses;
    }

    public ArrayList<Integer> getAllResponsesForQuestionByIndex(int index) {
        ArrayList<Integer> resultList = new ArrayList<>();
        for(SurveyResponse r: responses) {
            if(r.getAswersByIndex(index) > 0) {
                resultList.add(r.getAswersByIndex(index));
            }
        }
        return resultList;
    }
}