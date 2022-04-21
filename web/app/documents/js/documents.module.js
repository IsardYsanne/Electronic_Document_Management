'use strict';

import 'angular';

import DocumentsController from "./documents.controller";
import DocumentsComponent from "./documents.component";

let DocumentsModule = angular.module('myApp.documents', ['ngRoute'])
    .component('documents', DocumentsComponent)
    .controller('DocumentsCtrl', ['$scope', '$http', '$timeout', 'CONSTANT_URL', 'TabsService', DocumentsController]);

export default DocumentsModule;