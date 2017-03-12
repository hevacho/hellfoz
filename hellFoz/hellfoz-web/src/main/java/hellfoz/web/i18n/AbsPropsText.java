package hellfoz.web.i18n;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public abstract class AbsPropsText extends ResourceBundle {

    protected static final String BUNDLE_EXTENSION = "properties";
    protected static final Control CONTROL = new EncodingControl("UTF-8");
    
    public AbsPropsText() {
	setParent(ResourceBundle.getBundle(getBundleName(), FacesContext.getCurrentInstance().getViewRoot().getLocale(), CONTROL));
    }

    protected abstract String getBundleName();

    @Override
    protected Object handleGetObject(String key) {
	return parent.getObject(key);
    }

    @Override
    public Enumeration<String> getKeys() {
	return parent.getKeys();
    }

    protected static class EncodingControl extends Control {
	private String encoding = "UTF-8";

	public EncodingControl() {

	}

	public EncodingControl(String encoding) {
	    this.encoding = encoding;
	}

	@Override
	public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
		throws IllegalAccessException, InstantiationException, IOException {
	    // The below code is copied from default Control#newBundle() implementation.
	    // Only the PropertyResourceBundle line is changed to read the file as UTF-8.
	    String bundleName = toBundleName(baseName, locale);
	    String resourceName = toResourceName(bundleName, BUNDLE_EXTENSION);
	    ResourceBundle bundle = null;
	    InputStream stream = null;
	    if (reload) {
		URL url = loader.getResource(resourceName);
		if (url != null) {
		    URLConnection connection = url.openConnection();
		    if (connection != null) {
			connection.setUseCaches(false);
			stream = connection.getInputStream();
		    }
		}
	    } else {
		stream = loader.getResourceAsStream(resourceName);
	    }
	    if (stream != null) {
		try {
		    bundle = new PropertyResourceBundle(new InputStreamReader(stream, encoding));
		} finally {
		    stream.close();
		}
	    }
	    return bundle;
	}
    }

}