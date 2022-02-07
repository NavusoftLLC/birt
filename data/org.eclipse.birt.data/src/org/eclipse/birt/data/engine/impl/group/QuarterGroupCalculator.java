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

package org.eclipse.birt.data.engine.impl.group;

import java.util.Date;

import org.eclipse.birt.core.exception.BirtException;

import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;

/**
 * This calculator is used to calculate a quarter group key basing group
 * interval.
 */
class QuarterGroupCalculator extends DateGroupCalculator {

	public QuarterGroupCalculator(Object intervalStart, double intervalRange, ULocale locale, TimeZone timeZone)
			throws BirtException {
		super(intervalStart, intervalRange, locale, timeZone);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.birt.data.engine.impl.group.DateGroupCalculator#calculate(java.
	 * lang.Object)
	 */
	public Object calculate(Object value) throws BirtException {
		if (value == null) {
			return new Double(-1);
		}

		Date target = getDate(value);

		if (intervalStart == null) {
			return new Double(Math.floor(
					(double) this.dateTimeUtil.diffQuarter(defaultStart, target) / (double) getDateIntervalRange()));
		} else {
			if (this.dateTimeUtil.diffQuarter((Date) intervalStart, target) < 0) {
				return new Double(-1);
			} else {
				return new Double(Math.floor((double) this.dateTimeUtil.diffQuarter((Date) intervalStart, target)
						/ (double) getDateIntervalRange()));
			}
		}
	}
}
