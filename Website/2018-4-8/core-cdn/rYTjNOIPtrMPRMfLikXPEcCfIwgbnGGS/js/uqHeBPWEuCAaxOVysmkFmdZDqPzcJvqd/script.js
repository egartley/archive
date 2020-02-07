var chevronDuration = 375;

function navigate(link) {
	if (link.indexOf('/') == 0)
		window.location = "https://egartley.net" + link
	else
		window.location = link
}

function search() {
	var extendedURL = "/search/?q=" + $('.widget-search-textbox').val();
	navigate(extendedURL)
}

function getURLParameter(parameter) {
	return decodeURIComponent((new RegExp('[?|&]' + parameter + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [null, ''])[1].replace(/\+/g, '%20')) || null;
}

function press(e) {
	var key = e.keyCode || e.which;
	if (13 == key) {
		search()
	}
}

function animateChevron(element, direction, instant) {
	var a = 180,
		aa = 0,
		d = chevronDuration;
	if (direction == "up") {
		a = 0;
		aa = 180;
	}
	if (instant) {
		d = 1;
	}
	element.rotate({
		duration: chevronDuration,
		angle: a,
		animateTo: aa
	});
}

function showHide(changelogContent, link) {
	var img = $(link + " img"),
		content = $(changelogContent);
	var direction = img.attr("pointing");
	if (img.attr("pointing") == "down") {
		animateChevron(img, direction, false);
		content.slideDown();
		img.attr("pointing", "up");
	} else {
		animateChevron(img, direction, false);
		content.slideUp();
		img.attr("pointing", "down");
	}
}