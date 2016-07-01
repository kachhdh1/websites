/**
 * Created by Dharmik 27th May 2016
 */
var cartApp = angular.module("cartApp",[]);

cartApp.controller("cartCtrl", function($scope,$http){
	
	$scope.refreshCart = function(){
		
		$http.get('/komalAgate/rest/cart/'+$scope.cartId).success(function(data){
			$scope.cart = data;
			
			//set the grand total
			var grandTotal = 0;
	    	//as the return data is in json format, cart.items will be 
	    	//an array and we can use ES5 forEach also on that.
	    	for (var i=0; i<$scope.cart.cartItems.length; i++) {
	            grandTotal+=$scope.cart.cartItems[i].totalAmount;
	        }
	    	$scope.cartGrandTotal = grandTotal;
		});
	};
	
	$scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart();
    };
    
    $scope.addToCart = function(productId){
    	
    	$http.put('/komalAgate/rest/cart/add/'+productId).success(function(){
    		alert('Product succesfully added to your cart.');
    	});
    };
    
    //the function will be used to remove a single product from the cart
    $scope.removeFromCart = function(productId){
    	$http.put('/komalAgate/rest/cart/remove/'+productId).success(function(){
    		$scope.refreshCart();
    	});
    };
    
    //the function is called to remove all the products from the cart
    $scope.clearCart = function(){
    	$http.put('/komalAgate/rest/cart/clear/'+$scope.cartId).success(function(){
    		$scope.refreshCart();
    	});
    };
    
    $scope.getCartTotal = function(){
    	//get the cart details from the scope object set in the 
    	//refereshCart method
    	var grandTotal = 0;
    	//as the return data is in json format, cart.items will be 
    	//an array and we can use ES5 forEach also on that.
    	for (var i=0; i<$scope.cart.cartItems.length; i++) {
            grandTotal+=$scope.cart.cartItems[i].totalAmount;
        }
    	
    	return grandTotal;
    };
	
});