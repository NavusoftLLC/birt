/*
 *****************************************************************************
 * Copyright (c) 2004, 2005 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *
 ******************************************************************************
 */  

package org.eclipse.birt.data.engine.odaconsumer;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import org.eclipse.birt.data.engine.i18n.DataResourceHandle;
import org.eclipse.birt.data.engine.i18n.ResourceConstants;

/**
 * <code>ColumnHint</code> provides hints to merge static design time 
 * columns with runtime result set column metadata.
 */
public class ColumnHint
{
	private String m_name;
	private int m_position;
	private Class m_dataType;
	private String m_alias;
	
	/**
	 * Constructs a <code>ColumnHint</code> with the specified column name.
	 * @param columnName	the column name of this <code>ColumnHint</code>.
	 * @throws IllegalArgumentException	if <code>columnName</code> is null or
	 * 									empty.
	 */
	public ColumnHint( String columnName )
	{
		if( columnName == null || columnName.length() == 0 )
		{
			String localizedMessage = 
				DataResourceHandle.getInstance().getMessage( ResourceConstants.COLUMN_NAME_CANNOT_BE_EMPTY_OR_NULL );
			throw new IllegalArgumentException( localizedMessage );
		}
			
		m_name = columnName;
	}

	/**
	 * Returns the column name for this <code>ColumnHint</code>.
	 * @return	the name of the column.
	 */
	public String getName()
	{
		return m_name;
	}

	/**
	 * Sets the 1-based column position for this <code>ColumnHint</code>.
	 * @param position	the 1-based column position.
	 * @throws IllegalArgumentException	if the column position is less than 1.
	 */
	public void setPosition( int position )
	{
		if( position < 1 )
		{
			String localizedMessage = 
				DataResourceHandle.getInstance().getMessage( ResourceConstants.COLUMN_POSITION_CANNOT_BE_LESS_THAN_ONE );
			throw new IllegalArgumentException( localizedMessage );
		}
		
		m_position = position;
	}
	
	/**
	 * Returns the 1-based column position for this <code>ColumnHint</code>.
	 * @return	the 1-based column position; 0 if no position was not specified.
	 */
	public int getPosition()
	{
		return m_position;
	}
	
	/**
	 * Sets the data type for this <code>ColumnHint</code>.
	 * @param dataType	the data type.
	 */
	public void setDataType( Class dataType )
	{
		// data type for a hint may be null
		assert( dataType == null || 
		        dataType == Integer.class ||
		        dataType == Double.class ||
		        dataType == String.class ||
		        dataType == BigDecimal.class ||
		        dataType == Date.class ||
		        dataType == Time.class ||
		        dataType == Timestamp.class );
		
		m_dataType = dataType;
	}
	
	/**
	 * Returns the column data type for this <code>ColumnHint</code>.
	 * @return	the column data type.
	 */
	public Class getDataType()
	{
		return m_dataType;
	}
	
	/**
	 * Sets the column alias for this <code>ColumnHint</code>.
	 * @param alias	the column alias.
	 */
	public void setAlias( String alias )
	{
		// ok to set the alias as null, meaning no alias.  but not
		// ok to have an empty alias
		if( alias != null && alias.length() == 0 )
		{
			String localizedMessage = 
				DataResourceHandle.getInstance().getMessage( ResourceConstants.COLUMN_ALIAS_CANNOT_BE_EMPTY );
			throw new IllegalArgumentException( localizedMessage );
		}
		
		m_alias = alias;
	}
	
	/**
	 * Returns the column alias for this <code>ColumnHint</code>.
	 * @return	the column alias.
	 */
	public String getAlias()
	{
		return m_alias;
	}
}
