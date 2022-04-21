'use strict';

import "angular";

export default function PersonsUpdateController($scope, $http, $routeParams, PersonsService, CONSTANT_URL) {

    $scope.person = {};

    getData();

    function getPosts() {
        $http.get(CONSTANT_URL.API_URL + "ecm/post/").then(successResponse, errorResponse);
        function successResponse(response){
            $scope.positions = response.data;
        }
        function errorResponse(error){
            console.log("Ошибка, $scope.positions = " + $scope.positions + error);
        }
    }

    function getData() {
        $http.get(CONSTANT_URL.API_URL + "ecm/employees/" + $routeParams.id).then(successResponseData, errorResponseData);

        function successResponseData(response){
            $scope.person = response.data;
            $scope.person.position = null;
        }
        function errorResponseData(error){
            console.log(error);
        }
        getPosts();
    }

    $scope.updatePerson = function (person) {
        let avatar = document.querySelector('#avatar').files[0];
        if (avatar === undefined) {
            let element = document.querySelector('.person-create__form');
            element.insertAdjacentHTML('beforeend', `<p style="color: #7a1f17; margin: 5px 0;">Загрузите фотку, please</p>`);
        }
        let fileReader = new FileReader();
        fileReader.readAsDataURL(avatar);
        fileReader.onloadend = function () {
            person.photo = fileReader.result.replace("data:", "").replace(/^.+,/, "");
            person.id = $routeParams.id;
            $http.put(CONSTANT_URL.API_URL + "employees/update/" + $routeParams.id, person).then(successResponseUpdate, errorResponseUpdate);
            function successResponseUpdate(response){
                let employees = PersonsService.persons.map(function (employee) {
                    if (employee.id === $routeParams.id) {
                        return  response.data;
                    } else {
                        return employee;
                    }
                });
                PersonsService.setPersons(employees);
                let element = document.querySelector('.person-update__container');
                element.insertAdjacentHTML('beforeend', `<p style="color: #140c34; margin: 5px 0;">Сотрудник отредактирован</p>`)
            }
            function errorResponseUpdate(error){
                console.log(error);
            }
        };
    }
}