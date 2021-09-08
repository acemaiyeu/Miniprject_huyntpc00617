/**
 * 
 */

app.controller("product-ctrl", function($scope, $http){
$scope.items = [];
$scope.colors = [];
$scope.cates = [];
$scope.supplier = [];
$scope.colorsname = [];
$scope.descriptions = [];
$scope.inputproduct = [];
$scope.forminputp = [];
$scope.formcolor = {
};
$scope.formsub = {
	supplierid: undefined
};
	$scope.form = {
		imagename1: 'cloud-upload.png',
		imagename2: 'cloud-upload.png',
		imagename3: 'cloud-upload.png',
		createdate: new Date(),
		status: true,
		qty: 1000,
		updateedate: new Date()
	};
	$scope.checkdate = function(){
		if($scope.form.createdate > new Date()){
			$scope.form.createdate = new Date();
		}
	}
	$scope.cdetails = [];
	var i = 1;
	var y = 1;
	$scope.editform = false;
$scope.alert = function(colorid){
		var it = $scope.cdetails.findIndex(p => p == colorid);
		
		if(it == -1){
			$scope.cdetails.push(colorid);
		}if(it != -1){
			$scope.cdetails.splice(it,1);
		}
		colorid = undefined;	
		console.log($scope.cdetails);
}
//Hiện form edit color
$scope.coloredit = function(){
	y++;
	if(y%2==0){
		$scope.editform = true;
		y = 1;
	}else{$scope.editform = false;}
	console.log("Editform: "+$scope.editform);
}
//ẩn color
$scope.hiddencolor =function(){
	$scope.editform = false;
}
//lấy tên product từ mã sản phẩm
$scope.getnameproduct = function(){
	$scope.itemproduct = angular.copy($scope.items);
	for(let em = 0; em < $scope.itemproduct.length;em++){
		name = undefined;
		if($scope.itemproduct[em].productidl == $scope.formcolor.product.productidl){
			$scope.productname = $scope.itemproduct[em].productname;
		}
	}
}
	$scope.edittrue = false;
	$scope.intialize = function(){
		//load products
		$http.get("/rest/products").then(resp => {
		resp.data.createdate = new Date(resp.data.createdate)
		$scope.items = resp.data;
		
		}).catch(error => {
		console.log("Error", error);
		
		});
		//load categories
		$http.get("/rest/categories").then(resp => {
			$scope.cates = resp.data;
		}).catch(error =>{
			console.log("Error", error);
		});
		//load Color
		$http.get("/rest/colors").then(resp => {
			$scope.colors = resp.data;
		}).catch(error =>{
			console.log("Error", error);
		});
		//load colorDetails
		$http.get("/rest/colorsdetails").then(resp => {
			$scope.colorsdetails = resp.data;
		}).catch(error =>{
			console.log("Error", error);
		});
		//loadListNameColor
		
		//load Description
		$http.get("/rest/descriptions").then(resp => {
			$scope.descriptions = resp.data;
		}).catch(error =>{
			console.log("Error", error);
		});
		//load Supplier
		$http.get("/rest/supplier").then(resp => {
			$scope.supplier = resp.data;
		}).catch(error =>{
			console.log("Error", error);
		});
		$http.get("/rest/inputproduct").then(resp => {
			$scope.inputproduct = resp.data;
			$scope.forminputp = angular.copy($scope.inputproduct);
		}).catch(error =>{
			console.log("Error", error);
		});
	}
	//Khởi đầu
	$scope.intialize();
	

	//xóa form
	$scope.reset = function(){
		$scope.form = {
		imagename1: 'cloud-upload.png',
		imagename2: 'cloud-upload.png',
		imagename3: 'cloud-upload.png',
		createdate: new Date(),
		status: true,
		qty: 1000,
		updateedate: new Date()
	};
		$scope.edittrue = false;
		$scope.editproduct = false;
	}
	$scope.resetcolor= function(){
		$scope.formcolor = {};
	}
	$scope.itemproducttemp = {};
	//Hiển thị lên form
	$scope.edit = function(item){
		if($scope.editproduct == false){
		$scope.itemproducttemp = angular.copy(item);
		}
		$scope.editproduct = true;
		$scope.cdetails = [];
		console.log(item);
		$http.get(`/rest/colorsname/${item.productidl}`).then(resp => {
			$scope.colorsname = resp.data;
			console.log($scope.colorsname);
		}).catch(error =>{
			console.log("Error", error);
		});
		var subplierid = undefined;
		
		for(var input = 0; input < $scope.forminputp.length; input++){
		//	console.log($scope.forminputp);
			if($scope.forminputp[input].product.productidl 
			== item.productidl){
				subplierid = $scope.forminputp[input].supplier.supplierid;	
			
			}
			//console.log(subplierid);
		}
		//console.log($scope.inputproduct);
		$scope.formsub = {
			supplierid: subplierid
		}
		$scope.form = angular.copy(item);
		$scope.form.createdate = new Date($scope.form.createdate);
		$scope.edittrue = true;
		$(".nav-tabs a:eq(0)").tab('show')
	}
	$scope.editcolor= function(item){
		$scope.editform = true;
		$scope.productname = item.product.productname;
		$scope.formcolor = angular.copy(item);
		$(".nav-tabs a:eq(0)").tab('show')
	}
	//Thêm sản phẩm mới
	var formcolordetails = angular.copy($scope.cdetails);
	$scope.create = function(){
		var supplierid = $scope.formsub.supplierid;
		var item = angular.copy($scope.form);
		$http.post(`/rest/products/${supplierid}`, item).then( resp =>{
			resp.data.createDate = new Date(resp.data.createDate)
			$scope.items.push(resp.data);
			$scope.reset();
			$http.post(`/rest/color/${resp.data.productidl}`, $scope.cdetails).then( resp =>{
			});
			alert("Thêm sản phẩm mới thành công!");
			window.location.reload();
			
		}).catch(error => {
			alert("Thêm sản phẩm lỗi!");
			console.log("Error", error);
		});
		
		
	}
	//Cập nhật sản phẩm
	$scope.update = function(){
		var supplierid = $scope.formsub.supplierid;
		var item = angular.copy($scope.form);
		console.log(item);
		$http.put(`/rest/products/${supplierid}`, item).then( resp =>{
			var index = $scope.items.findIndex(p => p.productidl == item.productidl);
			resp.data.createDate = new Date(resp.data.createDate)
			$scope.items[index] = item;
			console.log($scope.cdetails);
			var formd = angular.copy($scope.cdetails);
			$http.delete(`/rest/colors/delete/${item.productidl}?item=${formd}`).then(resp => {
			
		}).catch(error => {
			//alert("Remove Colors Error!");
			console.log("Error", error);
		});
			alert("Update Product Success!");
				//window.location.reload();
		}).catch(error => {
			alert("Update Product Error!");
			console.log("Error", error);
		});
		var formcolordetails = angular.copy($scope.cdetails);
		
		
	}
	//Xóa sản phẩm
	$scope.delete = function(item){
		$http.delete(`/rest/products/delete/${item.productidl}`).then(resp => {
			var index = $scope.items.findIndex(p => p.productidl == item.productidl);
			$scope.items.splice(index, 1);
			$scope.reset();
			alert("Xóa sản phẩm thành công!");
			}).catch(error => {
			alert("Xóa sản phẩm thất bại!");
			console.log(item);
			});
	}
	//Upload hình
	$scope.imageChanged1 = function(files){
		 var form = new FormData();
            form.append("file", files[0]);
        $http.post('/rest/upload/images', form , {
            transformRequest: angular.identity, headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.imagename1 = resp.data.name;
        }).catch(error => {
        	alert("File can more big than 1048576 bytes");
            console.log("Error", error);
        });
	}
	$scope.imageChanged2 = function(files){
		 var form = new FormData();
            form.append("file", files[0]);
        $http.post('/rest/upload/images', form , {
            transformRequest: angular.identity, headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.imagename2 = resp.data.name;
        }).catch(error => {
        	alert("File can more big than 1048576 bytes");
            console.log("Error", error);
        });
	}
	$scope.imageChanged3 = function(files){
		 var form = new FormData();
            form.append("file", files[0]);
        $http.post('/rest/upload/images', form , {
            transformRequest: angular.identity, headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.imagename3 = resp.data.name;
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
//			console.log("ItemL: "+ $scope.items.length/this.size);
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
	$scope.pagercolor = {
		pagec: 0,
		sizec: 10,
		get items(){
			var start = this.pagec * this.sizec;
			return $scope.colors.slice(start, start + this.sizec);
		},
		get count(){
			//console.log("ItemL: "+ $scope.colors.length/this.sizec);
			return Math.ceil(1.0 * ($scope.colors.length/this.sizec));
		},
		first(){
			this.pagec = 0
		},
		prev(){
			this.pagec--;
			if(this.pagec < 0){
				this.last();
			}
		},
		next(){
			this.pagec++;
			if(this.pagec >= this.count){
				this.first();
			}
		},
		last(){
			this.pagec = this.count - 1;
		}
	}
	
	$scope.pagerdescription = {
		page: 0,
		size: 10,
		get items(){
			var start = this.page * this.size;
			return $scope.descriptions.slice(start, start + this.size);
		},
		get count(){
			//console.log("ItemL: "+ $scope.descriptions.length/this.size);
			return Math.ceil(1.0 * ($scope.descriptions.length/this.size));
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
	
	$scope.deletecolor = function(item){
		console.log(item);
		$http.delete(`/rest/color/delete/${item.product.productidl}/${item.colorsdetails.colorid}`).then(resp =>{
			alert("Remove color Success!");
			$scope.edit($scope.itemproducttemp);
		}).catch(error =>{
			alert("Remove color Not Success! Productid not in this color ");
		console.log("ERROR",error);
		});
	}
	$scope.createcolor= function(item){
		$http.post(`/rest/color`, item).then(resp =>{
		
			alert("Add color Success!");
		//console.log($scope.itemproducttemp);
			if($scope.form.productidl != undefined && $scope.editproduct == true){
				$scope.form.productidl = undefined;
				$scope.edit($scope.itemproducttemp);
			}
		}).catch(error =>{
			alert("Add color Not Success! Productid and this color exited");
			console.log("Error", error);
		});
	}
	$scope.resetcolor = function(){
		$scope.formcolor = {};
	}
	
	
	$scope.editproduct = false;
	$scope.statusbutton = function(productid){
	if(productid == undefined){
		$scope.editproduct = false;
	return false;
	}else{
		$scope.editproduct = true;
	return true;
	}
	}
	$scope.StatusButtonDeleteUpdate = function(productid){
	if(productid == undefined){
	return true;
	}else{
	return false;
	}
	}
});