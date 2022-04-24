var app = angular.module('crudApp', ['ui.router']); //'ngStorage'

app.controller('appCtrl', ['$scope', function($scope) {
    // var self = this;

    // function addCourses() {
    //     $state.go('course');
    // }

    // function addStudents() {
    //     $state.go('student');
    // }
}]);
app.constant('urls', {
    BASE: 'http://localhost:8080/',
    COURSE_SERVICE_API: 'http://localhost:8080/api/course/',
    STUDENT_SERVICE_API: 'http://localhost:8080/api/student/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('init', {
                url: '/init',
                templateUrl: 'init',
                controller: 'appCtrl',
                // controllerAs: 'homeCtrl',
            })
            .state('home', {
                url: '/home',
                templateUrl: 'home',
                controller: 'homeCtrl',
            })
            .state('register', {
                url: '/register',
                templateUrl: 'register',
                controller: 'registerCtrl',
                // controllerAs: 'homeCtrl',
            })
            // .state('register2', {
            //     url: '/register-test',
            //     templateUrl: 'register_test',
            //     controller: 'registerCtrl',
            //     // controllerAs: 'homeCtrl',
            // })
            .state('student', {
                url: '/student',
                templateUrl: '/students',
                controller: 'StudentController',
                controllerAs: 'studentCtrl',
                resolve: {
                    students: function($q, StudentService) {
                        console.log('Listando os alunos');
                        var deferred = $q.defer();
                        StudentService.loadAllStudents().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    },
                    courses: function($q, CourseService) {
                        console.log('Listando os cursos');
                        var deferred = $q.defer();
                        CourseService.loadAllCourses().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            })
            .state('course', {
                url: '/course',
                templateUrl: '/courses',
                controller: 'CourseController',
                controllerAs: 'courseCtrl',
                resolve: {
                    courses: function($q, CourseService) {
                        console.log('Listando os cursos');
                        var deferred = $q.defer();
                        CourseService.loadAllCourses().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
    }
]);