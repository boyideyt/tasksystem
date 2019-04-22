var app = angular.module('tasksystem', [])

app.controller('projectController', function ($scope, $controller, projectService, taskService) {

    $scope.taskStatusList = ['未完成', '审核进行中', '全部审核通过']
    $scope.projectStatusList = ['敬请期待', '火热进行中', '项目暂停', '项目终止']
    $scope.entity = "";
    $scope.step = {
        "name": "",
        "status": "0"
    };
    $scope.reloadList = function () {
        $scope.getAll();
    }



/**
 *修改新建版块
 */
// 打开动态弹出框
$scope.openModel = function (projectId) {
    $scope.projectStepList = [$scope.step];
    var serviceObject;//服务层对象
    if (projectId != null) {//如果有ID
        serviceObject = projectService.getOne(projectId); //查看
        serviceObject.success(
            function (response) {
                $scope.entity = response;
                $scope.projectStepList = JSON.parse(response.projectStepList);
                //返回步骤列表类型为list,需要分行展示在界面
            }
        );
    }
    $("#projectModel").modal('show');
}


$scope.save = function () {
    var serviceObject;//服务层对象
    $scope.entity.projectStepList = $scope.projectStepList;
    if ($scope.entity.id != null) {//如果有ID
        serviceObject = projectService.update($scope.entity); //修改
    } else {
        serviceObject = projectService.insert($scope.entity);//增加
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

// 添加步骤
$scope.addStep = function () {
    // $scope.projectStepList.push($scope.step);
    $scope.projectStepList.push({"name":"","status":"0"});
}
// 删除指定步骤
$scope.deleStep = function (id) {
    $scope.projectStepList.splice($scope.projectStepList.indexOf(id), 1);
}

$scope.clearModel = function () {
    $scope.entity = null;
}


/**
 * 删除功能版块
 */

$scope.selectIds = [];//用户勾选的id集合
//选中数组的增减
$scope.updateSelection = function ($event, id) {
    if ($event.target.checked) {
        $scope.selectIds.push(id)
    } else {
        $scope.selectIds.splice($scope.selectIds.indexOf(id), 1);
    }
}

$scope.dele = function () {
    projectService.dele($scope.selectIds).success(
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
    ids = [id];
    projectService.dele(ids).success(
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
    projectService.getAll().success(function (response) {
            $scope.list = response;
        }
    );
}

// 根据项目Id 查询已有任务
$scope.searchByProjectName = function (projectName) {
    taskService.searchByProjectName(projectName).success(function (response) {
            $scope.taskList = response;
        }
    );
    $("#taskModel").modal('show');
}

$scope.sum = function (array) {
    var list = array.substring(1, array.length - 1).split(",");
    var result = 0;
    for (var i = 0; i < list.length; i++) {
        result += parseInt(list[i]);
    }
    return result;
}

})
