package ru.partynin.chapter02;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

@EightDigits
public class IssnGenerator implements NumberGenerator {

    @Inject
    private Logger logger;

    public String generateNumber() {
        String issn = "8-" + Math.abs(new Random().nextInt());
        logger.info("Generated ISSN : " + issn);
        return issn;
    }
}
