'use strict';

import 'angular';
import 'angular-route';

import PersonCreateController from "./personCreate.controller";

let PersonCreateModule = angular.module('myApp.personCreate', ['ngRoute'])
    .controller('PersonCreateCtrl', ['$scope', '$http', 'PersonsService', 'CONSTANT_URL', PersonCreateController])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/employees/create', {
            template: require("../personCreate.html").default,
            controller: 'PersonCreateCtrl'
        });
    }]);

export default PersonCreateModule;