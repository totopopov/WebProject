var app = app || {};


function setrolse() {
    app.callServize.sendGET('/api/get-role', function (data) {
        app.authorizationService.setRole(data);
        app.router.redirect('#/home');
    }, function () {
        console.log('Error loading data')
    });
}



app.authorizationService = (function () {
    let authToken = null;
    let authority = null;

    return {
        getAuth: function () {
            return authToken;
        },
        setAuth: function (auth) {
            authToken = auth;
            setrolse();
        },
        isAuthorized: function () {
            return authToken != null;
        },
        clearAuth: function () {
            authToken = null;
            authority = null;
        },
        setRole: function (role) {
            authority = role;
        },
        getRole: function () {
            return authority;
        },
        isAdmin: function () {
            if (authToken == null || authority == null) {
                return false
            }

            for (let i = 0; i < authority.length; i++) {
                if (authority[i] === 'ROLE_ADMIN') {
                    return true;
                }
            }
            return false;
        }
    }
})();