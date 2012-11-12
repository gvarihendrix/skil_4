package is.ru.honn.rupin.data.Pin;

import is.ru.honn.rupin.domain.Pin;
import is.ruframework.data.RuData;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jóhann
 * @version 1.0, 12.11.2012
 * @since 12.11.2012, 16:38
 */
public class PinData extends RuData implements PinDataGateway {
    @Override
    public int addPin(Pin pin) {
        SimpleJdbcInsert insertContent =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName("ru_Pins")
                        .usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<String, Object>(6);
        parameters.put("creator", pin.getCreator());
        parameters.put("created", pin.getCreated());
        parameters.put("description", pin.getDescription());
        parameters.put("link", pin.getLink());
        parameters.put("image", pin.getImage());
        parameters.put("board_id", pin.getBoardId());
        return insertContent.executeAndReturnKey(parameters).intValue();
    }
}
