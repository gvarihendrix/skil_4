package is.ru.honn.rupin.service;

import is.ru.honn.rupin.data.User.UserDataGateway;
import is.ru.honn.rupin.domain.Follow;
import is.ru.honn.rupin.domain.User;

import java.util.List;

/**
 * @author Jóhann
 * @version 1.0, 11.11.2012
 * @since 11.11.2012, 01:50
 */
public class UserServiceData implements UserService {
    UserDataGateway userDataGateway;
    @Override
    public int signup(User user) {
        return this.userDataGateway.addUser(user);
    }

    @Override
    public User login(String username, String password) {
        return this.userDataGateway.authenticate(username,password);
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userDataGateway.getUserByEmail(email);
    }

    @Override
    public User authenticate(String email, String password) {
        return this.userDataGateway.authenticate(email, password);
    }

    @Override
    public List<User> getUsers() {
        return this.userDataGateway.getUsers();
    }

    @Override
    public void addFollows(String username, String followUsername) {
        this.userDataGateway.addFollows(username, followUsername);
    }

    @Override
    public void unFollows(String username, String followUsername) {
        this.userDataGateway.unFollows(username, followUsername);
    }

    @Override
    public List<Follow> getFollowing(String username) {
        return this.userDataGateway.getFollowing(username);
    }

    @Override
    public void setUserDataGateway(UserDataGateway userDataGateway) {
        this.userDataGateway = userDataGateway;
    }
}
