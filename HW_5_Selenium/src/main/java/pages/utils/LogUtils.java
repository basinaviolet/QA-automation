package pages.utils;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.slf4j.Logger;

import java.util.Date;

public class LogUtils {

    public static void printLog(Logger logger, LogEntries entries) {
        logger.info("{} log entries found", entries.getAll().size());
        for (LogEntry entry : entries) {
            logger.info("{} {} {}",
                    new Date(entry.getTimestamp()), entry.getLevel(), entry.getMessage()
            );
        }
    }

}
