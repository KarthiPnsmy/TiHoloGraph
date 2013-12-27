package titutorial.holograph;

import java.util.ArrayList;

import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

import com.echo.holographlibrary.Bar;
import com.echo.holographlibrary.BarGraph;
import com.echo.holographlibrary.BarGraph.OnBarClickedListener;


import android.view.LayoutInflater;
import android.view.View;

public class BarChartView extends TiUIView {

	BarGraph barGraph;

	public BarChartView(TiViewProxy proxy) {
		super(proxy);

		View chartWrapper = new View(proxy.getActivity());

		LayoutInflater inflater = LayoutInflater.from(proxy.getActivity());
		chartWrapper = inflater.inflate(Utility.resId_barChartLayout, null);
		barGraph = (BarGraph) chartWrapper.findViewById(Utility.resId_barChart);
		
		setNativeView(chartWrapper);
	}
	
	 public void setShowBarText(boolean show){
		 barGraph.setShowBarText(show);
	 }
	    
	 public void setBars(ArrayList<Bar> points){
	     barGraph.setBars(points);
	 }
	    
	public ArrayList<Bar> getBars(){
	    return barGraph.getBars();
	}
	public void setOnBarClickedListener(OnBarClickedListener listener) {
	    barGraph.setOnBarClickedListener(listener);
	}

}
