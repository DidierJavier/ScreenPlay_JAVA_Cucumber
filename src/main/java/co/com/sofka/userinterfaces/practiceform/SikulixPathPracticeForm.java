package co.com.sofka.userinterfaces.practiceform;

import static com.google.common.base.StandardSystemProperty.USER_DIR;

public class SikulixPathPracticeForm {
    private SikulixPathPracticeForm(){

    }

    public static final String ATTACHMENT_FILE_PATH = USER_DIR.value() + "\\src\\test\\resources\\images\\practiceform\\happy.png";
    public static final String PAGE_BASE_PATH = USER_DIR.value() + "\\src\\main\\resources\\page\\practiceForm";
    public static final String SELECT_PICTURE_PATH = PAGE_BASE_PATH + "\\selectPicture.PNG";
    public static final String SELECT_OPEN_PATH = PAGE_BASE_PATH + "\\openWindows.PNG";
    public static final String FILE_NAME_TEXT_BOX_PATH = PAGE_BASE_PATH + "\\fileNameWindows.PNG";
}
