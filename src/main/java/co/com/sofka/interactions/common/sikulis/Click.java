package co.com.sofka.interactions.common.sikulis;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.apache.log4j.Logger;
import org.sikuli.script.Screen;

public class Click implements Interaction {
    private static final Logger LOGGER = Logger.getLogger(Click.class);
    private String path;

    private Click(String path) {
        this.path = path;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Screen screen = new Screen();
        try {
            screen.wait(path);
            screen.click();
        }catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
            actor.attemptsTo(
                    Ensure.that(e.getMessage()).isNullOrEmpty()
            );
        }

    }

    public static Click clickWithSikulixOn(String path){
        return new Click(path);
    }
}
