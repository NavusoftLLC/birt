/*******************************************************************************
 * Copyright (c) 2004, 2010 Actuate Corporation.
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

package org.eclipse.birt.data.engine.impl.index;

import org.eclipse.birt.data.engine.core.DataException;

public interface IDataSetIndex {
	public IOrderedIntSet getKeyIndex(Object key, int filterType) throws DataException;

	public boolean supportFilter(int filterType) throws DataException;

	public Object[] getAllKeyValues() throws DataException;

	public IOrderedIntSet getAllKeyRows() throws DataException;
}
