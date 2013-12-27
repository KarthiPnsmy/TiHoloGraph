var win = Ti.UI.createWindow({
	backgroundColor : 'white',
	layout : 'vertical'
});

var holograph = require('titutorial.holograph');
var scrollView = Ti.UI.createScrollView({
	layout : 'vertical'
});

var pieChart = holograph.createExample({
	data : [['Heavy Industry', '#99CC00', 12], ['Retail', '#FFBB33', 9], ['Light Industry', '#FE2E2E', 14], ['Out of home', '#0101DF', 16], ['Commuting', '#BCF5A9', 7], ['Orientation', '#BCF5A9', 9]],
	top : 100,
	left : 20
});
scrollView.add(pieChart);

var tmp2 = [['Heavy Industry', '#99CC00', 12], ['Retail', '#FFBB33', 9], ['Light Industry', '#FE2E2E', 14], ['Out of home', '#0101DF', 16]];
var barChart = holograph.createBarChart({
	data : [['Heavy Industry', '#99CC00', 12], ['Retail', '#FFBB33', 9]],
	top : 100,
	left : 20
});
scrollView.add(barChart);

barChart.addEventListener('barClick', function(e) {
	alert("index = " + e.index);
});

var lineData = [{
	"points" : [[0, 6], [8, 9], [10, 5]],
	"lineColor" : "#FFBB33"
}, {
	"points" : [[0, 5], [8, 8], [10, 4]],
	"lineColor" : "#2EFFFF"
}, {
	"points" : [[0, 4], [8, 4], [10, 3]],
	"lineColor" : "red"
}];

var lineChart = holograph.createLineChart({
	data : lineData,
	rangeY : [0, 10],
	lineToFill : 0,
	top : 100,
	left : 20
});
scrollView.add(lineChart);

lineChart.addEventListener('pointClick', function(e) {
	alert("pointIndex = " + e.pointIndex + ", lineIndex = " + e.lineIndex);
});

win.add(scrollView);
win.open();

