
// This is a test harness for your module
// You should do something interesting in this harness 
// to test out the module and to provide instructions 
// to users on how to use it by example.


// open a single window
var win = Ti.UI.createWindow({
	backgroundColor:'white'
});
var label = Ti.UI.createLabel();
win.add(label);
win.open();

// TODO: write your module tests here
var holograph = require('titutorial.holograph');
Ti.API.info("module is => " + holograph);
Ti.API.info("@@## module PIE_CHART => " + holograph.PIE_CHART);
Ti.API.info("@@## module BAR_CHART => " + holograph.BAR_CHART);
Ti.API.info("@@## module PIE_CHART1 => " + holograph.PIE_CHART1);
Ti.API.info("@@## module BAR_CHART1 => " + holograph.BAR_CHART1);

if (Ti.Platform.name == "android") {
	var proxy = holograph.createExample({
		chartType: "pie",
		top: 100,
		left: 20
	});

	win.add(proxy);
}

