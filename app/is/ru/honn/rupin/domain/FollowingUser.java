package is.ru.honn.rupin.domain;

import is.ru.honn.rupin.domain.User;

/**
 * @author Jóhann
 * @version 1.0, 15.11.2012
 * @since 15.11.2012, 01:15
 */
public class FollowingUser extends User {
    protected Follow follow;

    public FollowingUser(String email, String fullname, String password, Follow follow) {
        super(email, fullname, password);
        this.follow = follow;
    }

    public Follow getFollow() {
        return follow;
    }

    public void setFollow(Follow follow) {
        this.follow = follow;
    }
}
