/*******************************************************************************
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
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.model.elements.interfaces;

/**
 * The interface for script data source element to store the constants.
 */
public interface IScriptDataSourceModel {

	/**
	 * The property name of the script that connects to the data source.
	 */

	public static final String OPEN_METHOD = "open"; //$NON-NLS-1$

	/**
	 * The property name of the script that close the data source.
	 */

	public static final String CLOSE_METHOD = "close"; //$NON-NLS-1$

}
