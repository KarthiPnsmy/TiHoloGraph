package titutorial.holograph;

import java.util.ArrayList;
import java.util.HashMap;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

import com.echo.holographlibrary.Bar;
import com.echo.holographlibrary.Line;
import com.echo.holographlibrary.PieGraph;
import com.echo.holographlibrary.PieGraph.OnSliceClickedListener;
import com.echo.holographlibrary.PieSlice;
import com.echo.holographlibrary.LineGraph.OnPointClickedListener;
import com.echo.holographlibrary.LinePoint;
import com.echo.holographlibrary.BarGraph.OnBarClickedListener;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;

@Kroll.proxy(creatableInModule = HolographModule.class)
public class PieChartProxy extends TiViewProxy {
	
	PieChartView pieChartView;
	Object[] data = null;
	ArrayList<PieSlice> slices = new ArrayList<PieSlice>();
	boolean hasSliceClickListener = false;
	
	@Override
	public PieChartView createView(Activity activity) {
		hasSliceClickListener = hasListeners("sliceClick");
		System.out.println("@@## hasSliceClickListener = "+hasSliceClickListener);

		pieChartView = new PieChartView(this);
		slices = new ArrayList<PieSlice>();
		if(data.length > 0){
			for(int k = 0; k< data.length; k++){
				Object[] item = (Object[]) data[k];
				System.out.println("@@## item len  = "+item.length);
				PieSlice slice = new PieSlice();
				slice.setColor(Color.parseColor((String) item[1]));
				System.out.println("@@## before val  = "+item[2]);
				Float val = new Float((Integer) item[2]);
				System.out.println("@@## after val  = "+val);
				slice.setValue(val);
				slices.add(slice);
			}
			pieChartView.setSlices(slices);
		}
		
		pieChartView.setOnSliceClickedListener(new OnSliceClickedListener() {
			
			@Override
			public void onClick(int index) {
				if(hasSliceClickListener){
					KrollDict props = new KrollDict();
					props.put("index", index);
					fireEvent("sliceClick", props);
				}
			}
		});

		return pieChartView;
	}
	
	// Handle creation options
	@Override
	public void handleCreationDict(KrollDict options) {
		super.handleCreationDict(options);
		
		if (options.containsKey("data")) {
			data = (Object[]) options.get("data");
		}
	}
}
