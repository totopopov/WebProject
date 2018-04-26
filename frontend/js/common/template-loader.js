var app = app || {};


function loadNavbar() {
    if (app.authorizationService.isAuthorized()) {


        if (app.authorizationService.isAdmin()) {
            app.templateLoader.loadTemplate('.navbar-holder', 'navbar-admin', function () {
            });
        } else {
            app.templateLoader.loadTemplate('.navbar-holder', 'navbar-logged', function () {
            });
        }

        console.log(app.authorizationService.isAdmin());

        $('#logout-button').click(function (e) {
            e.preventDefault();

            app.authorizationService.clearAuth();
            app.router.redirect('#/');
        });
    } else {
        app.templateLoader.loadTemplate('.navbar-holder', 'navbar');
    }
}

app.templateLoader = (function templateLoader() {
    return {
        loadTemplate: function (element, template, callback) {
            $(element).empty();

            if (element === '.app') {
                loadNavbar();
            }

            $.get('fragments/' + template + '.html').then((template) => {
                $(element).html(template);
                if (callback) callback();
            }).catch((error) => {
                console.log("Error loading template!");
                console.log("Error: " + error);
            })
        }
    }
})();