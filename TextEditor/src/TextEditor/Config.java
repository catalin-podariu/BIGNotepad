/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author mrbigheart
 */
public class Config {

    private final Properties properties;
    private InputStream resourceInputStream;
    private FileInputStream userFileInputStream;

    // default properties IDE
    private final String defaultJARSettings = "/Resources/InternalSettings.properties";
    // default properties JAR
    private final String defaultIDESettings = "\\Resources\\InternalSettings.properties";

    // text for "about", "license" and "thanks"
    private final String aboutInfo = "/Resources/AboutInfo.properties";

    // user defined properties stored in installation folder
    //                         TO BE UPDATED 
    private String userDefinedSettings = "C:\\InternalSettings";

    public Config() {
        this.properties = new Properties();
    }

    /**
     * Used to change install path.
     * <br>
     *
     * @param userSettings defines new path for user properties folder
     */
    public Config(String userSettings) {
        this.properties = new Properties();
        this.userDefinedSettings = userSettings;
    }

    /**
     * Load specified settings "type". Options are:<br>
     * <br>
     * WindowSettings (all integers predefined default values) Width = 700px,
     * Height = 500px, X = 200 and Y = 150 on screen, Window title display mode
     * = 0.<br>
     * <br>
     * InternalSettings (all boolean default values "false") Always on top,
     * Minimize to tray, Remember window settings, Remember recent files,
     * Remember recent search / replace, Save settings on exit, Word wrap,
     * Display long line marker, View status bar, View quick menu, View line
     * numbers.<br>
     * <br>
     * RecentFiles (all Strings default values "null") History of the 10 most
     * recent opened files.<br>
     * <br>
     * RecentFind and RecentReplace (all Strings default values "null") History
     * of the 10 most recent searches/replaces.<br>
     * <br>
     *
     * @param type e.g. "WindowSettings"
     * @return actually returns what "loadDefaultSettings" gives it that being
     * an Object array with requested properties.
     */
    public Object[] get(String type) {
        try (FileInputStream is = new FileInputStream(userDefinedSettings)) {
            if (is != null) {
                properties.load(is);
            }
            userFileInputStream = is;
        } catch (FileNotFoundException ex) {
            System.err.println("Config.get: " + ex);
            // FAIL-SAFE - if the settings were not found, copy new defaults
            int status = failSafe();
            if (status == 0) {
                JOptionPane.showConfirmDialog(null,
                        "Your preferences were not found..\n"
                        + "A fresh copy of default settings is now available at\n"
                        + userDefinedSettings, "BIGNotepad message",
                        JOptionPane.PLAIN_MESSAGE);
            } else if (status == -1) {
                JOptionPane.showConfirmDialog(null, ex, "BIGNotepad message",
                        JOptionPane.PLAIN_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(null, ex, "BIGNotepad message",
                    JOptionPane.PLAIN_MESSAGE);
            System.err.println("Config.get: " + ex);
        }

        // safe to call again 'get' recursively
        if (userFileInputStream != null) {
            // call get again to return proper values
            get(type);
        }

        // check to see if any of the properties were loaded
        if (properties.size() != 0) {
            return loadDefaultSettings(type);
        } else {
            JOptionPane.showConfirmDialog(null, "Properties were NOT loaded..",
                    "BIGNotepad message",
                    JOptionPane.PLAIN_MESSAGE);
            return null;
        }

    }

    /**
     * Load default settings.
     * <br>
     *
     * @param type e.g. "WindowSettings"
     * @return an Object array containing requested properties
     */
    private Object[] loadDefaultSettings(String type) {

        Object[] props = null;
        switch (type) {
            case "WindowSettings":
                props = new Integer[6];
                props[0] = Integer.valueOf(properties.getProperty("width"));
                props[1] = Integer.valueOf(properties.getProperty("height"));
                props[2] = Integer.valueOf(properties.getProperty("x"));
                props[3] = Integer.valueOf(properties.getProperty("y"));
                props[4] = Integer.valueOf(properties.getProperty("windowTitleDisplayMode"));
                props[5] = Integer.valueOf(properties.getProperty("zoomFactor"));
                break;
            case "InternalSettings":
                props = new String[11];
                props[0] = properties.getProperty("alwaysOnTop");
                props[1] = properties.getProperty("minimizeToTray");
                props[2] = properties.getProperty("rememeberWinSize");
                props[3] = properties.getProperty("rememberRecentFiles");
                props[4] = properties.getProperty("rememberRecentSearches");
                props[5] = properties.getProperty("saveSettingsOnExit");
                props[6] = properties.getProperty("wordWrap");
                props[7] = properties.getProperty("displayLongLineMarker");
                props[8] = properties.getProperty("displayStatusBar");
                props[9] = properties.getProperty("displayQuickMenu");
                props[10] = properties.getProperty("displayLineNumbers");
                break;
            case "RecentFiles":
                props = new Object[10];
                props[0] = properties.getProperty("file1");
                props[1] = properties.getProperty("file2");
                props[2] = properties.getProperty("file3");
                props[3] = properties.getProperty("file4");
                props[4] = properties.getProperty("file5");
                props[5] = properties.getProperty("file6");
                props[6] = properties.getProperty("file7");
                props[7] = properties.getProperty("file8");
                props[8] = properties.getProperty("file9");
                props[9] = properties.getProperty("file10");
                break;
            case "RecentFind":
                props = new String[10];
                props[0] = properties.getProperty("find1");
                props[1] = properties.getProperty("find2");
                props[2] = properties.getProperty("find3");
                props[3] = properties.getProperty("find4");
                props[4] = properties.getProperty("find5");
                props[5] = properties.getProperty("find6");
                props[6] = properties.getProperty("find7");
                props[7] = properties.getProperty("find8");
                props[8] = properties.getProperty("find9");
                props[9] = properties.getProperty("find10");
                break;
            case "RecentReplace":
                props = new String[10];
                props[0] = properties.getProperty("replace1");
                props[1] = properties.getProperty("replace2");
                props[2] = properties.getProperty("replace3");
                props[3] = properties.getProperty("replace4");
                props[4] = properties.getProperty("replace5");
                props[5] = properties.getProperty("replace6");
                props[6] = properties.getProperty("replace7");
                props[7] = properties.getProperty("replace8");
                props[8] = properties.getProperty("replace9");
                props[9] = properties.getProperty("replace10");
                break;
        }
        return props;

    }

    /**
     * Set all properties. Called when "Save settings now" or "Save settings on
     * exit" is selected.<br>
     * <br>
     *
     * @param props an array of Strings (settings) to store
     * @param mode history or internal settings. These two had to be separated
     * because internal settings come with predefined key and value, but history
     * only has value and the key is "file0" incremented by the number of items.
     * @return 0 for OK, 1 for failure and -1 for IOException
     */
    public int set(String[] props, String mode) {
        try {
            userFileInputStream = new FileInputStream(userDefinedSettings);
            if (userFileInputStream != null) {
                properties.load(userFileInputStream);
            }
            userFileInputStream.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Config.set: " + ex);
            failSafe();
        } catch (IOException ex) {
            System.err.println("Config.set: " + ex);
        }

        // fail-safe in the situation when settings were placed at first
        // but were deleted in the mean-time.
        if (userFileInputStream == null | properties.size() == 0) {
            // if user settings not present place a fresh copy from default
            failSafe();
        } else {
            File file = new File(userDefinedSettings);
            try (FileOutputStream newProperties = new FileOutputStream(file)) {
                switch (mode) {
                    // mainstream - internal settings and window settings
                    case "settings":
                        for (int i = 0; i < props.length; i++) {
                            if (props[i] != null) {
                                properties.setProperty(props[i], props[++i]);
                            }
                        }
                        break;
                    case "recentFiles":
                        for (int i = 1; i < props.length; i++) {
                            if (props[i] != null) {
                                properties.setProperty("file" + i, props[i]);
                            }
                        }
                        break;
                    case "recentFind":
                        for (int i = 1; i < props.length; i++) {
                            if (props[i] != null) {
                                properties.setProperty("find" + i, props[i]);
                            }
                        }
                        break;
                    case "recentReplace":
                        for (int i = 1; i < props.length; i++) {
                            if (props[i] != null) {
                                properties.setProperty("replace" + i, props[i]);
                            }
                        }
                        break;
                }
                properties.store(newProperties,
                        "BIG Notepad stores here ALL internal settings");
            } catch (FileNotFoundException ex) {
                System.err.println("Config.set: " + ex);
                return 1;
            } catch (IOException ex) {
                System.err.println("Config.set: " + ex);
                return -1;
            }
        }
        return 0;
    }

    /**
     * Fail safe.<br>
     * <br>
     * If user settings not present place a fresh copy from default. Default
     * properties are stored in main JAR.<br>
     * <br>
     *
     * @return 0 for OK and -1 for IOException.
     */
    public int failSafe() {

        File file;
        URL JARres = getClass().getResource(defaultJARSettings);
        if (JARres.toString().startsWith("jar:")) {
            try {
                resourceInputStream = getClass().getResourceAsStream(defaultJARSettings);
                file = File.createTempFile(userDefinedSettings, ".properties");
                OutputStream out = new FileOutputStream(file);
                int read;
                byte[] bytes = new byte[1024];

                while ((read = resourceInputStream.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                return 0;
            } catch (IOException ex) {
                System.err.println("Config failSafe: " + ex);
                return -1;
            }
        } else {
            //this will probably work in your IDE, but not from a JAR
            Path source = new File(defaultIDESettings + ".properties").toPath();
            Path target = new File(userDefinedSettings + ".properties").toPath();
            try {
                // we'll replace existing in case it is there, but empty.
                Files.copy(source, target, REPLACE_EXISTING);
                return 0;
            } catch (IOException ex) {
                System.err.println("Config failSafe: " + ex);
                return -1;
            }
        }
    }

    /**
     * About author and software.<br>
     * <br>
     * Takes everything from AboutInfo.properties, placed in main JAR.
     *
     * @return an array, containing 2 Strings: aboutAuthor and aboutSoftware.
     */
    public String[] getInfo() {
        try {
            resourceInputStream = getClass().getClassLoader()
                    .getResourceAsStream(aboutInfo);
            if (resourceInputStream != null) {
                properties.load(resourceInputStream);
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
        String[] props = new String[3];

        props[0] = properties.getProperty("aboutAuthor");
        props[1] = properties.getProperty("aboutSoftware");
        props[2] = properties.getProperty("thanks");

        return props;
    }
}
