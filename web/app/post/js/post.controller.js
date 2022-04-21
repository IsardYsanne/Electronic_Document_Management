'use strict';

import "angular";

export default function PostController($scope, $http, CONSTANT_URL) {
    $scope.position = {};
    $scope.createPosition = function (position) {
        $http.post(CONSTANT_URL.API_URL + "ecm/post/create", position).then(successResponse, errorResponse);
        function successResponse() {
            $scope.position = {};
            const element = document.querySelector('.post-create__input-form');
            element.insertAdjacentHTML('beforeend', `<p>Красава! Твоя должность успешно создана. :* </p>`)
        }
        function errorResponse(error) {
            console.log(error);
        }
    };
}