package user_login.interface_adapters;

import user_login.use_case.output.UserloginOutputData;

public interface UserLoginPresenterOutputBoundary {
    UserloginOutputData presenterOutput(UserloginOutputData userloginOutputData);
}
