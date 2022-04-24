'use strict';

// var app = angular.module('crudApp');
// app.controller('homeCtrl', ['$scope', function($scope) {
//     var self = this;

//     function addCourses() {
//         $state.go('course');
//     }

//     function addStudents() {
//         $state.go('student');
//     }
// }]);
angular.module('crudApp').controller('homeCtrl', ['$scope', function($scope) {
    var self = this;

    function addCourses() {
        $state.go('course');
    }

    function addStudents() {
        $state.go('student');
    }
}]);