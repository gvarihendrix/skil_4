package is.ru.honn.rupin.service;

import is.ru.honn.rupin.data.User.UserDataGateway;
import is.ru.honn.rupin.domain.Follow;
import is.ru.honn.rupin.domain.User;

import java.util.List;

/**
 * @author Jóhann
 * @version 1.0, 11.11.2012
 * @since 11.11.2012, 01:19
 */
public interface UserService {
    public int signup(User user);
    public User login(String username, String password);
    public User getUserByEmail(String email);
    public User authenticate(String email, String password);
    public List<User> getUsers();

    // TODO: Spurning hvort það á að vera sérstakt skilagildi
    public void addFollows(String username, String followUsername);
    public void unFollows(String username, String followUsername);
    public List<Follow> getFollowing(String username);
    public void setUserDataGateway(UserDataGateway userDataGateway);
}
