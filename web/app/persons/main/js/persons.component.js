'use strict';

import PersonsController from "./persons.controller";

let PersonsComponent = {
    template: require("../persons.html").default,
    controller: PersonsController
};

export default PersonsComponent;