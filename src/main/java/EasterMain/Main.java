package EasterMain;

import org.apache.logging.log4j.*;
import java.util.UUID;

public class Main {

    private static Logger logger = LogManager.getLogger();
    private static final Marker QUESTION_MARKER =
            MarkerManager.getMarker("QUESTION");
    private static final Marker STATEMENT_MARKER =
            MarkerManager.getMarker("STATEMENT");

    public static void main(String[] args) {

        int number = 2;

        String[] vers = {"Zöld erdőben jártam,",
                "Kék ibolyát láttam.",
                "El akart hervadni,",
                "Szabad-e locsolni?"};

        //logger.traceEntry();
        int count = 0;
        while(count < number) {
            ThreadContext.push(UUID.randomUUID().toString());
            logger.debug("Message");
            for (int i = 0; i < vers.length; i++) {
                String line = vers[i];
                if (line.endsWith("?"))
                    logger.debug(QUESTION_MARKER, line, vers[i]);
                else if (line.endsWith("."))
                    logger.debug(STATEMENT_MARKER, line, vers[i]);
                else
                    logger.debug(line, vers[i]);
            }
            count++;
        }

        //logger.traceExit();
    }
}