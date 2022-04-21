'use strict';

import 'angular';
import 'angular-route';

import PersonsController from "./persons.controller";
import PersonsComponent from "./persons.component";
import TabsService from "../../../tabs/js/tabs.service";
import PersonsService from "./persons.service";

let PersonsModule = angular.module('myApp.persons', ['ngRoute'])
    .component('persons', PersonsComponent)
    .controller('PersonsCtrl', ['$scope', '$http', '$rootScope', '$timeout', 'TabsService' , 'PersonsService', PersonsController])
    .service('PersonsService', ['$rootScope', PersonsService]);

export default PersonsModule;