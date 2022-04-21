'use strict';

import 'angular';
import 'angular-route';

import './persons/main/js/persons.module';
import './persons/create/js/personCreate.module';
import './persons/main/js/personsFields.module';
import './persons/update/js/personUpdate.module';
import './documents/js/documents.module';
import './documents/js/documentsFields.module';
import './tabs/js/tabs.module';
import './post/js/post.module';
import './post/js/posts.module';
import './post/js/postsInfo.module';

import './app.less'

angular.module('myApp', [
    'ngRoute',
    'myApp.persons',
    'myApp.personCreate',
    'myApp.personUpdate',
    'myApp.personsFields',
    'myApp.documents',
    'myApp.documentsFields',
    'myApp.tabs',
    'myApp.post',
    'myApp.posts',
    'myApp.postInfo'
]).config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $locationProvider.hashPrefix('!');
    $routeProvider.otherwise({redirectTo: ''});
}]).constant('CONSTANT_URL', {
    API_URL: "http://192.168.1.41:8081/"
});
