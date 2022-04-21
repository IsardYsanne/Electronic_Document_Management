'use strict';

let PersonsService = function ($rootScope) {
    this.persons = [];
    this.setPersons = function (persons) {
        this.persons = persons;
        $rootScope.$emit('PersonEvent', this.persons);
    }
};

export default PersonsService;