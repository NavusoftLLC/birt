
/*******************************************************************************
 * Copyright (c) 2004, 2007 Actuate Corporation.
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
package org.eclipse.birt.data.engine.olap.data.api.cube;

import org.eclipse.birt.data.engine.api.DataEngine;
import org.eclipse.birt.data.engine.api.IShutdownListener;

/**
 * 
 */

public class DocManagerReleaser implements IShutdownListener {
	private DataEngine dataEngine = null;

	public DocManagerReleaser(DataEngine dataEngine) {
		this.dataEngine = dataEngine;
	}

	/**
	 * 
	 */
	public void dataEngineShutdown() {
		DocManagerMap.getDocManagerMap().close(String.valueOf(dataEngine.hashCode()));
	}

}
