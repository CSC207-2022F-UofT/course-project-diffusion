package user_login.use_case.input;

import user_login.use_case.output.UserloginOutputData;

public interface UserloginInputBoundary {
    UserloginOutputData createInputObject(UserLoginInputData userloginInputData);
}
