
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
package org.eclipse.birt.data.engine.odi;

import org.eclipse.birt.data.engine.api.IBaseExpression;
import org.eclipse.birt.data.engine.api.aggregation.IAggrFunction;

/**
 * 
 */

public interface IAggrInfo {
	/**
	 * The name of the aggregation definition.
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * Return the IAggrFunction instance relate to this AggrInfo
	 * 
	 * @return
	 */
	public IAggrFunction getAggregation();

	/**
	 * Get arguments.
	 * 
	 * @return
	 */
	public IBaseExpression[] getArgument();

	/**
	 * Get filters.
	 * 
	 * @return
	 */
	public IBaseExpression getFilter();

	/**
	 * Get the group level of target aggregation.
	 * 
	 * @return
	 */
	public int getGroupLevel();

	/**
	 * Get the calcualteLevel of target aggregation. This is only used in nested
	 * aggregations.
	 * 
	 * @return
	 */
	public int getCalcualteLevel();

	/**
	 * Set calculate level.
	 * 
	 * @param calcualteLevel
	 */
	public void setCalculateLevel(int calcualteLevel);

	/**
	 * Set the pass round.
	 * 
	 * @param round
	 */
	public void setRound(int round);

	/**
	 * Get the pass round.The pass round indicate in which round this aggregation
	 * should be calculated.
	 * 
	 * @return
	 */
	public int getRound();
}
