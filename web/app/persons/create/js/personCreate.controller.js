'use strict';

import "angular";

export default function PersonCreateController($scope, $http, PersonsService, CONSTANT_URL) {
    $scope.person = {};

    $scope.posts = function getPosts() {
        $http.get(CONSTANT_URL.API_URL + "ecm/post/").then(successResponse, errorResponse);
        function successResponse(response){
            $scope.positions = response.data;
        }
        function errorResponse(error){
            console.log("Ошибка, $scope.positions = " + $scope.positions + error);
        }
    }

    $scope.posts();

    $scope.createPerson = function (person) {
        let avatar = document.querySelector('#avatar').files[0];
        if (avatar === undefined) {
            let element = document.querySelector('.person-create__form');
            element.insertAdjacentHTML('beforeend', `<p style="color: #7a1f17; margin: 5px 0;">Загрузите фотку, please</p>`);
        }
        let fileReader = new FileReader();
        fileReader.readAsDataURL(avatar);
        fileReader.onloadend = function () {
        person.photo = fileReader.result.replace("data:", "").replace(/^.+,/, "");
        $http.post(CONSTANT_URL.API_URL + "ecm/employees/create", person).then(successResponseCreate, errorResponseCreate);
        function successResponseCreate(response){
            $scope.person = {};
            $scope.position = {};
            let employees = PersonsService.persons;
            let employeeData = response.data;
            employees.push(employeeData);
            PersonsService.setPersons(employees);
            let element = document.querySelector('.person-create__container');
            element.insertAdjacentHTML('beforeend', `<p style="color: #140c34; margin: 5px 0;">Сотрудник создан</p>`)
        }
        function errorResponseCreate(error){
            console.log(error);
        }}
    };
}