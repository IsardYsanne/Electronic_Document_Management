"use strict";

let TabsService = function ($rootScope) {
    this.switchToTab = function (tab) {
        let opendTab = document.getElementsByClassName("_active")[0];
        let element = document.getElementById(tab.subject + tab.value);
        element.classList.add("_active");
        window.location.href = "#!/" + tab.subject + "/" + tab.value;
        opendTab ? opendTab.classList.remove("_active") : 1;
    }
    this.tabs = [];
    this.openTabs = function (tabs) {
        this.tabs = tabs;
        $rootScope.$emit('TabEvent', this.tabs);
    }
    this.addTab = function (tab) {
        if (!this.tabs.some( function (element) {
            return element.value === tab.value && element.subject === tab.subject;
        })) {
            this.tabs.push(tab);
            this.openTabs(this.tabs);
        }}
    this.deleteTab = function (nav) {
        let newTab = {};
        if (this.tabs.length <= 1) {
            this.openTabs([]);
            window.location.href = "#!/";
            return;
        } else {
            this.tabs.indexOf(nav) === 0 ? newTab = this.tabs[1] : newTab = this.tabs[this.tabs.indexOf(nav) - 1];
        }
        this.switchToTab(newTab);
        this.openTabs(this.tabs.filter(function (tab) {
            return tab !== nav;
        }));
    }
    this.deleteAndClose = function (value) {
        this.deleteTab(this.tabs.find(function (tab) {
            return tab.value === value;
        }));
    }
}
export default TabsService;