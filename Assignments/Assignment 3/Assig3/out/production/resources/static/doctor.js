$(function() {
    'use strict';

    var client;

    function showMessage(notification)
    {

        $('#messages').append('<tr>' +
            '<td>' + notification.patientName + '</td>' +
            '<td>' + notification.doctorUsername + '</td>' +
            '<td>' + notification.dateOfConsultation + '</td>' +
            '</tr>');
    }


    $(document).ready(function connect(){
        client = Stomp.over(new SockJS('/notification'));
        client.connect({}, function (frame) {
            $("#conversation").show();
            $('#text').focus();
            client.subscribe('/topic/messages', function (message) {
                showMessage(JSON.parse(message.body));
            });
        });
    });
});