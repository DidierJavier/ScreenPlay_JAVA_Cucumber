package co.com.sofka.interactions.common.sikulis;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.apache.log4j.Logger;
import org.sikuli.script.Screen;


public class Write implements Interaction {

    private static final Logger LOGGER = Logger.getLogger(Write.class);
    private String path;
    private String text;

    private Write(String path, String text) {
        this.path = path;
        this.text = text;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Screen screen = new Screen();
        try {
            screen.wait(path);
            screen.write(text);
        }catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
            actor.attemptsTo(
                    Ensure.that(e.getMessage()).isNullOrEmpty()
            );
        }

    }

    public static Write writeWithSikulixOn(String path, String text){
        return new Write(path, text);
    }
}
