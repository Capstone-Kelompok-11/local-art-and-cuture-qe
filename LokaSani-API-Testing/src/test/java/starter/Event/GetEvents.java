package starter.Event;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.is;

public class GetEvents {
    private static String url = "https://lokasani.my.id/";

    //get all events
    @Step("I set API endpoint for get all events is available")
    public String setApiEndpointGetAllEvents() {
        return url + "event";
    }
    @Step("I send a request GET to get all events")
    public void sendGetAllEvent() {
        SerenityRest.given().get(setApiEndpointGetAllEvents());
    }
    @Step("The API should respond with a list of local art culture events")
    public void shouldRespondWithAllistLocalArtEvents() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_EVENTS_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //get detail events by id
    @Step("I set API endpoint for get detail events is available")
    public String setInvalidEndpointForGetDetailvents() {
        return url + "event/2";
    }
    @Step("I send a request GET to get detail events")
    public void sendRequestGETToGetDetailEvents() {
        SerenityRest.given().get(setInvalidEndpointForGetDetailvents());
    }
    @Step("The API should respond with detailed information about the event")
    public void shouldRespondWithDetailedInformationAboutTheEvent() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_DETAIL_EVENTS_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //invalid request get all events
    @Step("I set API invalid endpoint for get all events")
    public String setInvalidApiEndpointGetAllEvents() {
        return url + "eventldk";
    }
    @Step("I send a request GET to get invalid request all events")
    public void sendInvalidGetAllEvent() {
        SerenityRest.given().get(setInvalidApiEndpointGetAllEvents());
    }
    @Step("I should receive a status code of 400")
    public void responseStatusCode400() {
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("The response body should contain an error message")
    public void shouldResponseBodyErrorMessage() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.INVALID_ALL_EVENTS_REQUEST_REQUEST);
        restAssuredThat(response -> response.body("'message'",is("missing or malformed jwt")));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //can not get detail event with invalid or non-existent id
    @Step("I set API endpoint for get detail event with invalid ID")
    public String setAPIEndpointWithInvalidIDGetDetailEvent() {
        return url + "event/209";
    }
    @Step("I send a request GET to get detail event with invalid ID")
    public void sendInvalidIDGetDetailEvent() {
        SerenityRest.given().get(setAPIEndpointWithInvalidIDGetDetailEvent());
    }
    @Step("I should receive a status code of 404 for invalid ID")
    public void responseStatusCode404ForNonExistentID() {
        restAssuredThat(response -> response.statusCode(500));
    }
    @Step("The response body should contain an error message not found")
    public void shouldResponseBodyErrorMessageNotFound() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.INVALID_ID_GET_EVENT_SCHEMA);
        restAssuredThat(response -> response.body("'message'",is("record not found")));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
