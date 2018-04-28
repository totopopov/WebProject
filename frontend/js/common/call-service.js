var app = app || {};

function logOutUser(data) {
    if (data['status'] === 403) {
        app.authorizationService.clearAuth();
        showEror(data);
    }

    if (data['status'] === 418) {
        showEror(data);
    }
}

app.callServize = (function callServize() {

    return {
        sendGET: function (url, done, fail) {
            console.log('called service');
            $.ajax({
                type: 'GET',
                headers: {
                    'Authorization': app.authorizationService.getAuth()
                },
                url: constants.serviceUrl + url
            }).done(data => {
                done(data);
            }).fail((data) => {
                logOutUser(data);
                fail(data)
            });
        },
        sendPOST: function (url, sendData, done, fail) {
            console.log('called service');
            $.ajax({
                type: 'POST',
                headers: {
                    'Authorization': app.authorizationService.getAuth(),
                    'Content-Type': 'application/json'

                },
                cache: false,
                url: constants.serviceUrl + url,
                data: sendData
            }).done(data => {
                done(data);
            }).fail((data) => {
                logOutUser(data);

                fail(data)
            });
        }
    }
})();



