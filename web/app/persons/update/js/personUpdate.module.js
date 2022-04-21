'use strict';

import 'angular';
import 'angular-route';

import PersonsUpdateController from "./personUpdate.controller";

let PersonsUpdateModule = angular.module('myApp.personUpdate', ['ngRoute'])
    .controller('PersonsUpdateCtrl', ['$scope', '$http', '$routeParams', 'PersonsService', 'CONSTANT_URL', PersonsUpdateController])
    .config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/employees/update/:id', {
        template: require("../personUpdate.html").default,
        controller: 'PersonsUpdateCtrl'
    });
}])
export default PersonsUpdateModule;