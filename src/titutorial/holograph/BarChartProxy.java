package titutorial.holograph;

import java.util.ArrayList;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

//import titutorial.holograph.BarGraph.OnBarClickedListener; com.echo.holographlibrary
import com.echo.holographlibrary.Bar;
import com.echo.holographlibrary.BarGraph.OnBarClickedListener; 
import android.app.Activity;
import android.graphics.Color;

//This proxy can be created by calling Holograph.createExample({message: "hello world"})
@Kroll.proxy(creatableInModule = HolographModule.class)
public class BarChartProxy extends TiViewProxy {

	BarChartView barChartView;
	Object[] data = null;
	ArrayList<Bar> points =new ArrayList<Bar>();
	boolean hasBarClickListener = false;

	@Override
	public BarChartView createView(Activity activity) {
		
		hasBarClickListener = hasListeners("barClick");
		System.out.println("@@## hasBarClickListener = "+hasBarClickListener);
		barChartView = new BarChartView(this);
		barChartView.setBars(points);
		
		barChartView.setOnBarClickedListener(new OnBarClickedListener() {
			
			@Override
			public void onClick(int index) {
				
				if(hasBarClickListener){
					KrollDict props = new KrollDict();
					props.put("index", index);
					fireEvent("barClick", props);
				}
				
			}
		});
		return barChartView;
	}

	// Handle creation options
	@Override
	public void handleCreationDict(KrollDict options) {
		super.handleCreationDict(options);
		
		if (options.containsKey("data")) {
			data = (Object[]) options.get("data");
			createBars(data);
		} else {
			System.out.println("@@## no key data ");
		}
	}
	
	@Kroll.method
	public void setShowBarText(boolean show) {
		barChartView.setShowBarText(show);
	}
	@Kroll.method
	public void setBars(Object[] data) {
		createBars(data);
		barChartView.setBars(points);
	}

	@Kroll.method
	public void setOnBarClickedListener(OnBarClickedListener listener) {
		barChartView.setOnBarClickedListener(listener);
	}
	
	public void createBars(Object[] data){
		if(data.length > 0){
			for(int k = 0; k< data.length; k++){
				Object[] item = (Object[]) data[k];
					Bar d = new Bar();
					d.setName((String)item[0]);
					d.setColor(Color.parseColor((String)item[1]));
					Float val = new Float((Integer) item[2]);
					System.out.println("@@## after val  = "+val);
					d.setValue(val);
					points.add(d);
			}
		}
		
	}
}
