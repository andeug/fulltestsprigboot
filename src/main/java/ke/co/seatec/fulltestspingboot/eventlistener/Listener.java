package ke.co.seatec.fulltestspingboot.eventlistener;

import ke.co.seatec.fulltestspingboot.events.ProductEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Your name on 9/3/20 8:28 PM
 * project -> fulltestspingboot
 * package -> ke.co.seatec.fulltestspingboot.eventlistener
 */
@Component
public class Listener {
    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @EventListener
    public void productCreationListener(ProductEvent event) {
        LOGGER.info("Spring Listener Tutor -> ProductID:{}, ProductDesc:{}, ProductName:{}",
                event.getProductModel().getProductId()
                , event.getProductModel().getProductDesc(), event.getProductModel().getProductName());
    }

}
