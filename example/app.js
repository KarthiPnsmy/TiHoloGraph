// This is a test harness for your module
// You should do something interesting in this harness
// to test out the module and to provide instructions
// to users on how to use it by example.

// open a single window
var win = Ti.UI.createWindow({
	backgroundColor : 'white',
	layout : 'vertical'
});

var holograph = require('titutorial.holograph');
Ti.API.info("module is => " + holograph);

var pieChart = holograph.createExample({
	data : [['Heavy Industry', '#99CC00', 12], ['Retail', '#FFBB33', 9], ['Light Industry', '#FE2E2E', 14], ['Out of home', '#0101DF', 16], ['Commuting', '#BCF5A9', 7], ['Orientation', '#BCF5A9', 9]],
	top : 100,
	left : 20
});
win.add(pieChart); 

var tmp2 = [['Heavy Industry', '#99CC00', 12], ['Retail', '#FFBB33', 9], ['Light Industry', '#FE2E2E', 14], ['Out of home', '#0101DF', 16]];
var barChart = holograph.createBarChart({
	data : [['Heavy Industry', '#99CC00', 12], ['Retail', '#FFBB33', 9]],
	top : 100,
	left : 20
});
//barChart.setBars(tmp2);
win.add(barChart);

barChart.addEventListener('barClick', function(e){
	alert("index = "+e.index);
});

var tmp = [['Heavy Industry', '#99CC00', 12], ['Retail', '#FFBB33', 9]];
//barChart.setBars(tmp);

win.open();


