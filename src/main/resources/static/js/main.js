
var messageApi = Vue.resource('messages{/id}');

// Vue.component('message-row', {
//     props: ['message_1'],
//     template: '<div>{{message_1.id}} - {{message_1.textMessage}}</div>'
// })

Vue.component('messages-list277',{
    props: ['messages'],
    template: '<div>' +
        '<div> v-for="m in messages" :key="m.id" :message_1="m"></div>' +
        '</div>',
    created: function () {
        messageApi.get().then(result =>
            result.json().then(data =>
                data.forEach(message => this.messages.push(message))

            )
        )
    },
});

// Vue.component('messages-list277',{
//     props: ['messages'],
//     template: '<div><message-row v-for="m in messages" :key="m.id" :message_1="m"/></div>',
//     created: function () {
//         messageApi.get().then(result =>
//             result.json().then(data =>
//                 data.forEach(message => this.messages.push(message))
//
//             )
//         )
//     },
// });

var app = new Vue({
    el: '#app',
    template: '<messages-list277 :messages="messages"/>',
    data: {
        messages: [

        ]
    }
});