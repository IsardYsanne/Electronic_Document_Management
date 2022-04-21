'use strict';

import 'angular';
import 'angular-route';

import PersonsFieldsController from "./personsFields.controller";

let PersonsFieldsModule = angular.module('myApp.personsFields', ['ngRoute'])
    .controller('PersonsFieldsCtrl', ['$scope', '$http', '$routeParams', '$timeout', 'TabsService', 'PersonsService', 'CONSTANT_URL', PersonsFieldsController])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/employees/:id', {
            template: require("../personsFields.html").default,
            controller: 'PersonsFieldsCtrl'
        });
    }]);

export default PersonsFieldsModule;