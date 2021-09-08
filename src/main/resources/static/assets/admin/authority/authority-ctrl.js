/**
 * 
 */

app.controller("authority-ctrl", function($scope, $http, $location) {
	$scope.roles = [];
	$scope.admins = [];
	$scope.authorities = [];
	
	$scope.initialize = function(){
		//load  all roles
		$http.get("/rest/roles").then(resp => {
			$scope.roles = resp.data;
//			console.log($scope.roles);
		}).catch(error => {
			console.log("Error", error);
		});
	}
	$scope.initialize();
	//load staff and directors (administrators)
	$http.get("/rest/accounts?admin=true").then(resp => {
		$scope.admins = resp.data;
		
	}).catch(error => {
			console.log("Error", error);
		});
		
		//load authorities of staffs and  directors
		$http.get("/rest/authorities?admin=true").then(resp => {
	//		console.log(resp.data);
		$scope.authorities = resp.data;
		
	}).catch(error => {
		$location.path("/unauthorized");
		});
		
	$scope.authority_of = function(acc,role){
		if($scope.authorities){
			//console.log(acc);
			//console.log(role);
			//console.log($scope.authorities);
	//console.log($scope.authorities.find(ur => ur.accounts.username == acc.username && ur.role.id == role.id));
			return $scope.authorities.find(ur => ur.accounts.username == acc.username && ur.role.id == role.id);
		}
	};
	$scope.authority_changed = function(acc, role){
		var authority = $scope.authority_of(acc, role);
		
		if(authority){ // đã cấp quyền ==> thu hồi quyền (xóa)
			$scope.revoke_authority(authority);
		}else{ // chưa cấp quyền ==> cấp quyền (thêm mới)
			authority = {accounts: acc, role: role};
			$scope.grant_authority(authority);
		}
	};

	$scope.revoke_authority = function(authority){
	//	console.log(authority);
		$http.delete(`/rest/authorities/${authority.authid}`).then(resp => {
			var index = $scope.authorities.findIndex(a => a.id == authority.authid);
			$scope.authorities.splice(index, 1);
			alert("Thu hồi quyền thành công!");
			window.location.reload();
			console.log(authority);
		}).catch(error => {
			alert("Thu hồi quyền thất bại!");
			window.location.reload();
			console.log("Error", error);
		});
	}

	$scope.grant_authority = function(authority){
	
		$http.post(`/rest/authorities`, authority).then(resp => {
			$scope.authorities.push = resp.data;
			alert("Cấp quyền thành công!");
			console.log(authority);
			//window.location.reload();
		}).catch(error => {
			alert("Cấp quyền thất bại!");
			
			//window.location.reload();
			console.log("Error", error);
		});
	}
});