/*******************************************************************************
 * Copyright (c) 2004 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.engine.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;

import org.eclipse.birt.core.archive.IDocArchiveReader;
import org.eclipse.birt.data.engine.api.IFilterDefinition;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.IDataExtractionTask;
import org.eclipse.birt.report.engine.api.IExtractionResults;
import org.eclipse.birt.report.engine.api.IReportDocument;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.InstanceID;

import com.ibm.icu.util.ULocale;

public class DataExtractionTask implements IDataExtractionTask
{

	IDataExtractionTask task;

	public DataExtractionTask( IReportEngine engine, IReportRunnable runnable,
			IReportDocument reader ) throws EngineException
	{
		String version = reader.getVersion( );
		if ( ReportDocumentConstants.REPORT_DOCUMENT_VERSION_2_1_0
				.equals( version )
				|| ReportDocumentConstants.REPORT_DOCUMENT_VERSION_1_2_1
						.equals( version )
				|| ReportDocumentConstants.REPORT_DOCUMENT_VERSION_1_0_0
						.equals( version ) )
		{
			task = new DataExtractionTaskV0( engine, runnable, reader );
		}
		else if ( ReportDocumentConstants.REPORT_DOCUMENT_VERSION_2_1_3
				.equals( version ) )
		{
			task = new DataExtractionTaskV1( engine, runnable, reader );
		}
	}

	public void addScriptableJavaObject( String jsName, Object obj )
	{
		task.addScriptableJavaObject( jsName, obj );
	}

	public void cancel( )
	{
		task.cancel( );
	}

	public void cancel( Object signal )
	{
		task.cancel( signal );
	}

	public void close( )
	{
		task.close( );
	}

	public IExtractionResults extract( ) throws EngineException
	{
		return task.extract( );
	}

	public Map getAppContext( )
	{
		return task.getAppContext( );
	}

	public boolean getCancelFlag( )
	{
		return task.getCancelFlag( );
	}

	public IReportEngine getEngine( )
	{
		return task.getEngine( );
	}

	public List getErrors( )
	{
		return task.getErrors( );
	}

	public int getID( )
	{
		return task.getID( );
	}

	public Locale getLocale( )
	{
		return task.getLocale( );
	}

	public List getMetaData( ) throws EngineException
	{
		return task.getMetaData( );
	}

	public String getParameterDisplayText( String name )
	{
		return task.getParameterDisplayText( name );
	}

	public Object getParameterValue( String name )
	{
		return task.getParameterValue( name );
	}

	public HashMap getParameterValues( )
	{
		return task.getParameterValues( );
	}

	public IReportRunnable getReportRunnable( )
	{
		return task.getReportRunnable( );
	}

	public List getResultSetList( ) throws EngineException
	{
		return task.getResultSetList( );
	}

	public int getStatus( )
	{
		return task.getStatus( );
	}

	public ULocale getULocale( )
	{
		return task.getULocale( );
	}

	public void selectColumns( String[] columnNames )
	{
		task.selectColumns( columnNames );
	}

	public void selectResultSet( String resultSetName )
	{
		task.selectResultSet( resultSetName );
	}

	public void setAppContext( Map context )
	{
		task.setAppContext( context );
	}

	public void setDataSource( IDocArchiveReader dataSource )
	{
		task.setDataSource( dataSource );
	}

	public void setFilters( IFilterDefinition[] simpleFilterExpression )
	{
		task.setFilters( simpleFilterExpression );
	}

	public void setInstanceID( InstanceID iid )
	{
		task.setInstanceID( iid );
	}

	public void setLocale( Locale locale )
	{
		task.setLocale( locale );
	}

	public void setLocale( ULocale locale )
	{
		task.setLocale( locale );
	}

	public void setParameter( String name, Object value, String displayText )
	{
		task.setParameter( name, value, displayText );
	}

	public void setParameterDisplayText( String name, String displayText )
	{
		task.setParameterDisplayText( name, displayText );
	}

	public void setParameterValue( String name, Object value )
	{
		task.setParameterValue( name, value );
	}

	public void setParameterValues( Map params )
	{
		task.setParameterValues( params );
	}

	public boolean validateParameters( )
	{
		return task.validateParameters( );
	}

	public Logger getLogger( )
	{
		return task.getLogger( );
	}

	public int getTaskType( )
	{
		return task.getTaskType( );
	}

	public void setErrorHandlingOption( int option )
	{
		task.setErrorHandlingOption( option );
	}

	public void setLogger( Logger logger )
	{
		task.setLogger( logger );
	}

}
