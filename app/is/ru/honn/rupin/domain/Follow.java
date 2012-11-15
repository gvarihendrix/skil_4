package is.ru.honn.rupin.domain;

/**
 * @author Jóhann
 * @version 1.0, 15.11.2012
 * @since 15.11.2012, 00:51
 */
public class Follow {
    public String username;
    public String follow;

    public Follow(String username, String follow) {
        this.username = username;
        this.follow = follow;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFollow() {
        return follow;
    }

    public void setFollow(String follow) {
        this.follow = follow;
    }
}
