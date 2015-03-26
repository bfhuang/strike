function strike(personId, name) {
    if (!confirm('Strike on '+name+'?')) {
        return;
    }

    post('/strike', {
        personId: personId
    });
}

function punish(personId, name, strikeCount) {
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