package ke.co.seatec.fulltestspingboot.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author ASimiyu on 8/27/20 4:55 PM
 * project -> fulltestspingboot
 * package -> ke.co.seatec.fulltestspingboot.jobs
 */
@EnableAsync
public class PrintOutJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrintOutJob.class);

    @Scheduled(fixedRate = 500)
    public void printJob() {
        LOGGER.info("Scheduler Running--->");
    }

    @Async
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException {
        LOGGER.info("Fixed rate task async -{} ", System.currentTimeMillis() / 1000);
        Thread.sleep(2000);
    }
}
