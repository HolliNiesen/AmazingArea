$(document).ready(function() {
    makeAjaxRequest("http://numbersapi.com/random/trivia", function(request) {
        document.getElementById("mathFact").appendChild(document.createTextNode(request.responseText));
    });
});

function makeAjaxRequest(url, callback) {
    var request = new XMLHttpRequest();
    request.open("GET", url);

    request.onreadystatechange = function() {
        if(request.readyState == 4 && request.status == 200) {
            callback(request);
        }
    };
    request.send(null);
}
