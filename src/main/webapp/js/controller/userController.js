var app = angular.module('tasksystem', [])

app.controller('userController',  function($scope, $controller, userService) {


    $scope.roleList=['访客','讲师','经理','超级管理员']
    $scope.reloadList = function () {
        $scope.getAll();
    }



    $scope.getAll = function () {
        userService.getAll().success(function (response) {
                $scope.list = response;
            }
        );
    }

    $scope.getOne = function (username) {
        userService.getOne(username).success(function (response) {
                $scope.userEntity = response;
                $("#userModel").modal('show');
            }
        );
    }

    $scope.insert = function () {
        userService.insert($scope.entity).success(
            function (response) {
                if (response.signal) {
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
    }

    $scope.selectIds = [];//用户勾选的id集合

    //选中数组的增减
    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {
            $scope.selectIds.push(id)
        } else {
            $scope.selectIds.splice($scope.selectIds.indexOf(id),1);
        }
    }

    $scope.dele = function () {
        userService.dele($scope.selectIds).success(
            function (response) {
                if (response.signal) {
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
    }
    $scope.deleOne = function (id) {
        ids=[id];
        userService.dele(ids).success(
            function (response) {
                if (response.signal) {
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
    }

    $scope.update = function () {
        userService.update($scope.userEntity).success(
            function (response) {
                if (response.signal) {
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
    }


    $scope.myVar=true;
    $scope.toggle = function() {
        $scope.myVar = !$scope.myVar;
    }
})