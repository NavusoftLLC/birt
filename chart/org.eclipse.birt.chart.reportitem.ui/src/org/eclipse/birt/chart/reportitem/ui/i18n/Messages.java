/***********************************************************************
 * Copyright (c) 2004 Actuate Corporation.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/.
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 *
 * Contributors:
 * Actuate Corporation - initial API and implementation
 ***********************************************************************/

package org.eclipse.birt.chart.reportitem.ui.i18n;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;

/**
 * Messages
 */
public class Messages {

	private static final String REPORT_ITEM_UI = "org.eclipse.birt.chart.reportitem.ui.i18n.nls";//$NON-NLS-1$

	private static final ResourceBundle REPORT_ITEM_BUNDLE = UResourceBundle.getBundleInstance(REPORT_ITEM_UI,
			ULocale.getDefault(), Messages.class.getClassLoader());

	private static Map<ULocale, ResourceBundle> hmLocalToBundle = new HashMap<ULocale, ResourceBundle>(2);

	private Messages() {
	}

	public static ResourceBundle getResourceBundle() {
		return REPORT_ITEM_BUNDLE;
	}

	public static ResourceBundle getResourceBundle(ULocale locale) {
		if (locale == null) {
			return REPORT_ITEM_BUNDLE;
		}
		ResourceBundle bundle = hmLocalToBundle.get(locale);

		if (bundle == null) {
			bundle = getMatchedResourceBundle(locale, REPORT_ITEM_UI, Messages.class);
			if (bundle != null) {
				hmLocalToBundle.put(locale, bundle);
			}
		}

		return bundle;
	}

	/**
	 * Returns a resource bundle which is most match to specified locale.
	 * <p>
	 * As expected, if specified locale hasn't defined valid resource file, we want
	 * to load English(default) resource file instead of the resource file of
	 * default locale.
	 * 
	 * @param locale   specified locale.
	 * @param baseName the path of resource.
	 * @param clazz    the class whose class loader will be used by loading resource
	 *                 bundle.
	 * @return instance of resource bundle.
	 */
	@SuppressWarnings("rawtypes")
	private static ResourceBundle getMatchedResourceBundle(ULocale locale, String baseName, Class clazz) {
		ResourceBundle bundle;
		bundle = UResourceBundle.getBundleInstance(baseName, locale, clazz.getClassLoader());

		if (bundle != null) {
			// Bundle could be in default locale instead of English
			// if resource for the locale cannot be found.
			String language = locale.getLanguage();
			String country = locale.getCountry();
			boolean useDefaultResource = true;
			if (language.length() == 0 && country.length() == 0) {
				// it is definitely the match, no need to get the
				// default resource file again.
				useDefaultResource = false;
			} else {
				Locale bundleLocale = bundle.getLocale();
				if (bundleLocale.getLanguage().length() == 0 && bundleLocale.getCountry().length() == 0) {
					// it is the match, no need to get the default
					// resource file again.
					useDefaultResource = false;
				} else if (language.equals(bundleLocale.getLanguage())) {
					// Language matched
					String bundleCountry = bundleLocale.getCountry();
					if (country.equals(bundleCountry) || bundleCountry.length() == 0) {
						// Country matched or Bundle has no Country
						// specified.
						useDefaultResource = false;
					}
				}
			}
			if (useDefaultResource) {
				bundle = ResourceBundle.getBundle(baseName, new Locale("", "")); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return bundle;
	}

	/**
	 * @param key
	 */
	public static String getString(String key) {
		try {
			return REPORT_ITEM_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	/**
	 * 
	 * @param key key
	 * @param oas arguments
	 */
	public static String getString(String key, Object[] oas) {
		try {
			return MessageFormat.format(REPORT_ITEM_BUNDLE.getString(key), oas);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	/**
	 * 
	 * @param key key
	 * @param oa  single argument
	 */
	public static String getString(String key, Object oa) {
		try {
			return MessageFormat.format(REPORT_ITEM_BUNDLE.getString(key), new Object[] { oa });
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
