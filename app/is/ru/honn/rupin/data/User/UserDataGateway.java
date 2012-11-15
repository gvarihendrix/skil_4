package is.ru.honn.rupin.data.User;

import is.ru.honn.rupin.domain.Follow;
import is.ru.honn.rupin.domain.User;

import java.util.List;

/**
 * @author Jóhann
 * @version 1.0, 11.11.2012
 * @since 11.11.2012, 01:21
 */
public interface UserDataGateway {
    public User getUserByID(int id);
    public User getUserByEmail(String username);
    public User authenticate(String email, String password);
    public int addUser(User user);
    public List<User> getUsers();
    public void addFollows(String username, String followUsername);
    public void unFollows(String username, String followUsername);
    public List<Follow> getFollowing(String username);
}
