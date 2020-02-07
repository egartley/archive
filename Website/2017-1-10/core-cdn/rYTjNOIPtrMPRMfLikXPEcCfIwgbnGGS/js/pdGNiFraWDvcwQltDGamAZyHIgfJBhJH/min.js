function r(e) {
	mobi() && (mobile = "<link rel='stylesheet' type='text/css' href=''+su+'mobile.css'>"), $('head').append('<base href="' + e.bl + '" /><meta name="author" content="' + e.ac + '" /><meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1" /><meta name="application-name" content="egartley.net" /><meta name="msapplication-TileColor" content="#33a8ff" /><meta name="msapplication-square70x70logo" content="' + mu + 'small.png" /><meta name="msapplication-square150x150logo" content="' + mu + 'medium.png" /><meta name="msapplication-wide310x150logo" content="' + mu + 'wide.png" /><meta name="msapplication-square310x310logo" content="' + mu + 'large.png" /><meta name="twitter:card" content="summary" /><meta name="twitter:site" content="@egartley" /><meta name="twitter:title" content="egartley.net" /><meta name="twitter:description" content="View this page on egartley.net" /><meta name="twitter:image" content="' + mu + 'large.png" /><meta name="twitter:image:alt" content="egartley.net" /><link rel="apple-touch-icon" href="' + au + '.png" /><link rel="apple-touch-icon" sizes="57x57" href="' + au + '-57x57.png" /><link rel="apple-touch-icon" sizes="72x72" href="' + au + '-72x72.png" /><link rel="apple-touch-icon" sizes="76x76" href="' + au + '-76x76.png" /><link rel="apple-touch-icon" sizes="114x114" href="' + au + '-114x114.png" /><link rel="apple-touch-icon" sizes="120x120" href="' + au + '-120x120.png" /><link rel="apple-touch-icon" sizes="144x144" href="' + au + '-144x144.png" /><link rel="apple-touch-icon" sizes="152x152" href="' + au + '-152x152.png" /><link rel="apple-touch-icon" sizes="180x180" href="' + au + '-180x180.png" /><link rel="stylesheet" type="text/css" href="' + su + 'style.css">' + mobile), menubar(e), footer(e), sc(), $("h2").each(function() {
		var e = $(this).text();
		$(this).html(e.toUpperCase())
	})
}

function getData() {
	var e = {
		b: {
			mj: "156",
			mn: 17
		},
		"menu-bar": [{
			s: "<img src='https://core-cdn.egartley.net/JWbfagwmwYPKpNvyoopzzqtWodFrfELa/svg/zXtumFbuKHgXyzdQjwAymXtoQfIQXvzd/home.svg' style='width:auto;height:auto;margin-bottom:-7px'>",
			l: "/"
		}, {
			s: "About",
			l: "/about/"
		}, {
			s: "Contact",
			l: "/contact/"
		}, {
			s: "Projects",
			l: "/projects/"
		}, {
			s: "WHOIS",
			l: "/whois/"
		}],
		f: [{
			s: "GitHub",
			l: "https://github.com/egartley/net",
			t: "View source code on GitHub"
		}, {
			s: "Privacy",
			l: "/privacy",
			t: "Privacy Policy"
		}],
		ac: "Evan Gartley",
		bl: "https://egartley.net"
	};
	jn = e;
	r(e)
}

function mobi() {
	var e = navigator.userAgent;
	return !!(e.match(/Android/i) || e.match(/webOS/i) || e.match(/iPhone/i) || e.match(/iPod/i) || e.match(/BlackBerry/i) || e.match(/Windows Phone/i))
}

function sc() {
	var e = 1080;
	if ($(window).width() < e && 0 == $("#mcss").length) {
		$("head").append('<link rel="stylesheet" href="' + su + 'mobile.css" id="mcss" type="text/css" />'), $('a#search').attr('href', '/search/').attr('onclick', '')
	} else if ($(window).width() >= e) {
		$("#mcss").remove(), $('a#search').attr('href', 'javascript:void(0)').attr('onclick', 's()')
	}
}

function menubar(e) {
	var t = "",
		n = t,
		o = window.location.pathname.replace(/^\/([^\/]*).*$/, "$1");
	0 == o.length && (o = "home");
	for (var a = e["menu-bar"], i = 0; i < a.length; i++) {
		var c = "",
			l = a[i].l.indexOf(o) !== -1;
		l && "home" !== o ? c = ' class="current"' : "home" == o && "/" == a[i].l && (c = ' class="current"'), n += "<li" + c + '><a href="' + a[i].l + '?via=menubar"' + c + ">" + a[i].s + "</a></li>"
	}
	t += "\n<ul id='bar-items'>" + n + "<span id='search-container'><input onkeyup='ins(event)' name='inlinesearch' id='inline-search' type='text' placeholder='Looking for something?' value='' size='42' maxlength='128'><a id='search' title='Search this site' href='javascript:void(0)' onclick='s()'><svg height='24px' viewBox='0 0 24 24' width='24px'><title/><desc/><defs/><g fill='none' fill-rule='evenodd' id='miu' stroke='none' stroke-width='1'><g id='a1' transform='translate(-539.000000, -407.000000)''><g id='slice' transform='translate(215.000000, 119.000000)'/><path d='M555.477276,421.355956 C556.43712,419.979383 557,418.305425 557,416.5 C557,411.805579 553.194421,408 548.5,408 C543.805579,408 540,411.805579 540,416.5 C540,421.194421 543.805579,425 548.5,425 C550.305148,425 551.978868,424.437293 553.355321,423.477719 L553.355892,423.477212 L559.659433,429.780753 C559.776309,429.897629 559.962206,429.901225 560.082211,429.78122 L561.78122,428.082211 C561.897838,427.965593 561.892417,427.771097 561.780753,427.659433 L555.477276,421.355956 Z M548.5,423 C552.089851,423 555,420.089851 555,416.5 C555,412.910149 552.089851,410 548.5,410 C544.910149,410 542,412.910149 542,416.5 C542,420.089851 544.910149,423 548.5,423 Z' fill='#fff' id='search'/></g></g></svg></a></span></ul>", $("body").prepend(t)
}

function footer(e) {
	for (var t = e.f, n = "2017", o = e.b, a = "<div id='footer'><a title='View copyright information' href='/privacy/?via=footer'>&#169; " + n + "</a> &#8226; <a title='View recent changes and additions' href='/changelog/?via=footer'>Build " + o.mj + "." + o.mn + "</a> &#8226; ", i = 0; i < t.length; i++) {
		var c = t[i];
		a += "<a href='" + c.l + "/?via=footer' title='" + c.t + "'>" + c.s + "</a>", void 0 !== t[i + 1] && (a += " &#8226; ")
	}
	a += "</div>", $("html").append(a)
}

function getProject(e, t, n, o, a, i) {
	var c = "none" !== e,
		l = "<h2 class='proj'>" + a;
	n && (l += " <img id='pre' title='This is a pre-release build' src='" + pgu + "' alt='pre-release'>");
	var r;
	r = c ? "<br><br><a href='" + e + "'>Learn more</a>" : "<br><br><b>Coming Soon!</b>", l += "</h2>\n<p class='proj'>" + o + " " + r + "</p><br>", $("span#" + i).html(l)
}

function toggletext(e, t) {
	0 == $(e).is(":visible") ? ($(t + " img").rotate({
		duration: 450,
		angle: 180,
		animateTo: 0
	}), $(e).slideDown()) : ($(t + " img").rotate({
		duration: 450,
		angle: 0,
		animateTo: 180
	}), $(e).slideUp())
}

function cl(e, t, n, o, a) {
	cc++, "current" == e && (e = "Build " + jn.b.mj + "." + jn.b.mn);
	var c = "<div class='change-log'>\n<p><b style='color:#33a8ff'>" + e + "</b>",
		l = cc + "_show";
	t && (c += " <img title='This is a pre-release build' src='" + pgu + "' alt='pre-release'>"), c += "<a id='" + l + "' href='javascript:void(0);' onclick=\"toggletext('ul#" + cc + "', 'a#" + l + "');\"><img id='toggle-img' src='https://core-cdn.egartley.net/toDKkqvpKTgnVhYRkCxWQFSjbFHqoPtJ/gif/XfTeWeSiptIzwZVZegEDYWgOVBqIvwHH/plus.gif' width='19' height='19' title='Show/hide this changelog' alt='show/hide'></a><br>" + n + "</p>\n<ul class='change-log' id='" + cc + "' ", a || (c += "style='display:none;' "), c += ">";
	for (var r = "", p = 0; p < o.length; p += 1) {
		var s = o[p];
		if (s instanceof Array) {
			r += "<li>" + s[0] + "</li>\n<ul class='change-log' type='disc'>\n";
			for (var g = 0; g < s[1].length; g += 1) r += "<li>" + s[1][g] + "</li>";
			r += '\n</ul>'
		} else r += "<li>" + s + "</li>\n"
	}
	r += "</ul>\n</div>", c += r, $('body').append(c)
}

function getButtonLink(e, t, n) {
	$('body').append("<div id='button-div'><a href='" + e + "'><button type='button' style='margin-top:8px'>" + t + "</button></a><p id='button-desc'><b>" + n + "</b></p></div>")
}

function getPageIcon(e) {
	$('body').append("<img id='page-icon' src='https://core-cdn.egartley.net/" + e + "' alt='page-icon' title='Icon for this page'>")
}

function projectBackLink(e) {
	$("span#" + e).html("<a href='/projects/?via=projectbacklink'>&#x27F2; Back to all projects</a>")
}

function gup(name) {
	return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [null, ''])[1].replace(/\+/g, '%20')) || null;
}

function s() {
	$('input#inline-search').animate({
		width: 'toggle',
		opacity: 'toggle'
	}, 350)
}

function ins(e) {
	var t = e.keyCode || e.which;
	if (13 == t) {
		window.location = "https://egartley.net/search/?q=" + $('input#inline-search').val()
	}
}
var mobile = "",
	jn = {},
	cc = -1,
	au = 'https://core-cdn.egartley.net/ydfZIggolRifIIneoAGyBiyDvCAKOCpi/png/BjNtdXEYooKEAVnHAOSXncaSsjcaqdTB/apple-touch-icon',
	mu = 'https://core-cdn.egartley.net/ydfZIggolRifIIneoAGyBiyDvCAKOCpi/png/BjNtdXEYooKEAVnHAOSXncaSsjcaqdTB/msTile_',
	su = 'https://core-cdn.egartley.net/hZDegfHVLKJvtRDhpPEaXUOGXKRdCnfl/css/rIuengsBdlaxZjcAcZXWNyRCppMqYQDR/',
	pgu = 'https://core-cdn.egartley.net/toDKkqvpKTgnVhYRkCxWQFSjbFHqoPtJ/gif/XfTeWeSiptIzwZVZegEDYWgOVBqIvwHH/pre.gif';
window.onresize = function(e) {
	sc()
}, $(document).ready(function() {
	getData(), $("div#overlay").delay(410).fadeOut('fast')
});