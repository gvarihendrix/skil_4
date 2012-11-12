package is.ru.honn.rupin.domain;

import play.data.format.Formats;
import play.data.validation.Constraints;

import java.util.Date;

/**
 * @author Jóhann
 * @version 1.0, 11.11.2012
 * @since 11.11.2012, 23:05
 */
public class Board extends PinObject {

    @Constraints.Required
    @Formats.NonEmpty
    protected String name;

    @Constraints.Required
    @Formats.NonEmpty
    protected String category;

    public Board() {
    }

    public Board(int id, String name, String category) {
        super(id);
        this.name = name;
        this.category = category;
    }

    public Board(int id, String creator, Date created, String name, String category) {
        super(id, creator, created);
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
