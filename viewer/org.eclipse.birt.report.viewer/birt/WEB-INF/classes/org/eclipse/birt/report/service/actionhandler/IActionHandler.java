/*************************************************************************************
 * Copyright (c) 2004 Actuate Corporation and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/.
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Actuate Corporation - Initial implementation.
 ************************************************************************************/

package org.eclipse.birt.report.service.actionhandler;

import java.rmi.RemoteException;

public interface IActionHandler {

	public void execute() throws RemoteException;

	public boolean canExecute();

	public boolean canUndo();

	public boolean canRedo();

	public void undo();

	public void redo();

	public boolean prepare() throws Exception;
}
