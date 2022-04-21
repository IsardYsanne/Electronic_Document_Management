'use strict';

import "angular";

export default function PersonsController($scope, $http, $rootScope, $timeout, TabsService, PersonsService, CONSTANT_URL) {
    $http.get(CONSTANT_URL.API_URL + "ecm/employees/").then(successResponse, errorResponse);

    function successResponse(response) {
        $scope.persons = response.data;
        PersonsService.setPersons($scope.persons);
        console.log($scope.persons);
    }
    function errorResponse(error) {
        console.log("Ошибка, $scope.persons = " + $scope.persons + error);
    }

    $http.get(CONSTANT_URL.API_URL + "ecm/post/").then(successResponsePost, errorResponsePost);

    function successResponsePost(response) {
        $scope.post = response.data;
        console.log($scope.post);
    }
    function errorResponsePost(error) {
        console.log("Ошибка, $scope.post = " + $scope.post + error);
    }

    $rootScope.$on("PersonEvent", function (event, persons) {
        $scope.persons = persons;
    });

    $scope.switchTab = function (tab) {
        TabsService.addTab(tab);
        $timeout(function () {
            TabsService.switchToTab(tab);
        });
    };
}