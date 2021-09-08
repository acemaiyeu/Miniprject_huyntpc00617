/**
 * 
 */
/**
 * 
 */
const app = angular.module("shopping-cart-app", []);
app.controller("shopping-cart-ctrl", function($scope, $http){
	/*
	QUẢN LÝ GIỎ HÀNG
	*/
	$scope.cart = {
		
		items: [],
		//Thêm sản phẩm vào giỏ hàng
		add(id){
			var item = this.items.find(item => item.productidl == id);
				console.log("exist-: "+item);
			if(item != undefined){
				item.qty++;
				this.saveToLocalStorage();
				console.log("exist")
			}else{
				$http.get(`/rest/products/${id}`).then(resp => {
					resp.data.qty = 1;
					this.items.push(resp.data);
					this.saveToLocalStorage();
	console.log("add: ");
				});
			}
			},
		//xóa sản phẩm  khỏi giỏ hàng
		remove(id){
			var index = this.items.findIndex(item => item.productidl == id);
			this.items.splice(index, 1);
			this.saveToLocalStorage();
		},
		//xóa sạch các mặt hàng trong giỏ
		clear(){
			this.items = [];
			this.saveToLocalStorage();
		},
		//Tính thành tiền của 1 sản phẩm
		amt_of(item){},
		//Tính tổng số lượng các mặt hàng trong giỏ
		get count(){
			return this.items.map(item => item.qty).reduce((total, qty) => total += qty, 0);
		},
		//Tính thành tiền các mặt hàng trong giỏ
				get amount(){
					return this.items.map(item => item.qty * item.price).reduce((total, qty) => total += qty, 0);
				},
		saveToLocalStorage(){
			$scope.itemss = this.items;
		var json = JSON.stringify(angular.copy(this.items));	
		
				console.log(json);
			localStorage.setItem("cart", json);
		},
		loadFromLocalStorage(){
			var json = localStorage.getItem("cart");
			
			this.items = json ? JSON.parse(json) : [];
		}
	}
	$scope.cart.loadFromLocalStorage();
	var todate = new Date();
	$scope.order = {
	orderdate: new Date(),
	requireddate: todate,
	shipaddress: "",
	city: "",
	shippostalcode: "",
	statusrder: {id: "CXN"},
	accounts: {username: $("#username").text()},
	get listorderdetailstemp(){
	return $scope.cart.items.map(item => {
	return {
	product: {productidl: item.productidl},
	price: item.price,
	quantity: item.qty,
	status: true,
	create_date: new Date(),
	discount: 0.2,
	unitprice: "chiếc"
	}
	});
	},
	purchase(){	
		if($scope.cart.count <= 0){
			alert("Không thể đặt hàng khi giỏ hàng rỗng!");
			console.log("Cart null");
		}else{
		var today = new Date();
		var account = {
			username: $("#username").text(),
			password: Math.floor(Math.random() * 100000000) + 1 + today.getHours().toString() + today.getMinutes().toString() + today.getSeconds().toString(),
			fullname: "",
			email: $("#username").text(),
			photo: "account-null.png"
		};
		$http.post("/rest/accounts/facebookorgooogle", account).then(resp => {
			console.log("Success");
			alert("Create user success!");
		}).catch(error => {
		console.log("Error", error);
		});
		
		var order = angular.copy(this);
		//Thực hiện đặt hàng
		console.log(order);
		$http.post("/rest/orderstemp", order).then(resp => {
			alert("Đặt hàng thành công!");
			$scope.cart.clear();
			location.href = "/";
		}).catch(error => {
			alert("Đặt hàng lỗi");
			console.log(error);
		});
	}
	}
	}
});