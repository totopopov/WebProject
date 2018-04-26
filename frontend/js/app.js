let constants = {
    serviceUrl: "http://localhost:8080"
};

let confirmPasswordCheckStatusOk = false;
let passwordCheckStatusOk = false;
let nameStatusOk = false;

let registerFormStatus = confirmPasswordCheckStatusOk && passwordCheckStatusOk && nameStatusOk;

function refreshRegisterForm() {
    registerFormStatus = confirmPasswordCheckStatusOk && passwordCheckStatusOk && nameStatusOk;
    console.log('form status' + registerFormStatus);
}


function inspectRolesForAdmin(roles) {
    for (let i = 0; i < roles.length; i++) {
        if (roles[i] === 'ROLE_ADMIN') {
            return true;
        }
    }
    return false;
}

class errorChecker {
    constructor(value, message) {
        this.value = value;
        this.message = message;
    }
}

function showEror(xhr) {
    if (xhr == null) {
        xhr = {status: "Server error ! Can't reach server."}
    }

    new Noty({
        text: 'ERROR [' + xhr['status'] + ']: ' + xhr['responseText'],
        layout: 'topCenter',
        type: 'error',
        theme: 'mint',
        timeout: 3000
    }).show();
}


function checkConfirmPasswordField(passwordField, confirmPassword, registerButton) {
    let confirmCheck = new errorChecker(passwordField.val() !== confirmPassword.val(), "Passwords do not match");

    if (confirmCheck.value) {
        confirmPasswordCheckStatusOk = false;
        registerButton.addClass('disabled');

        let notification = $('<div class="notification"><span class="notification text-danger">' + confirmCheck.message + '</span></div>');
        if (confirmPassword.parent().children('.notification').length === 0) {
            notification.appendTo(confirmPassword.parent());
        }

    } else {
        confirmPasswordCheckStatusOk = true;
        refreshRegisterForm();
        if (registerFormStatus) {
            registerButton.removeClass('disabled');
        }

        if (confirmPassword.parent().has('.notification').length !== 0) {
            (confirmPassword.parent().children('.notification')).remove();
        }

    }
}

function checkPasswordField(passwordField, registerButton) {

    let errorChecked = [];
    let passwordLenght = new errorChecker(passwordField.val().length < 8, "Password should be at least 8 digits");
    let containsUpperCase = new errorChecker(!/(?=.*[A-Z]).+/.test(passwordField.val()), "Password must contain UpperCase charachter");
    let containsLowerCase = new errorChecker(!/(?=.*[a-z]).+/.test(passwordField.val()), "Password must contain LowerCase charachter");
    let containsDigit = new errorChecker(!/(?=.*[0-9]).+/.test(passwordField.val()), "Password must contain a digit");

    errorChecked.push(passwordLenght);
    errorChecked.push(containsUpperCase);
    errorChecked.push(containsLowerCase);
    errorChecked.push(containsDigit);

    if (passwordLenght.value || containsUpperCase.value || containsLowerCase.value || containsDigit.value) {
        passwordCheckStatusOk = false;
        registerButton.addClass('disabled');

        for (let errorCheckerElement of errorChecked) {

            if (errorCheckerElement.value) {

                let notification = $('<div class="notification  text-danger"><span class="notification">' + errorCheckerElement.message + '</span></div>');
                if (passwordField.parent().children('.notification').length === 0) {
                    notification.appendTo(passwordField.parent());
                } else {
                    passwordField.parent().children('.notification').text(errorCheckerElement.message)
                }

                break;
            }
        }
    } else {
        passwordCheckStatusOk = true;
        refreshRegisterForm();
        if (registerFormStatus) {
            registerButton.removeClass('disabled');
        }
        if (passwordField.parent().has('.notification').length !== 0) {
            passwordField.parent().children('.notification').remove();
        }
    }
}

function checkNameField(nameField, registerButton) {
    let confirmCheck = new errorChecker(!/(.){4,20}/.test(nameField.val()), "Name should be between 4 and 20 charachters");

    if (confirmCheck.value) {
        nameStatusOk = false;
        registerButton.addClass('disabled');

        let notification = $('<div class="notification"><span class="notification text-danger">' + confirmCheck.message + '</span></div>');
        if (nameField.parent().children('.notification').length === 0) {
            notification.appendTo(nameField.parent());
        }

    } else {
        nameStatusOk = true;
        refreshRegisterForm();
        if (registerFormStatus) {
            registerButton.removeClass('disabled');
        }

        if (nameField.parent().has('.notification').length !== 0) {
            (nameField.parent().children('.notification')).remove();
        }

    }

}

function renderRowForAdminUserTable(entry) {
    let username = entry['username'];
    let userRole = entry['simpleRoles'];
    let userEnabled = entry['enabled'];

    let role = inspectRolesForAdmin(userRole);

    let row = $('#' + username);
    row = (row.length === 0 ? $('<tr id="' + username + '"></tr>') : row);
    let rowName = $('<td>' + username + '</td>');
    let rowRole = $('<td>' + (role ? 'admin' : 'user') + '</td>');
    let rowEnabled = $('<td>' + (userEnabled ? 'active' : 'deleted') + '</td>');

    let buttonPromote = $('<a href="#/admin/' +
        (role ? 'demote' : 'promote')
        + '?id=' + username + '" class="btn btn-'+(role ? 'warning' : 'danger')+' btn-sm" role="button">' +
        (role ? 'Demote Admin' : 'Promote to Admin')
        + '</a>');

    let rowActions = $('<td></td>');
    rowActions.append(buttonPromote);
    row.append(rowName);
    row.append(rowRole);
    row.append(rowEnabled);
    row.append(rowActions);
    return row;
}

app.router.on("#/", null, function () {

    console.log('request url #/ ');

    if (app.authorizationService.isAuthorized()) {
        console.log('does redirect' + app.authorizationService.isAuthorized());
        app.router.redirect('#/home');
        return;
    }
    console.log(' does not redirect ' + app.authorizationService.isAuthorized());
    app.templateLoader.loadTemplate('.app', 'guest-home');
});

app.router.on("#/home", null, function () {


    if (!app.authorizationService.isAuthorized()) {
        app.router.redirect('#/');
        return;

    }
    app.templateLoader.loadTemplate('.app', 'home', function () {
    });
});

app.router.on("#/logout", null, function () {
    if (app.authorizationService.isAuthorized()) {
        app.authorizationService.clearAuth();
    }
    app.router.redirect('#/');
});


app.router.on("#/admin/users", null, function () {


    //handle error
    if (!app.authorizationService.isAdmin()) {
        app.router.redirect('#/');
        return;

    }
    app.templateLoader.loadTemplate('.app', 'users', function () {
            app.callServize.sendGET('/admin/users', function (data) {

                console.log(data);

                let tableBody = $('#table-users-admin');

                for (let entry of data) {

                    let row = renderRowForAdminUserTable(entry);
                    tableBody.append(row);
                }

            }, function (xhr, status, error) {

                showEror(xhr);

            });
        }
    );

});


app.router.on("#/admin/promote", ['id'], function (id) {

    if (!app.authorizationService.isAdmin()) {
        app.router.redirect('#/');
        return;

    }


    app.callServize.sendGET('/admin/promote/' + id, function (data) {


        let tableBody = $('#table-users-admin');

        let row = renderRowForAdminUserTable(data);

        tableBody.append(row);

    }, function (xhr, status, error) {

        showEror(xhr);

    });


});

app.router.on("#/login", null, function () {


    if (app.authorizationService.isAuthorized()) {
        app.router.redirect('#/home');
        return;
    }

    app.templateLoader.loadTemplate('.app', 'login', function () {

        let loginButton = $('#login-button');
        let nameField = $('#username');
        let passwordField = $('#password');

        nameField.keyup(function () {
        });

        passwordField.keyup(function () {
            loginButton.removeClass('disabled');
        });


        function login(ev) {
            ev.preventDefault();

            let username = $('#username').val();
            let password = $('#password').val();

            $.ajax({
                type: 'POST',
                url: constants.serviceUrl + '/login',
                headers: {
                    "Content-Type": "application/json"
                },
                data: JSON.stringify({
                    "username": username,
                    "password": password
                })
            }).done(function (body) {

                new Noty({
                    text: 'Login Successful',
                    layout: 'topCenter',
                    type: 'success',
                    theme: 'mint',
                    timeout: 3000
                }).show();

                let auth = body["Authorization"];
                app.authorizationService.setAuth(auth);

            }).fail(function (data) {
                console.log('fail');
                console.log(data);
                new Noty({
                    text: 'ERROR: There was an error with your login.',
                    layout: 'topCenter',
                    type: 'error',
                    theme: 'mint',
                    timeout: 3000
                }).show();
            });
        }


        loginButton.click(function (ev) {
            login(ev);
            $(this).addClass('disabled');
        });

        $(document).keypress(function (ev) {
            if (ev.which === 13) {
                loginButton.click();
            }
        });
    });
});


app.router.on("#/register", null, function () {
    if (app.authorizationService.isAuthorized()) {
        app.router.redirect('#/home');
        return;
    }

    app.templateLoader.loadTemplate('.app', 'register', function () {


        let nameField = $('#username');
        let passwordField = $('#password');
        let registerButton = $('#register-button');
        let confirmPassword = $('#password-confirm');


        let timer = null;

        passwordField.keyup(function (e) {
            clearTimeout(timer);
            timer = setTimeout(checkPasswordField(passwordField, registerButton), 1000)
        });

        nameField.keyup(function (e) {
            clearTimeout(timer);
            timer = setTimeout(checkNameField(nameField, registerButton), 1000)
        });


        confirmPassword.keyup(function (e) {
            clearTimeout(timer);
            timer = setTimeout(checkConfirmPasswordField(passwordField, confirmPassword, registerButton), 1000);
        });


        function register(ev) {
            ev.preventDefault();
            let username = $('#username').val();
            let password = $('#password').val();
            let passwordConfirm = $('#password-confirm').val();

            $.ajax({
                type: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                url: constants.serviceUrl + '/register',
                cache: false,
                data: JSON.stringify({
                    "username": username,
                    "password": password,
                    "confirmPassword": passwordConfirm
                })
            }).done(function (data) {

                new Noty({
                    text: 'Registration Successful',
                    layout: 'topCenter',
                    type: 'success',
                    theme: 'mint',
                    timeout: 3000
                }).show();

                app.router.redirect('#/login');

            }).fail(function (xhr, status, error) {
                showEror(xhr);
            });
        }


        registerButton.click(function (ev) {
            if (registerButton.hasClass('disabled')) {
                return;
            }
            register(ev);
            $(this).addClass('disabled');
        });

        $(document).keypress(function (e) {
            if (e.which === 13) {
                registerButton.click();
            }
        });
    });
});




window.location.href = '#/';


window.onbeforeunload = function (window) {
    let route = '#/home';
    if (window.location != null) {
        route = window.location.href;
    }

    return route;
};