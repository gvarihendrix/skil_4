package is.ru.honn.rupin.domain;

import java.util.Date;

/**
 * @author Jóhann
 * @version 1.0, 12.11.2012
 * @since 12.11.2012, 00:33
 */
public class PinObject {

    protected int id;
    protected String creator;
    protected Date created;

    public PinObject() {
    }

    public PinObject(int id, String creator, Date created) {
        this.id = id;
        this.creator = creator;
        this.created = created;
    }

    public PinObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
