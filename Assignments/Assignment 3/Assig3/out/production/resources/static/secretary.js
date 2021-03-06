$(function() {
    'use strict';

    var client;
    $(document).ready(function connect(){
        client = Stomp.over(new SockJS('/notification'));
        client.connect({}, function (frame) {
            client.subscribe('/topic/messages', function (message) {
            });
        });
    });

    $('#create').click(function() {
        var topic = $('#topic').val();
        client.send("/app/notification/" + topic, {}, JSON.stringify({
            patientId: $("#patient").val(),
            doctorId: $('#doctor').val(),
            dateOfConsultation: $('#date').val()
        }));
    });
});