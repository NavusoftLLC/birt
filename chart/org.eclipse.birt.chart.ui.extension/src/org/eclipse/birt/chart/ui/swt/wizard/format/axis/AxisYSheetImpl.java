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

package org.eclipse.birt.chart.ui.swt.wizard.format.axis;

import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.attribute.AngleType;
import org.eclipse.birt.chart.model.component.Axis;
import org.eclipse.birt.chart.model.util.DefaultValueProvider;
import org.eclipse.birt.chart.ui.util.ChartHelpContextIds;
import org.eclipse.birt.chart.ui.util.ChartUIUtil;
import org.eclipse.swt.widgets.Composite;

/**
 * AxisYSheetImpl
 * 
 * @author Actuate Corporation
 * 
 */
public class AxisYSheetImpl extends AbstractAxisSubtask {

	protected Axis getAxisForProcessing() {
		return ChartUIUtil.getAxisYForProcessing((ChartWithAxes) getChart(), getIndex());
	}

	protected int getAxisAngleType() {
		return AngleType.Y;
	}

	public void createControl(Composite parent) {
		ChartUIUtil.bindHelp(parent, ChartHelpContextIds.SUBTASK_YAXIS);
		super.createControl(parent);
	}

	@Override
	protected Axis getDefaultValueAxis() {
		return DefaultValueProvider.defOrthogonalAxis();
	}
}
