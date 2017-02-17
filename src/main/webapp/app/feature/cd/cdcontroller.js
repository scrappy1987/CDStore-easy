(function() {

    var cdController =  function(cdService)
    {
        var vm = this;
        vm.sortby = 'Artist';
        vm.reverse =false;
        vm.cds =[];

        vm.doSort = function(propName)
        {
            vm.sortBy= propName;
            vm.reverse= !vm.reverse;
        };

        function init() {
            cdservice.getcds().then(function (results) {
                console.log("In cd controller about to return data to the client with results " + results);
                vm.cd  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }

        init();

    };
    angular.module('cdStore').controller('cdController', ['cdService', cdController]);
}());