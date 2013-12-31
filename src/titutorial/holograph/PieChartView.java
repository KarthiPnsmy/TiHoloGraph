package titutorial.holograph;

import java.util.ArrayList;

import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

import android.view.LayoutInflater;
import android.view.View;

import com.echo.holographlibrary.Line;
import com.echo.holographlibrary.LineGraph;
import com.echo.holographlibrary.PieGraph;
import com.echo.holographlibrary.PieSlice;
import com.echo.holographlibrary.BarGraph.OnBarClickedListener;
import com.echo.holographlibrary.LineGraph.OnPointClickedListener;
import com.echo.holographlibrary.PieGraph.OnSliceClickedListener;

public class PieChartView extends TiUIView {
	
	PieGraph pieGraph;
	
	public PieChartView(TiViewProxy proxy) {
		super(proxy);

		View chartWrapper = new View(proxy.getActivity());

		LayoutInflater inflater = LayoutInflater.from(proxy.getActivity());
		chartWrapper = inflater.inflate(Utility.resId_pieChartLayout, null);
		pieGraph = (PieGraph) chartWrapper.findViewById(Utility.resId_pieChart);
		
		setNativeView(chartWrapper);
	}
	
	public void setSlices(ArrayList<PieSlice> slices) {
		pieGraph.setSlices(slices);
	}
	
	public void setOnSliceClickedListener(OnSliceClickedListener listener) {
		pieGraph.setOnSliceClickedListener(listener);
	}
}
