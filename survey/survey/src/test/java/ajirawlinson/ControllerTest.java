package ajirawlinson;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

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


    //#####################Survey Method Tests#####################



    
}