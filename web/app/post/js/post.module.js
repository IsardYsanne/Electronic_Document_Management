'use strict';

import 'angular';
import 'angular-route';

import PostController from "./post.controller";

let PostModule = angular.module('myApp.post', ['ngRoute'])
    .controller('PostCtrl', ['$scope', '$http', 'CONSTANT_URL', PostController])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/post/create', {
            template: require("../post.html").default,
            controller: 'PostCtrl'
        });
    }]);

export default PostModule;