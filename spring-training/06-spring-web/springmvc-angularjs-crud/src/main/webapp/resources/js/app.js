var myApp = angular.module('myApp',['ngRoute','appControllers']);

myApp.config(['$routeProvider',
        function($routeProvider) {
          $routeProvider.
            when('/users', {
              templateUrl: 'views/users.html',
              controller: 'UserController'
            }).
            when('/roles', {
            	templateUrl: 'views/roles.html',
                controller: 'RoleController'
            }).
            otherwise({
              redirectTo: '/users'
            });
}]);

