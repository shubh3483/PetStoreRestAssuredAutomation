package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTests {

    @Test (priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testPostUser(String id, String username, String firstname, String lastname, String email,
                             String password, String phone) {
        User user = new User();

        user.setId(Integer.parseInt(id));
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setPhone(phone);

        Response response = UserEndPoints.createUser(user);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test (priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
    public void testDeleteUserByUsername(String username) {
        Response response = UserEndPoints.deleteUser(username);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
