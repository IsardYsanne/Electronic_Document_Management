'use strict';

import "angular";

export default function DocumentsFieldsController($scope, $http, $routeParams, CONSTANT_URL) {

    $http.get(CONSTANT_URL.API_URL + 'ecm/document/' + $routeParams.id).then(successResponse, errorResponse);
    function successResponse(response){
        $scope.document = response.data;
        console.log($scope.document);
    }
    function errorResponse(error){
        console.log("Ошибка, $scope.document = " + $scope.document + error);
    }
}