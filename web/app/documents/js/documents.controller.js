'use strict';

import MyImage from "../../img/up-arrow-svgrepo-com.svg";

export default function DocumentsController($scope, $http, $timeout, TabsService, CONSTANT_URL) {
    $scope.img = MyImage;

    $http.get(CONSTANT_URL.API_URL + 'ecm/document/').then(successResponse, errorResponse);
    function successResponse(response) {
        $scope.documents = response.data;
        console.log($scope.documents);
    }
    function errorResponse(error) {
        console.log("Ошибка, $scope.documents = " + $scope.documents + error);
    }

    $scope.switchTab = function (tab) {
        TabsService.addTab(tab);
        $timeout(function () {
            TabsService.switchToTab(tab);
        });
    }
}