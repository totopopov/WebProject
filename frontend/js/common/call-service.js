var app = app || {};

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
                fail(data)
            });
        }
    }
})();



