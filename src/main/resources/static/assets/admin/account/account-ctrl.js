/**
 * 
 */

app.controller("account-ctrl", function($scope, $http){
$scope.items = [];
$scope.cates = [];
$scope.editform = false;
	$scope.form = {
		image: 'cloud-upload.png',
		createdate: new Date(),
		status: true
	};
$scope.statusb = function(username){
		console.log("username");
	}
	$scope.intialize = function(){
		//load products
		$http.get("/rest/accounts").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				item.createDate = new Date(item.createDate);
			})
			
		}).catch(error => {
		console.log("Error", error);
		});
		//load categories
		$http.get("/rest/categories").then(resp => {
			$scope.cates = resp.data;
		}).catch(error => {
		console.log("Error", error);
		});
	}
	//Khởi đầu
	$scope.intialize();

	//xóa form
	$scope.reset = function(){
		$scope.form = {
			image: 'account-null.png',
		}
	}
	//Hiển thị lên form
	$scope.edit = function(item){
		$scope.editform = true;
		$scope.form = angular.copy(item);
		$(".nav-tabs a:eq(0)").tab('show')
	}
	//Thêm sản phẩm mới
	$scope.create = function(){
		var item = angular.copy($scope.form);
		$http.post(`/rest/accounts`, item).then( resp =>{
			$scope.items.push(resp.data);
			$scope.reset();
			alert("Add New User Success!");
			window.location.reload();
		}).catch(error => {
			alert("Add New User Error!");
			console.log("Error", error);
		})
	}
	//Cập nhật sản phẩm
	$scope.update = function(){
		var item = angular.copy($scope.form);
		$http.put(`/rest/accounts`, item).then( resp =>{
			var index = $scope.items.findIndex(p => p.id == item.id);
			resp.data.createDate = new Date(resp.data.createDate)
			$scope.items[index] = item;
			alert("Update User Success!");
				window.location.reload();
		}).catch(error => {
			alert("Update User Error!");
			console.log("Error", error);
		})
	}
	$scope.sleep = function(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}
	//Xóa sản phẩm
	$scope.delete = function(item){
		$http.delete(`/rest/accounts/delete/${item.username}`).then(resp => {
			var index = $scope.items.findIndex(a => a.username == item.username);
			$scope.items.splice(index, 1);
			$scope.reset();
			alert("Remove User Success!");
			}).catch(error => {
			alert("Remove User Error!");
			});
	}
	//Upload hình
	$scope.imageChanged = function(files){
		 var form = new FormData();
            form.append("file", files[0]);
        $http.post('/rest/upload/images', form , {
            transformRequest: angular.identity, headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.photo = resp.data.name;
        }).catch(error => {
        	alert("File can more big than 1048576 bytes");
            console.log("Error", error);
        });
	}
	
	
	$scope.pager = {
		page: 0,
		size: 10,
		get items(){
			var start = this.page * this.size;
			return $scope.items.slice(start, start + this.size);
		},
		get count(){
			return Math.ceil(1.0 * ($scope.items.length/this.size));
		},
		first(){
			this.page = 0
		},
		prev(){
			this.page--;
			if(this.page < 0){
				this.last();
			}
		},
		next(){
			this.page++;
			if(this.page >= this.count){
				this.first();
			}
		},
		last(){
			this.page = this.count - 1;
		}
	}
	
});