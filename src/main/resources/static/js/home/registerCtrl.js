'use strict';

angular.module('crudApp').controller('registerCtrl', ['$scope', '$http', function($scope, $http, $location, $state) {
    $scope.input3 = "";

    $scope.goRegister = function() {
        console.log("ssss");
        var data = {
            address: ''
        }
        data.address = $scope.input3;
        // $http({
        //     method: 'POST',
        //     url: 'go-register',
        //     data: data,
        //     // headers: {
        //     //     'Content-Type': 'application/x-www-form-urlencoded'
        //     // }
        // });
        $http({
            method: 'POST',
            url: 'go-register',
            data: data,
        }).then(function successCallBack(response) {
            if (response.data.errorMsg) {
                alert(response.data.errorMsg);
                return;
            }
            if (response.data.result == 1) {
                alert("address successfully registered");
            }
        }, function errorCallBack(response) {
            if (response.data.errorMsg) {
                alert(response.data.errorMsg);
            }
        });
    }
}]);