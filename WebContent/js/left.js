$(document).ready(function() {
	alert
	$("ul").mouseover(function() {
		$("ul>ol").show();
	}).mouseout(function() {
		$("ul>ol").hide();
	});
})
