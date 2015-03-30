(function($){
    $(function(){

        $('span.hammer').bind('click',function(event) {
            var person = getPersonIdAndName($, $(this));
            strike(person.id,person.name);
        });

        $('span.star').bind('click',function(event) {
            var person = getPersonIdAndName($, $(this));
            punish(person.id, person.name, person.strikeCount);
        });

    });
})(jQuery);

var getPersonIdAndName = function($, $currentElement){
    var $trElement = $currentElement.parents('tr');
    var id = $trElement.data('id');
    var name = $trElement.data('name');
    var strikeCount = $trElement.data('strikeCount');
    return {'id' : id, 'name' : name, 'strikeCount' : strikeCount};
}

var punish = function(personId, name, strikeCount) {
    if(strikeCount < 3){
        alert('The strike count does not satisfy punish count!');
        return;
    }

    if(!confirm('Punish on '+name+'?')) {
        return;
    }

    post('/punish', {
        personId: personId
    })
}

var strike = function(personId, name) {
    if (!confirm('Strike on '+name+'?')) {
        return;
    }

    post('/strike', {
        personId: personId
    });
 }