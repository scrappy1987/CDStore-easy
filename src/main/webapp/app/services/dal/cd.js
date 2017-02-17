"use strict";

(function () {

    angular.module("cdStore").service("CDDal", ["dal", CDDal]);

    function CDDal (dal) {
        this.getcds = function () {
            return dal.http.GET("rest/cdstore/json");
        };

        this.savecd = function (cdToSave) {
            return dal.http.POST("rest/cdstore/json", cdToSave);
        };

        this.updatecd = function (cdToUpdate) {
            return dal.http.PUT("rest/cdstore/json/", cdToUpdate);
        };

        this.deletecd = function (cdToDelete) {
            return dal.http.DELETE("/rest/cdstore/json/", cdToDelete);
        };

    }
}());
