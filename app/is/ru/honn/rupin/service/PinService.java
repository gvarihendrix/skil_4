package is.ru.honn.rupin.service;

import is.ru.honn.rupin.data.Board.BoardDataGateway;
import is.ru.honn.rupin.data.Pin.PinDataGateway;
import is.ru.honn.rupin.domain.Pin;

/**
 * @author Jóhann
 * @version 1.0, 12.11.2012
 * @since 12.11.2012, 16:42
 */
public interface PinService {
    public int add(Pin pin);
    public void setPinDataGateway(PinDataGateway pinDataGateway);
}
