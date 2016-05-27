/**
 * Created by Dharmik 27th May 2016
 */
var cartApp = angular.module("cartApp",[]);

cartApp.controller("cartCtrl", function($scope,$http){
	
	$scope.refreshCart = function(cartId){
		
		$http.get('/Cart/rest/cart/'+cartId).success(function(data){
			$scope.cart = data;
		});
	};
	
	$scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };
	
});