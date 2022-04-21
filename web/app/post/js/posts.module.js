'use strict';

import 'angular';

import AllPostsController from "./posts.controller";
import AllPostsComponent from "./posts.component";
import PostService from "./post.service";

let AllPostsModule = angular.module('myApp.posts', ['ngRoute'])
    .component('posts', AllPostsComponent)
    .controller('AllPostsController', ['$scope', '$http', '$timeout', 'TabsService', 'PostService', 'CONSTANT_URL', AllPostsController])
    .service('PostService', ['$rootScope', PostService]);

export default AllPostsModule;