var innApp = angular.module('innApp', [ 'ui.bootstrap' ]);
angular.module('innApp').controller('InnovationCtrl',
		function($scope, $http, $filter) {
			$scope.weekEnabled = false;
			$scope.effortsEnabled = false;
			$scope.updateEnabled = false;
			$scope.getUser = function(val) {
				return $http.get('innovation/searchUser', {
					params : {
						email : val,
					}
				}).then(function(response) {
					$scope.alerts = null;
					$scope.weekEnabled = true;
					$scope.updateSuccess = false;
					return response.data.timeTrackUsers.map(function(item) {
						return item.email;
					});
				});
			};

			$scope.updateDetails = function() {
				return $http.get('innovation/updateDetails', {
					params : {
						email : $scope.emailSelected,
						effort : $scope.efforts,
						week : $filter('date')($scope.week, 'ww')
					}
				}).then(function(response) {
					$scope.updateEnabled = false;
					$scope.weekEnabled = false;
					$scope.effortsEnabled = false;
					$scope.emailSelected = "";
					$scope.week = "";
					$scope.efforts = "";
					$scope.alerts = [ {
						type : 'success',
						msg : 'Details updated successfully.'
					} ];
				});
			};

			$scope.closeAlert = function(index) {
				$scope.alerts.splice(index, 1);
			};
		});