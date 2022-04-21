'use strict';

import 'angular';
import 'angular-route';

import TabsController from "./tabs.controller";
import TabsComponent from "./tabs.component";
import TabsService from "./tabs.service";

import "../../style/tabs.less";

let TabsModule = angular.module('myApp.tabs', ['ngRoute'])
    .service('TabsService', ['$rootScope', TabsService])
    .controller('TabsCtrl', ['$scope', '$rootScope', 'TabsService', TabsController])
    .component('tabs', TabsComponent);

export default TabsModule;