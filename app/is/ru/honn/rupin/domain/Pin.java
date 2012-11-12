package is.ru.honn.rupin.domain;

import play.data.format.Formats;
import play.data.validation.Constraints;

import java.util.Date;

/**
 * @author Jóhann
 * @version 1.0, 12.11.2012
 * @since 12.11.2012, 02:07
 */
public class Pin extends PinObject {

    @Constraints.Required
    @Formats.NonEmpty
    protected Integer boardId;

    @Constraints.Required
    @Formats.NonEmpty
    protected String description;

    @Constraints.Required
    @Formats.NonEmpty
    protected String link;

    @Constraints.Required
    @Formats.NonEmpty
    protected String image;

    public Pin() {
    }

    public Pin(Integer boardId, String description, String link, String image) {
        this.boardId = boardId;
        this.description = description;
        this.link = link;
        this.image = image;
    }

    public Pin(int id, String creator, Date created, Integer boardId, String description, String link, String image) {
        super(id, creator, created);
        this.boardId = boardId;
        this.description = description;
        this.link = link;
        this.image = image;
    }

    public Pin(int id, Integer boardId, String description, String link, String image) {
        super(id);
        this.boardId = boardId;
        this.description = description;
        this.link = link;
        this.image = image;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
