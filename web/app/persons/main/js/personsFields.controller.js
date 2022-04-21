'use strict';

import "angular";
import "../../../style/index.less";

export default function PersonsFieldsController($scope, $http, $routeParams, $timeout, TabsService, PersonsService, CONSTANT_URL) {
    $http.get(CONSTANT_URL.API_URL + "ecm/employees/" + $routeParams.id).then(successResponse, errorResponse);

    function successResponse(response) {
        $scope.person = response.data;
        console.log($scope.person);
    }

    function errorResponse(error) {
        console.log("Ошибка, $scope.person = " + $scope.person + error);
    }

    $scope.switchTab = function (tab) {
        TabsService.addTab(tab);
        $timeout(function () {
            TabsService.switchToTab(tab);
        });
    }

    $scope.updatePersons = function () {
        let tab = {
            value: $routeParams.id,
            subject: 'employees/update'
        };
        TabsService.addTab(tab);
        $timeout(function () {
            TabsService.switchToTab(tab);
        });
    }

    $scope.confirmRemoveData = function () {
        confirm("Данные по сотруднику будут безвозвратно удалены, подтвертить:")
        $http.delete(CONSTANT_URL.API_URL + "ecm/employees/delete/" + $routeParams.id);
        TabsService.deleteAndClose($routeParams.id);
        PersonsService.setPersons(PersonsService.persons.filter(function (person) {
            return person.id !== $routeParams.id;
        }));
    }
}