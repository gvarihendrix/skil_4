package is.ru.honn.rupin.service;

import is.ru.honn.rupin.data.Pin.PinDataGateway;
import is.ru.honn.rupin.domain.Pin;

/**
 * @author Jóhann
 * @version 1.0, 12.11.2012
 * @since 12.11.2012, 16:43
 */
public class PinServiceData implements PinService {
    PinDataGateway pinDataGateway;
    @Override
    public int add(Pin pin) {
        return this.pinDataGateway.addPin(pin);
    }

    @Override
    public void setPinDataGateway(PinDataGateway pinDataGateway) {
        this.pinDataGateway = pinDataGateway;
    }
}
