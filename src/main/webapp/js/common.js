function post(url, params) {
    var form = document.createElement('form');
    form.method = 'post';
    form.action = url;

    for (var name in params) {
        var hidden = document.createElement('input');
        hidden.type = 'hidden';
        hidden.name = name;
        hidden.value = params[name];
        form.appendChild(hidden);
    }
    document.body.appendChild(form);
    form.submit();
}