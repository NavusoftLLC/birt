/*
 *************************************************************************
 * Copyright (c) 2005 Actuate Corporation.
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
 *  
 *************************************************************************
 */
package org.eclipse.birt.data.engine.api.script;

import org.eclipse.birt.core.exception.BirtException;

/**
 * Event handler for a script data source
 *
 */
public interface IScriptDataSourceEventHandler extends IBaseDataSourceEventHandler {
	public void handleOpen(IDataSourceInstanceHandle dataSource) throws BirtException;

	public void handleClose(IDataSourceInstanceHandle dataSource) throws BirtException;
}
