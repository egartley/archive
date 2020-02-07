// GLOBAL VARS
var mobile = "",
	json = {},
	currentChangelog = -1,
	cdn = 'https://core-cdn.egartley.net/',
	appletouchicon = cdn + 'ydfZIggolRifIIneoAGyBiyDvCAKOCpi/png/BjNtdXEYooKEAVnHAOSXncaSsjcaqdTB/apple-touch-icon',
	mstile = cdn + 'ydfZIggolRifIIneoAGyBiyDvCAKOCpi/png/BjNtdXEYooKEAVnHAOSXncaSsjcaqdTB/msTile_',
	stylesheetURL = cdn + 'hZDegfHVLKJvtRDhpPEaXUOGXKRdCnfl/css/rIuengsBdlaxZjcAcZXWNyRCppMqYQDR/',
	preTagURL = cdn + 'toDKkqvpKTgnVhYRkCxWQFSjbFHqoPtJ/gif/XfTeWeSiptIzwZVZegEDYWgOVBqIvwHH/pre.gif',
	chevronDuration = 375;
// REGISTER FUNCTIONS
window.onresize = function(e) {
	screenSizeCheck()
};
$(document).ready(function() {
	run()
});

function run(e) {
	json = {
		build: {
			major: "156",
			minor: 17
		},
		"menu-bar": [{
			string: "Home",
			link: "/"
		}, {
			string: "About",
			link: "/about/"
		}, {
			string: "Contact",
			link: "/contact/"
		}, {
			string: "Projects",
			link: "/projects/"
		}, {
			string: "WHOIS",
			link: "/whois/"
		}],
		footer: [{
			string: "GitHub",
			link: "https://github.com/egartley/net",
			title: "View source code on GitHub"
		}, {
			string: "Privacy",
			link: "/privacy",
			title: "Privacy Policy"
		}],
		contentAuthor: "Evan Gartley",
		baseLink: "https://egartley.net"
	};
	if (isMobile()) {
		mobile = "<link rel='stylesheet' type='text/css' href=''" + stylesheetURL + "'mobile.css'>";
	}
	$('head').append('<base href="' + json.baseLink + '" /><meta name="author" content="' + json.contentAuthor + '" /><meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1" /><meta name="application-name" content="egartley.net" /><meta name="msapplication-TileColor" content="#33a8ff" /><meta name="msapplication-square70x70logo" content="' + mstile + 'small.png" /><meta name="msapplication-square150x150logo" content="' + mstile + 'medium.png" /><meta name="msapplication-wide310x150logo" content="' + mstile + 'wide.png" /><meta name="msapplication-square310x310logo" content="' + mstile + 'large.png" /><meta name="twitter:card" content="summary" /><meta name="twitter:site" content="@egartley" /><meta name="twitter:title" content="egartley.net" /><meta name="twitter:description" content="View this page on egartley.net" /><meta name="twitter:image" content="' + mstile + 'large.png" /><meta name="twitter:image:alt" content="egartley.net" /><link rel="apple-touch-icon" href="' + appletouchicon + '.png" /><link rel="apple-touch-icon" sizes="57x57" href="' + appletouchicon + '-57x57.png" /><link rel="apple-touch-icon" sizes="72x72" href="' + appletouchicon + '-72x72.png" /><link rel="apple-touch-icon" sizes="76x76" href="' + appletouchicon + '-76x76.png" /><link rel="apple-touch-icon" sizes="114x114" href="' + appletouchicon + '-114x114.png" /><link rel="apple-touch-icon" sizes="120x120" href="' + appletouchicon + '-120x120.png" /><link rel="apple-touch-icon" sizes="144x144" href="' + appletouchicon + '-144x144.png" /><link rel="apple-touch-icon" sizes="152x152" href="' + appletouchicon + '-152x152.png" /><link rel="apple-touch-icon" sizes="180x180" href="' + appletouchicon + '-180x180.png" /><link rel="stylesheet" type="text/css" href="' + stylesheetURL + 'style.css">' + mobile);
	menubar(json);
	footer(json);
	screenSizeCheck();
	$("h2").each(function() {
		$(this).html($(this).text().toUpperCase())
	});
}

function isMobile() {
	var e = navigator.userAgent;
	return !!(e.match(/Android/i) || e.match(/webOS/i) || e.match(/iPhone/i) || e.match(/iPod/i) || e.match(/BlackBerry/i) || e.match(/Windows Phone/i))
}

function applyMobileStyling() {
	$("head").append('<link rel="stylesheet" href="' + stylesheetURL + 'mobile.css" id="mcss" type="text/css" />');
	$('span#search-container').hide();
}

function removeMobileStyling() {
	$("#mcss").remove();
	$('span#search-container').show();
}

function screenSizeCheck() {
	var maxWidth = 1080;
	if ($(window).width() < maxWidth && 0 == $("#mcss").length) {
		applyMobileStyling()
	} else if ($(window).width() >= maxWidth) {
		removeMobileStyling()
	}
}

function menubar(data) {
	var list = "",
		page = window.location.pathname.replace(/^\/([^\/]*).*$/, "$1");
	if (0 == page.length) {
		page = "home";
	}
	for (var items = data["menu-bar"], i = 0; i < items.length; i++) {
		var clss = ' class=""',
			item = items[i];
		if (item.link.indexOf(page) !== -1 || (page === "home" && item.link === "/")) {
			clss = ' class="current"';
		}
		list += "<li" + clss + '><a href="' + item.link + '?via=menubar"' + clss + ">" + item.string + "</a></li>";
	}
	$("body").prepend("\n<ul id='bar-items'>" + list + "<span id='search-container'><input onkeyup='inlineSearch(event)' name='inlinesearch' id='inline-search' type='text' placeholder='Looking for something?' value='' size='42' maxlength='128'><a id='search' title='Search this site' href='javascript:void(0)' onclick='toggleInlineSearch()'><svg height='24px' viewBox='0 0 24 24' width='24px'><g fill='none' fill-rule='evenodd' id='miu' stroke='none' stroke-width='1'><g id='a1' transform='translate(-539.000000, -407.000000)''><g id='slice' transform='translate(215.000000, 119.000000)'/><path d='M555.477276,421.355956 C556.43712,419.979383 557,418.305425 557,416.5 C557,411.805579 553.194421,408 548.5,408 C543.805579,408 540,411.805579 540,416.5 C540,421.194421 543.805579,425 548.5,425 C550.305148,425 551.978868,424.437293 553.355321,423.477719 L553.355892,423.477212 L559.659433,429.780753 C559.776309,429.897629 559.962206,429.901225 560.082211,429.78122 L561.78122,428.082211 C561.897838,427.965593 561.892417,427.771097 561.780753,427.659433 L555.477276,421.355956 Z M548.5,423 C552.089851,423 555,420.089851 555,416.5 C555,412.910149 552.089851,410 548.5,410 C544.910149,410 542,412.910149 542,416.5 C542,420.089851 544.910149,423 548.5,423 Z' fill='#fff' id='search'/></g></g></svg></a></span></ul>");
}

function footer(e) {
	for (var items = e.footer, year = "2017", o = e.build, html = "<div id='footer'><a title='View copyright information' href='/privacy/?via=footer'>&#169; " + year + "</a> &#8226; <a title='View recent changes and additions' href='/changelog/?via=footer'>Build " + o.major + "." + o.minor + "</a> &#8226; ", i = 0; i < items.length; i++) {
		var item = items[i];
		html += "<a href='" + item.link + "/?via=footer' title='" + item.title + "'>" + item.string + "</a>";
		if (typeof items[i + 1] !== 'undefined') {
			html += " &#8226; ";
		}
	}
	$("html").append(html + "</div>");
}

function getProject(id, prerelease, desc, title) {
	var html = "<span id='" + id + "'><h2 class='proj'>" + title;
	if (prerelease) {
		html += " <img id='pre' title='This is a pre-release build' src='" + preTagURL + "' alt='pre-release'>";
	}
	$("body").append(html + "</h2>\n<p class='proj'>" + desc + "<br><br><a href='/projects/" + id + "/?via=projectsmodule'>Learn More</a></p><br></span>");
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

function toggletext(changelogContent, link) {
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

function changelog(build, prerelease, description, array, showing) {
	currentChangelog++;
	if ("current" == build) {
		build = "Build " + json.build.major + "." + json.build.minor;
	}
	var html = "<div class='change-log'>\n<p><b style='color:#33a8ff'>" + build + "</b>",
		id = currentChangelog + "_show";
	if (prerelease) {
		html += " <img title='This is a pre-release build' src='" + preTagURL + "' alt='PRE-RELEASE'>";
	}
	var pointing = "down",
		chevronStyle = "";
	if (showing) {
		pointing = "up";
	} else {
		chevronStyle = "transform:rotate(180deg);transform-origin:50% 50% 0";
	}
	html += "<a id='" + id + "' href='javascript:void(0);' onclick=\"toggletext('ul#" + currentChangelog + "', 'a#" + id + "');\"><img id='toggle-img' src='https://core-cdn.egartley.net/JWbfagwmwYPKpNvyoopzzqtWodFrfELa/svg/eJ93a4s1fbvqpllyCg188VNu8i5n82K6/chevron.svg' width='19' height='19' title='Show/hide this changelog' pointing='" + pointing + "' alt='show/hide' style='" + chevronStyle + "'></a><br>" + description + "</p>\n<ul class='change-log' id='" + currentChangelog + "' ";
	if (!showing) {
		html += "style='display:none;' ";
	}
	html += ">";
	for (var list = "", i = 0; i < array.length; i += 1) {
		var item = array[i];
		if (item instanceof Array) {
			list += "<li>" + item[0] + "</li>\n<ul class='change-log' type='disc'>\n";
			for (var ii = 0; ii < item[1].length; ii += 1) {
				list += "<li>" + item[1][ii] + "</li>";
			}
			list += '\n</ul>';
		} else {
			list += "<li>" + item + "</li>\n";
		}
	}
	$('body').append(html + list + "</ul>\n</div>");
}

function getButtonLink(link, text, desc) {
	$('body').append("<div id='button-div'><a href='" + link + "'><button type='button' style='margin-top:8px'>" + text + "</button></a><p id='button-desc'><b>" + desc + "</b></p></div>")
}

function getPageIcon(path) {
	$('body').append("<img id='page-icon' src='https://core-cdn.egartley.net/" + path + "' alt='page icon'>")
}

function projectBackLink(id) {
	$("span#" + id).html("<a href='/projects/?via=projectbacklink'>&#x27F2; Back to all projects</a>")
}

function getURLParameter(parameter) {
	return decodeURIComponent((new RegExp('[?|&]' + parameter + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [null, ''])[1].replace(/\+/g, '%20')) || null;
}

function toggleInlineSearch() {
	$('input#inline-search').animate({
		width: 'toggle',
		opacity: 'toggle'
	}, 350)
}

function inlineSearch(event) {
	var key = event.keyCode || event.which;
	if (13 == key) {
		window.location = "https://egartley.net/search/?q=" + $('input#inline-search').val();
	}
}