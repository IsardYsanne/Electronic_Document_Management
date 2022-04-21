'use strict';

import "angular";

import CloseImg from "../../img/cross.png";

export default function TabsController($scope, $rootScope, TabsService) {
    $scope.cross = CloseImg;
    $scope.tabs = TabsService.tabs;
    $rootScope.$on("TabEvent", function (event, tabs) {
        $scope.tabs = tabs;
    })
    $scope.closeTab = function (tab) {
        TabsService.deleteTab(tab);
    }
    $scope.switchToTab = function (tab) {
        TabsService.switchToTab(tab);
    }
}