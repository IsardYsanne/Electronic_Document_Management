'use strict';

import 'angular';
import 'angular-route';

import PostInfoController from "./postsInfo.controller";

let PostInfoModule = angular.module('myApp.postInfo', ['ngRoute'])
    .controller('PostInfoController', ['$scope', '$http', '$routeParams', 'TabsService', 'PostService', 'CONSTANT_URL', PostInfoController])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/post/:id', {
            template: require("../postInfo.html").default,
            controller: 'PostInfoController'
        });
    }]);

export default PostInfoModule;