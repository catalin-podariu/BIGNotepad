package config;

import java.util.Properties;

import gui.BIGNotepad;

public class ConfigHandler {
	
	private ConfigHandler(BIGNotepad notepad){
		this.notepad = notepad;
		
		this.properties = new Properties();
	}
	
	public static ConfigHandler valueOf(BIGNotepad notepad){
		return new ConfigHandler(notepad);
	}
	
	public void configInit(){
		// TODO catalin.podariu find/set default folders & ideOrJar
	}
	
	

	private Properties properties;
	private BIGNotepad notepad;
}
