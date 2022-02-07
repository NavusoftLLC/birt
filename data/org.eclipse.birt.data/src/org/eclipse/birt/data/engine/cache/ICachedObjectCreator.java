
/*******************************************************************************
 * Copyright (c) 2004, 2005 Actuate Corporation.
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
package org.eclipse.birt.data.engine.cache;

/**
 * A interface defined a method which is used to create ICachedObject.
 */

public interface ICachedObjectCreator {
	/**
	 * 
	 * @param fields
	 * @return
	 */
	public ICachedObject createInstance(Object[] fields);
}
