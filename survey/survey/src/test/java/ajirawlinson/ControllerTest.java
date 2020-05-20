package ajirawlinson;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import java.util.ArrayList;

public class ControllerTest {

    Controller controller;
    
    //#####################Survey Method Tests#####################

    //************************Create Survey************************

    @Test
    public void createSurveyTest() {
        controller = new Controller();
        Survey survey = controller.createSurvey("Survey Name");
        assertNotEquals(null, survey);
    }

    @Test
    public void createSurveyNameTest() {
        controller = new Controller();
        Survey survey = controller.createSurvey("Survey Name");
        assertEquals("Survey Name", survey.getName());
    }

    //************************Add Question to Survey************************

    @Test
    public void addNoQuestionToSurveyTest() {
        controller = new Controller();
        Survey survey = controller.createSurvey("Survey Name");
        assertEquals(true, survey.getQuestionList().isEmpty());
    }

    @Test
    public void addOneQuestionToSurveyTest() {
        controller = new Controller();
        Survey survey = controller.createSurvey("Survey Name");
        controller.addQuestionToSurvey("Question 1:", survey);
        assertEquals("Question 1:", survey.getQuestionByIndex(0).getText());
    }

    @Test
    public void addThreeQuestionToSurveyTest() {
        controller = new Controller();
        Survey survey = controller.createSurvey("Survey Name");
        controller.addQuestionToSurvey("Question 1:", survey);
        controller.addQuestionToSurvey("Question 2:", survey);
        controller.addQuestionToSurvey("Question 3:", survey);
        assertEquals("Question 3:", survey.getQuestionByIndex(2).getText());
    }

    @Test
    public void addMoreThan10QuestionToSurveyTest() {
        controller = new Controller();
        Survey survey = controller.createSurvey("Survey Name");
        for(int i = 0; i < 15; i++) {
            controller.addQuestionToSurvey("Question " + i + ":", survey);
        }
        assertEquals(10, survey.getQuestionList().size());
    }

    //************************Get All Surveys************************

    @Test
    public void getAllSurveysTest() {
        controller = new Controller();
        controller.generateMockedData();
        ArrayList<Survey> surveys = controller.getAllSurveys();
        assertNotEquals(0, surveys.size());
    }

    @Test
    public void getAllSurveysCheckLastTest() {
        controller = new Controller();
        controller.generateMockedData();
        controller.createSurvey("Last Survey Name");
        ArrayList<Survey> surveys = controller.getAllSurveys();
        assertEquals("Last Survey Name", surveys.get(surveys.size()-1).getName());
    }

    //************************Get Survey By Name************************

    @Test
    public void searchSurveyByNameEmptyString() {
        controller = new Controller();
        controller.generateMockedData();
        Survey survey = controller.getSurveyByName("");
        assertEquals(null, survey);
    }

    @Test
    public void searchSurveyByNameWrongSpelling() {
        controller = new Controller();
        controller.generateMockedData();
        Survey survey = controller.getSurveyByName("Wrong Survey Name");
        assertEquals(null, survey);
    }

    @Test
    public void searchSurveyByNameWrongCapitalization() {
        controller = new Controller();
        controller.generateMockedData();
        controller.createSurvey("Last Survey Name");
        Survey survey = controller.getSurveyByName("lAsT sUrVeY nAmE");
        assertEquals("Last Survey Name", survey.getName());
    }


    //#####################Survey Responses Method Tests#####################

    //************************Get Survey Response************************

    @Test
    public void createResponseTest() {
        controller = new Controller();
        Survey survey = controller.createSurvey("Survey Name");
        SurveyResponse response = controller.createSurveyResponse(survey);
        assertNotEquals(null, response);
    }

    //************************Response Answer Questions************************
    @Test
    public void createResponseAnswerOneQuestionTest() {
        controller = new Controller();
        Survey survey = controller.createSurvey("Survey Name");
        survey.addQuestion("Question 1: ");
        SurveyResponse response = controller.createSurveyResponse(survey);
        controller.addSurveyResponseAnswer(response, 0, 4);
        assertEquals(4, response.getAswersByIndex(0));
    }

    @Test
    public void createResponseAnswerMultiQuestionsTest() {
        controller = new Controller();
        Survey survey = controller.createSurvey("Survey Name");
        survey.addQuestion("Question 1: ");
        survey.addQuestion("Question 2: ");
        survey.addQuestion("Question 3: ");
        SurveyResponse response = controller.createSurveyResponse(survey);
        controller.addSurveyResponseAnswer(response, 0, 4);
        controller.addSurveyResponseAnswer(response, 1, 5);
        controller.addSurveyResponseAnswer(response, 2, 1);
        assertEquals(4, response.getAswersByIndex(0));
        assertEquals(5, response.getAswersByIndex(1));
        assertEquals(1, response.getAswersByIndex(2));
    }

    @Test
    public void createResponseAnswerOutsideParamsTest() {
        controller = new Controller();
        Survey survey = controller.createSurvey("Survey Name");
        survey.addQuestion("Question 1: ");
        SurveyResponse response = controller.createSurveyResponse(survey);
        controller.addSurveyResponseAnswer(response, 0, 7);
        assertEquals(-1, response.getAswersByIndex(0));
    }

    //************************Get Response Answers************************

    @Test
    public void getAllResponsesToSurveyTest() {
        controller = new Controller();
        controller.generateMockedData();
        Survey survey = controller.getSurveyByName("Survey 1");
        ArrayList<SurveyResponse> responses = controller.getAllResponsesForSurvey(survey);
        SurveyResponse r1 = responses.get(0);
        SurveyResponse r2 = responses.get(1);
        SurveyResponse r3 = responses.get(2);

        assertEquals(3, r1.getAswersByIndex(1));//data taken from mockdata generated in Controller class
        assertEquals(4, r2.getAswersByIndex(2));
        assertEquals(1, r3.getAswersByIndex(3));
    }

    //************************Get Response Answers to Particular Question************************

    @Test
    public void getAllResponsesToSurveyQuestionTest() {
        controller = new Controller();
        controller.generateMockedData();
        Survey survey = controller.getSurveyByName("Survey 1");
        ArrayList<Integer> results = controller.getAllResponsesForSurveyQuestion(survey, 0);//mock data is 4, 2, 1, 5, 2, 3, 2.
        int q1 = results.get(0);
        int q2 = results.get(1);
        int q3 = results.get(2);

        assertEquals(4, q1);
        assertEquals(2, q2);
        assertEquals(1, q3);
    }

    @Test
    public void getAllResponsesToSurveyQuestionNoQuestionsTest() {
        controller = new Controller();
        controller.generateMockedData();
        Survey survey = controller.getSurveyByName("Survey 2");//no qustions set up for Survey 2
        ArrayList<Integer> results = controller.getAllResponsesForSurveyQuestion(survey, 0);//mock data is 4, 2, 1, 5, 2, 3, 2.

        assertEquals(0, results.size());
    }





    //#####################Survey Method Tests#####################



    
}