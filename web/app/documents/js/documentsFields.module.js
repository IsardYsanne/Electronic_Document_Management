'use strict';

import 'angular';
import 'angular-route';

import DocumentsFieldsController from "./documentsFields.controller";

let DocumentsFieldsModule = angular.module('myApp.documentsFields', ['ngRoute'])
    .controller('DocumentsFieldsCtrl', ['$scope', '$http', '$routeParams', 'CONSTANT_URL', DocumentsFieldsController])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/document/:id', {
            template: require("../documentsFields.html").default,
            controller: 'DocumentsFieldsCtrl'
        });
    }])

export default DocumentsFieldsModule;