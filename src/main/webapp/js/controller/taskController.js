var app = angular.module('tasksystem', [])




app.controller('taskController',  function($scope, $controller, taskService) {


    $scope.taskStatusList=['未完成','审核进行中','全部审核通过','驳回']
    $scope.taskStepStatusList=['未完成','审核进行中','驳回','审核通过']
    $scope.reloadList = function () {
        $scope.getAll();
    }

    /**
     *修改新建版块
     */
    // 打开动态弹出框
    $scope.openModel = function (taskId) {
        $scope.taskStepList = ['请输入任务名称'];
        $scope.taskStepStatus = [0];
        var serviceObject;//服务层对象
        if (taskId != null) {//如果有ID
            serviceObject = taskService.getOne(taskId); //查看
            serviceObject.success(
                function (response) {
                    $scope.entity = response;
                    $scope.taskStepList = JSON.parse(response.taskStepList);
                    $scope.taskStepStatus = JSON.parse(response.taskStepStatus);
                    //返回步骤列表类型为list,需要分行展示在界面
                }
            );
        }
        $("#taskModel").modal('show');
    }

    $scope.changeStatus = function(status,index){

    }

    $scope.save = function () {
        var serviceObject;//服务层对象
        $scope.entity.taskStepList = JSON.stringify($scope.taskStepList);
        if ($scope.entity.id != null) {//如果有ID
            serviceObject = taskService.insert($scope.entity); //修改
        } else {
            serviceObject = taskService.update($scope.entity);//增加
        }
        serviceObject.success(
            function (response) {
                if (response.signal) {
                    alert(response.message);
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
        $("#projectModel").modal('hide');
        $scope.clearModel()
    }
    /**
     * 删除功能版块
     */
    $scope.dele = function () {
        taskService.dele($scope.selectIds).success(
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
        taskService.dele(ids).success(
            function (response) {
                if (response.signal) {
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
    }


    /**
     * 查询业务版块
     */
    $scope.getAll = function () {
        taskService.getAll().success(function (response) {
                $scope.list = response;
            }
        );
    }

    $scope.searchByUsername = function (username) {
        taskService.searchByUsername(username).success(function (response) {
                $scope.list = response;
            }
        );
    }

    $scope.sum = function (array) {
        var list = array.substring(1,array.length-1).split(",");
        var result = 0;
        for ( var i = 0; i < list.length; i++) {
            result += parseInt(list[i]);
        }
        return result;
    }

    $scope.insert = function () {
        taskService.insert($scope.entity).success(
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
})