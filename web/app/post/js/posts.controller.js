'use strict';

import "angular";

export default function AllPostsController($scope, $http, $rootScope, $timeout, TabsService, PostService, CONSTANT_URL) {

    $http.get(CONSTANT_URL.API_URL + 'ecm/post/').then(successResponse, errorResponse);

    function successResponse(response) {
        $scope.posts = response.data;
        PostService.setPosts($scope.posts);
        console.log ($scope.posts);
    }
    function errorResponse(error) {
        console.log(error);
    }

    $rootScope.$on("PostEvent", function (event, posts) {
        $scope.posts = posts;
    });

    $scope.switchTab = function (tab) {
        TabsService.addTab(tab);
        $timeout(function () {
            TabsService.switchToTab(tab);
        });
    }
}