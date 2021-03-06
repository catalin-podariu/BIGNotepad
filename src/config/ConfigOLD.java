package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

import gui.BIGNotepad;

/**
 *
 * @author catalin.podariu[at]gmail.com
 */
public class ConfigOLD {

	private String defaultSettings;
	private String aboutInfo;

	private String userDefinedSettings;

	private Properties properties;
	
	public ConfigOLD(String userDefinedSettings) {
		this.properties = new Properties();
		this.userDefinedSettings = userDefinedSettings;
		this.defaultSettings = "/Resources/InternalSettings.properties";
		this.aboutInfo = "/Resources/AboutInfo.properties";
	}

	protected Object[] get(String type) {
		File file = new File(userDefinedSettings);
		if (file.exists()) {
			try (FileInputStream fileInput = new FileInputStream(userDefinedSettings)) {
				if (fileInput != null) {
					properties.load(fileInput);
				}
				if (properties.size() == 0) {
					int status = failSafe();
					if (status == -1) {
						JOptionPane.showConfirmDialog(null, //
								"Properties were NOT loaded..", "BIGNotepad message", //
								JOptionPane.PLAIN_MESSAGE);
					}
					get(type);
				}

			} catch (IOException ex) {
				System.err.println(ex);
			}
			// file turns out it wasn't present
		} else {
			// FAIL-SAFE - if the settings were not found, copy new defaults
			int status = failSafe();
			// return 0 means new properties file was copied successfully
			if (status == -1) {
				JOptionPane.showConfirmDialog(null, "Properties were NOT loaded..", "BIGNotepad message",
						JOptionPane.PLAIN_MESSAGE);
			}
			// call get again to return proper values
			get(type);
		}

		// check to see if any of the properties were loaded
		if (properties.size() != 0) {
			Object[] status = getDefaultSettings(type);
			if (status != null) {
				// return requested properties
				return status;
			}
		} else {
			// JOptionPane.showConfirmDialog(null,
			// "Properties were NOT loaded..",
			// "BIGNotepad message",
			// JOptionPane.PLAIN_MESSAGE);
			int status = failSafe();
			// return 0 means new properties file was copied successfully
			if (status == -1) {
				// JOptionPane.showConfirmDialog(null,
				// "Properties were NOT loaded..",
				// "BIGNotepad message",
				// JOptionPane.PLAIN_MESSAGE);
			}
		}
		return null;
	}

	private ConfigInternalSettings config = new ConfigInternalSettings(new BIGNotepad());
	private Object[] getDefaultSettings(String type) {
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
			config.setAlwaysOnTop(Boolean.valueOf(properties.getProperty("alwaysOnTop")));
			config.setMinimizedToTray(Boolean.valueOf(properties.getProperty("minimizeToTray")));
			config.setRememeberWinSize(Boolean.valueOf(properties.getProperty("rememeberWinSize")));
			config.setRememberRecentFiles(Boolean.valueOf(properties.getProperty("rememberRecentFiles")));
			config.setRememberRecentSearches(Boolean.valueOf(properties.getProperty("rememberRecentSearches")));
			config.setSaveSettingsOnExit(Boolean.valueOf(properties.getProperty("saveSettingsOnExit")));
			config.setWordWrapActive(Boolean.valueOf(properties.getProperty("wordWrap")));
			config.setDisplaysLongLineMarker(Boolean.valueOf(properties.getProperty("displayLongLineMarker")));
			config.setDisplaysStatusBar(Boolean.valueOf(properties.getProperty("displayStatusBar")));
			config.setDisplaysQuickMenu(Boolean.valueOf(properties.getProperty("displayQuickMenu")));
			config.setDisplaysLineNumbers(Boolean.valueOf(properties.getProperty("displayLineNumbers")));
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
		}
		return props;
	}

	/**
	 * Set all properties. Called when "Save settings now" or "Save settings on
	 * exit" is selected.<br>
	 * <br>
	 *
	 * @param props
	 *            an array of Strings (settings) to store
	 * @param mode
	 *            history or internal settings. These two had to be separated
	 *            because internal settings come with predefined key and value,
	 *            but history only has value and the key is "file0" incremented
	 *            by the number of items.
	 * @return 0 for OK, 1 for failure and -1 for IOException
	 */
	public int set(String[] props, String mode) {

		// load userDefinedSettings to FileInputStream
		try (FileInputStream fileInput = new FileInputStream(userDefinedSettings)) {
			if (fileInput != null) {
				properties.load(fileInput);
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}

		// fail-safe in the situation when settings were placed at first
		// but were deleted in the mean-time.
		if (properties.size() == 0) {
			// if user settings not present place a fresh copy from default
			failSafe();
		} else {
			File userSettings = new File(userDefinedSettings);
			try (FileOutputStream newProperties = new FileOutputStream(userSettings)) {
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
					propSetter(props, "recentFiles");
					break;
				case "recentFind":
					propSetter(props, "find");
					break;
				case "recentReplace":
					propSetter(props, "replace");
					break;
				}
				properties.store(newProperties, "BIG Notepad stores here all internal settings");
				return 0;
			} catch (IOException ex) {
				// feedback to the user
				JOptionPane.showConfirmDialog(null, ex, "BIGNotepad message", JOptionPane.PLAIN_MESSAGE);
				System.err.println("Config.set: " + ex);
				return -1;
			}
		}
		return -1;
	}

	/**
	 * Just so I don't repeat this for loop 4 times.
	 *
	 * @param props
	 *            String array, basically the settings.
	 * @param mode
	 *            property key value.
	 */
	private void propSetter(String[] props, String mode) {
		for (int i = 1; i < props.length; i++) {
			if (props[i] != null) {
				properties.setProperty(mode + i, props[i]);
			}
		}
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
		File userSettings = new File(userDefinedSettings);
		try (InputStream inputStream = getClass().getResourceAsStream(defaultSettings);
				FileOutputStream outputStream = new FileOutputStream(userSettings)) {
			if (inputStream == null) {
				JOptionPane.showConfirmDialog(null, defaultSettings //
						+ "\ninputStream == null", "BIGNotepad message", JOptionPane.PLAIN_MESSAGE);
				return -1;
			}
			byte[] buffer = new byte[inputStream.available()];
			inputStream.read(buffer);
			outputStream.write(buffer);
			JOptionPane.showConfirmDialog(null,
					"Your preferences were not found..\n" + "A fresh copy of default settings is now available at\n" //
							+ userDefinedSettings,
					"BIGNotepad message", JOptionPane.PLAIN_MESSAGE);
			return 0;
		} catch (IOException ex) {
			// feedback to the user
			JOptionPane.showConfirmDialog(null, ex, "BIGNotepad message", JOptionPane.PLAIN_MESSAGE);
			System.err.println("Config.set: " + ex);
			return -1;
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
		try (InputStream inputStream = getClass().getResourceAsStream(aboutInfo)) {
			if (inputStream != null) {
				properties.load(inputStream);
			} else {
				// feedback to the user
				JOptionPane.showConfirmDialog(null, "Author detailes were not found..", "BIGNotepad message",
						JOptionPane.PLAIN_MESSAGE);
				return null;
			}
		} catch (FileNotFoundException ex) {
			System.err.println("Config.get: " + ex);
		} catch (IOException ex) {
			System.err.println("Config.get: " + ex);
		}

		String[] props = new String[3];
		props[0] = properties.getProperty("aboutAuthor");
		props[1] = properties.getProperty("aboutSoftware");
		props[2] = properties.getProperty("thanks");

		return props;
	}

}
