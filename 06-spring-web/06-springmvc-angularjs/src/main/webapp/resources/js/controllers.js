var appControllers = angular.module('appControllers', []);


appControllers.controller('RoleController',['$scope', '$http','$routeParams', function($scope, $http, $routeParams){
	$scope.hello = "";
	
	$http.get('rest/roles/')
	.success(function(data, status, headers, config){
		$scope.roles = data;
	})
	.error(function(data, status, headers, config){
		alert('Error');
	});
	
	/*
	$scope.loadUsers = function(){
		$http.get('rest/roles/')
			.success(function(data, status, headers, config){
				$scope.roles = data;
			})
			.error(function(data, status, headers, config){
				alert('Error');
			});
	};
	$scope.loadUsers();
	*/
}]);


appControllers.controller('UserController',['$scope', '$http',function($scope, $http){
	
	$scope.loadUsers = function(){
		$http.get('rest/users/')
			.success(function(data, status, headers, config){
				$scope.users = data;
			})
			.error(function(data, status, headers, config){
				alert('Error');
			});
	};
	
	$scope.loadHome = function(){
		$scope.resetAll();
		$scope.loadUsers();
	};
	
	$scope.resetAll = function() {
		$scope.query = '';
		$scope.newUser = null;
		$scope.currentUser = null;
	};
	
	$scope.searchUsers = function(){
		$http.get('rest/users/search?query='+$scope.query)
		.success(function(data, status, headers, config){
			$scope.users = data;
		});
		
		//$scope.loadHome();
	};
	
	$scope.newUserForm = function(){
		$scope.resetAll();
		$scope.newUser = {};
	};
	
	$scope.editUserForm = function(userId){
		$scope.resetAll();
		
		$http.get('rest/users/'+userId)
		.success(function(data, status, headers, config){
			$scope.currentUser = data;
		})
		.error(function(data, status, headers, config){
			alert('Error');
		});
	};
	

	$scope.createUser = function(){
		$http.post('rest/users/', $scope.newUser)
		.success(function(data, status, headers, config){
			$scope.loadHome();
		})
		.error(function(data, status, headers, config){
			alert('Error :'+data.error);
		});
		
	};
	
	$scope.updateUser = function(){
		$http.put('rest/users/',$scope.currentUser)
		.success(function(){
			$scope.loadHome();
		});
	};
	
	$scope.deleteUser = function(userId){
		$http.delete('rest/users/'+userId)
		.success(function(){
			$scope.loadHome();
		});
	};
	
	$scope.loadHome();
}]);

