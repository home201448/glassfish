/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
 * 
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 * 
 * Contributor(s):
 * 
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
 

package com.sun.appserv.management.ext.logging;

import java.util.Map;
import java.util.logging.Level;


/**
	Provides summary information about important logging events.
	<big>PRELIMINARY--SUBJECT TO CHANGES/ADDITIONS</big>
	
	@since AS 9.0
 */
public interface LogAnalyzer
{
	/**
		Key into any Map returned from {@link #getErrorInfo}.
		value is of type Long.
	*/
	public static final String TIMESTAMP_KEY		= "TimeStamp";
	
	/**
		Key into any Map returned from {@link #getErrorInfo}.
		value is of type Long.
	*/
	public static final String SEVERE_COUNT_KEY		= "SevereCount";
	
	/**
		Key into any Map returned from {@link #getErrorInfo}.
		value is of type Long.
	*/
	public static final String WARNING_COUNT_KEY	= "WarningCount";
	
	/**
		Key into any Map returned from {@link #getErrorDistribution}.
		value is of type String.
	*/
	public static final String MODULE_NAME_KEY	= "ModuleName";
	
	
	/**
		Get a summary of the {@link Level#SEVERE} and {@link Level#WARNING} log
		entries for the known history. Each entry in the resulting array is a
		Map with the following keys:
		<ul>
		<li>{@link #TIMESTAMP_KEY} of type Long</li>
		<li>{@link #SEVERE_COUNT_KEY} of type Integer</li>
		<li>{@link #WARNING_COUNT_KEY} of type Integer</li>
		</ul>
		The entries are arranged from oldest to newest with the last entry being
		the most recent.
		<p>
		The timestamp obtained from each Map may be used as the timestamp when
		calling {@link #getErrorDistribution}. For example:<br>
<code>
final Map<String,Number>[]	infos	= logging.getErrorInfo();<br>
for( int i = 0; i < infos.length; ++i ) {<br>
	final Map<String,Object>	info	= infos[ i ];<br>
	final long timestamp	= ((Long)info.get( TIMESTAMP_KEY )).longValue();<br>
	<br>
	Map<String,Number>	counts	= getErrorDistribution( timestamp );<br>
}
</code>
		
		@return Map<String,Number>
	 */
	public Map<String,Number>[]	getErrorInfo();
	
	
	/**
		Get the number of log entries for a particular timestamp of a particular {@link Level}
		for all modules.  SEVERE and WARNING are the only levels supported.
		<p>
		The resulting Map is keyed by the module ID, which may be any of the values
		found in {@link LogModuleNames} or any valid Logger name.
		The corresponding value
		is the count for that module of the requested level.
		<p>
		
		@param timestamp a timestamp as obtained using TIME_STAMP_KEY from one of the Maps
		returned by {@link #getErrorInfo}.  Note that it is a 'long' not a 'Long' and is required.
		@param level
		@return Map<String,Integer>
	 */
	public Map<String,Integer>	getErrorDistribution(long timestamp, String level);
	
	/**
	    @return all the logger names currently in use
	 */
	public String[] getLoggerNames();
	
	/**
	    @return all the logger names currently in use under this logger.
	 */
    public String[]   getLoggerNamesUnder( String loggerName );
    
    /**
        Set the number of intervals error statistics should be maintained.
     
        @param numIntervals number of intervals
     */
    public void setKeepErrorStatisticsForIntervals(final int numIntervals );
    
    /*
        See {@link #setErrorStatisticsIntervals}.
     */
    public int  getKeepErrorStatisticsForIntervals();

    /**
        Set the duration of an interval.
    
        @param minutes The duration of an interval in minutes.
     */
    public void setErrorStatisticsIntervalMinutes(final long minutes);
    
    /*
        See {@link #setErrorStatisticsIntervalMinutes}.
     */
    public long getErrorStatisticsIntervalMinutes(); 
}






