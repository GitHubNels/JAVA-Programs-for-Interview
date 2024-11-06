import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.get;
import org.junit.Test;

public class SchemaValidationTest {
    @Test
    public void validateJsonSchema() {
        get("/events?id=390").then().assertThat()
            .body(matchesJsonSchemaInClasspath("event_0.json"));
    }
}

//The below needed dependencies required

/* <dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>json-schema-validator</artifactId>
    <version>5.5.0</version>
    <scope>test</scope>
</dependency>


Json.schema
——————

{
    "id": "390",
    "data": {
        "leagueId": 35,
        "homeTeam": "Norway",
        "visitingTeam": "England"
    },
    "odds": [
        {"price": "1.30", "name": "1"},
        {"price": "5.25", "name": "X"}
    ]
}
*/
