package titutorial.holograph;

import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

import android.view.LayoutInflater;
import android.view.View;

import com.echo.holographlibrary.Line;
import com.echo.holographlibrary.LineGraph;
import com.echo.holographlibrary.BarGraph.OnBarClickedListener;
import com.echo.holographlibrary.LineGraph.OnPointClickedListener;

public class LineChartView extends TiUIView {
	
	LineGraph lineGraph;
	
	public LineChartView(TiViewProxy proxy) {
		super(proxy);
		

		View chartWrapper = new View(proxy.getActivity());

		LayoutInflater inflater = LayoutInflater.from(proxy.getActivity());
		chartWrapper = inflater.inflate(Utility.resId_lineChartLayout, null);
		lineGraph = (LineGraph) chartWrapper.findViewById(Utility.resId_lineChart);
		
		setNativeView(chartWrapper);
	}
	
	
	public void addLine(Line line) {
		lineGraph.addLine(line);
	}
	
	public void setRangeY(Float a, Float b) {
		lineGraph.setRangeY(a, b);
	}
	
	public void setLineToFill(Integer a) {
		lineGraph.setLineToFill(a);
	}
	
	public void setOnPointClickedListener(OnPointClickedListener listener) {
		lineGraph.setOnPointClickedListener(listener);
	}

}
