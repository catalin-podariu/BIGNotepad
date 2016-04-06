package config;

public class ConfigWindowSettings {

	private String width, height;

	private String x, y;

	private String windowTitleDisplayMode;
	private String zoomFactor;

	protected String getWidth() {
		return width;
	}

	protected void setWidth(String width) {
		this.width = width;
	}

	protected String getHeight() {
		return height;
	}

	protected void setHeight(String height) {
		this.height = height;
	}

	protected String getX() {
		return x;
	}

	protected void setX(String x) {
		this.x = x;
	}

	protected String getY() {
		return y;
	}

	protected void setY(String y) {
		this.y = y;
	}

	protected String getWindowTitleDisplayMode() {
		return windowTitleDisplayMode;
	}

	protected void setWindowTitleDisplayMode(String windowTitleDisplayMode) {
		this.windowTitleDisplayMode = windowTitleDisplayMode;
	}

	protected String getZoomFactor() {
		return zoomFactor;
	}

	protected void setZoomFactor(String zoomFactor) {
		this.zoomFactor = zoomFactor;
	}
}
