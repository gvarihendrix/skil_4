package is.ru.honn.rupin.data;

import is.ru.honn.rupin.domain.User;

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
}
