package Tests_Update;

import modules.service.UsersService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.update.user.UpdateUserProfileRequestBody;
import pojo.update.user.UpdateUserProfileResponse;

public class UpdateUserProfileTest {
    UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldEditUserProfile() {
        UpdateUserProfileRequestBody updateUserProfileRequestBody = new UpdateUserProfileRequestBody.Builder().build();
        UpdateUserProfileResponse updateUserProfileResponse = usersService.updateUserDetails(updateUserProfileRequestBody);
        updateUserProfileResponse.assertEditUserProfile(updateUserProfileRequestBody);
    }

}
