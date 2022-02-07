/*******************************************************************************
 * Copyright (c) 2004 Actuate Corporation.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/.
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors: Actuate Corporation - initial API and implementation
 ******************************************************************************/

package org.eclipse.birt.report.designer.ui.preview.parameter;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Tests all cases in parameter package.
 * 
 */

public class AllParameterTests extends TestCase {

	/**
	 * Tests all.
	 * 
	 * @throws Exception
	 */
	public void test() throws Exception {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(ParameterCreationTest.class);
		suite.addTestSuite(ParameterTest.class);
	}
}
