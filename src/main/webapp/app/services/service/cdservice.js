(function() {

    var cdService =  function(cdDal) {

        this.getcds = function () {
            return cdDal.getcds();
        };

        this.getAllcds = function () {

            return cdDal.getAllcds();
        };
    };

    angular.module('cdStore').service('cdService', ['cdDal', cdService]);
}());