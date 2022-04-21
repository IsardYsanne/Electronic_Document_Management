'use strict';

import "angular";

export default function PostInfoController($scope, $http, $routeParams, TabsService, PostService, CONSTANT_URL) {

    $http.get(CONSTANT_URL.API_URL + 'ecm/post/' + $routeParams.id).then(successResponse, errorResponse);
    function successResponse(response){
        $scope.posts = response.data;
        console.log($scope.posts);
    }
    function errorResponse(error){
        console.log(error);
    }

    $scope.confirmRemovePost = function () {
        confirm("Данные по должности будут безвозвратно удалены, подтвертить:")
        $http.delete(CONSTANT_URL.API_URL + "ecm/post/delete/" + $routeParams.id);
        TabsService.deleteAndClose($routeParams.id);
        PostService.setPosts(PostService.posts.filter(function (post) {
            return post.id !== $routeParams.id;
        }));
    }
}