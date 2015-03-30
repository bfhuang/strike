(function($){
    $(function(){

        $('span.hammer').bind('click',function(event) {
            var person = getPersonInformation($, $(this));
            strike(person);
        });

        $('span.star').bind('click',function(event) {
            var person = getPersonInformation($, $(this));
            punish(person);
        });

    });
})(jQuery);

var getPersonInformation = function($, $currentElement){
    var $trElement = $currentElement.closest('tr');

    var id = $trElement.data('id');
    var name = $trElement.children('td.personName').text();
    var strikeCount = parseInt($trElement.children('td.strikeCount').text());
    var numberOfStar = $trElement.children('td.stars>img').length;

    return {
                'id' : id,
                'name' : name,
                'strikeCount' : strikeCount,
                'numberOfStar' : numberOfStar
           };
}

var punish = function(person) {
    if(person.strikeCount < 3){
        alert('The strike count does not satisfy punish count!');
        return;
    }

    if(!confirm('Punish on ' + person.name + '?')) {
        return;
    }

    $.post('/punish', {'personId': person.id }, function(responseData, status, xhr) {
        if(status === 'success') {
            var newStrikeCount = person.strikeCount - 3;
            $('#person_' + person.id + ' td.strikeCount').text(newStrikeCount);
            $('<img>',{src: 'img/tools/star.png'}).appendTo('#person_' + person.id + ' td.stars');
        }
    });
}

var strike = function(person) {
    if (!confirm('Strike on ' + person.name + '?')) {
        return;
    }

    $.post('/strike', {'personId': person.id}, function(responseData, status, xhr) {
        if(status === 'success') {
            var newStrikeCount = person.strikeCount + 1;
            $('#person_' + person.id + ' td.strikeCount').text(newStrikeCount);
        }
    });
}