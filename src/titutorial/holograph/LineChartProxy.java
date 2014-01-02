package titutorial.holograph;

import java.util.HashMap;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.proxy.TiViewProxy;

import android.app.Activity;
import android.graphics.Color;

import com.echo.holographlibrary.Line;
import com.echo.holographlibrary.LineGraph.OnPointClickedListener;
import com.echo.holographlibrary.LinePoint;

@Kroll.proxy(creatableInModule = HolographModule.class)
public class LineChartProxy extends TiViewProxy {
	
	LineChartView lineChartView;
	Object[] data = null;
	String lineColor = "#FFBB33";
	Integer lineToFill = 0;
	Object[] rangeY = {0, 10};
	boolean hasPointClickListener = false;
	
	@SuppressWarnings("unchecked")
	@Override
	public LineChartView createView(Activity activity) {
		hasPointClickListener = hasListeners("pointClick");
		System.out.println("@@## hasPointClickListener = "+hasPointClickListener);
		
		lineChartView = new LineChartView(this);
		
		for (Object lineObject : data) {
			Line line = new Line();
			HashMap<String, Object> lineObjectHashMap = (HashMap<String, Object>) lineObject;
			
			Object[] linePoints = (Object[]) lineObjectHashMap.get("points");
			
			//adding line points
			for(int k = 0; k< linePoints.length; k++){
				Object[] item = (Object[]) linePoints[k];
					Float x = new Float((Integer) item[0]);
					Float y = new Float((Integer) item[1]);
					LinePoint lPoint = new LinePoint(x,y);
					line.addPoint(lPoint);
					System.out.println("@@## line x  = "+x+", y = "+y);
			}
			
			//adding line color
			lineColor=(String) lineObjectHashMap.get("lineColor");
			line.setColor(Color.parseColor(lineColor));
			lineChartView.addLine(line);
			
			//adding rangeY
			if(rangeY != null && rangeY.length > 0){
				Float a = new Float((Integer) rangeY[0]);
				Float b = new Float((Integer) rangeY[1]);
				lineChartView.setRangeY(a, b);
			} 
			
			//adding lineToFill
			lineChartView.setLineToFill(lineToFill);
		} 
		
		lineChartView.setOnPointClickedListener(new OnPointClickedListener() {
			
			@Override
			public void onClick(int lineIndex, int pointIndex) {
				if(hasPointClickListener){
					KrollDict props = new KrollDict();
					props.put("lineIndex", lineIndex);
					props.put("pointIndex", pointIndex);
					fireEvent("pointClick", props);
				}
				
			}
		});
		
		return lineChartView;
	}
	
	// Handle creation options
	@Override
	public void handleCreationDict(KrollDict options) {
		super.handleCreationDict(options);
		
		if (options.containsKey("data")) {
			data = (Object[]) options.get("data");
		}
		
		if (options.containsKey("rangeY")) {
			rangeY = (Object[]) options.get("rangeY");
		}
		
		if (options.containsKey("lineToFill")) {
			lineToFill = options.getInt("lineToFill");
		}
	}
}
