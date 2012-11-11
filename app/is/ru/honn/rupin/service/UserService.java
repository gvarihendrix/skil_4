package is.ru.honn.rupin.service;

import is.ru.honn.rupin.data.UserDataGateway;
import is.ru.honn.rupin.domain.User;

/**
 * @author Jóhann
 * @version 1.0, 11.11.2012
 * @since 11.11.2012, 01:19
 */
public interface UserService {
    public int signup(User user);
    public User login(String username, String password);
    public void setUserDataGateway(UserDataGateway userDataGateway);
}
