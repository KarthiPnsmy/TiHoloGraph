/**
 * Copyright 2012 Facebook
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * MODIFICATIONS
 * 
 * Facebook Module
 * Copyright (c) 2009-2013 by Appcelerator, Inc. All Rights Reserved.
 * Please see the LICENSE included with this distribution for details.
 */

/**
 * NOTES
 * Modifications made for Titanium:
 * - Add setLogEnabled() to enable/disable log messages and getLogEnabled() to get the value of ENABLE_LOG.
 * - Add loadResourceIds() to fetch resources ids using Resources.getIdentifier, since
 	we merge resources into Titanium project and don't have access to R.
 * 
 * Original file this is based on:
 * https://github.com/facebook/facebook-android-sdk/blob/4e2e6b90fbc964ca51a81e83e802bb4a62711a78/facebook/src/com/facebook/internal/Utility.java
 */

package titutorial.holograph;

import android.content.Context;
import android.content.res.Resources;

public final class Utility {
    // *************** APPCELERATOR TITANIUM CUSTOMIZATION ***************************
    // Resource IDs used in titutorial.gallerypicker package. Fetch the resource id using Resources.getIdentifier, since
    // we merge resources into Titanium project and don't have access to R here.
    public static int resId_popupBlack = -1;
    public static int resId_pieChartLayout = -1;
    public static int resId_lineChartLayout = -1;
    public static int resId_barChartLayout = -1;
    public static int resId_pieChart = -1;
    public static int resId_lineChart = -1;
    public static int resId_barChart = -1;

	public static void loadResourceIds(Context context)
	{
		String packageName = context.getPackageName();
		Resources resources = context.getResources();
		
		resId_popupBlack = resources.getIdentifier("popup_black", "drawable", packageName);
		resId_pieChartLayout = resources.getIdentifier("pie_chart_layout", "layout", packageName);
		resId_lineChartLayout = resources.getIdentifier("line_chart_layout", "layout", packageName);
		resId_barChartLayout = resources.getIdentifier("bar_chart_layout", "layout", packageName);
		resId_pieChart = resources.getIdentifier("pie_chart", "id", packageName);
		resId_lineChart = resources.getIdentifier("line_chart", "id", packageName);
		resId_barChart = resources.getIdentifier("bar_chart", "id", packageName);
	}
}
