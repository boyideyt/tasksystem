var app = angular.module('tasksystem', [])

app.controller('projectController', function ($scope, $controller, projectService, taskService, stepService, userService) {

        $scope.taskStatusList = ['任务申请中', '任务进行中', '全部审核通过', '驳回']
        $scope.projectStatusList = ['敬请期待', '火热进行中', '项目暂停', '项目终止']
        $scope.managerList = new Array();
        // project 实体
        $scope.entity = new Object();
        // 步骤实体
        $scope.step = new Object();
        // tsak实体
        $scope.taskEntity = new Object();
        $scope.reloadList = function () {
            $scope.getAll();
        }


        /**
         *修改新建版块
         */
        // 打开动态弹出框
        $scope.openModel = function (projectId) {
            $scope.entity = new Object();
            $scope.projectStepList = [{"stepName": ""}];
            $scope.entity.stepCount = 1;
            if (projectId != null) {//如果有ID

                // 获取该项目
                projectService.getOne(projectId).success(
                    function (response) {
                        $scope.entity = response;
                        //返回步骤列表类型为list,需要分行展示在界面
                    }
                );

                // 搜索该项目绑定的步骤
                taskService.searchByProjectId(projectId).success(
                    function (response) {
                        $scope.projectStepList = response;
                        //返回步骤列表类型为list,需要分行展示在界面
                    }
                )
            }

            // 获取经理列表
            userService.getManager().success(
                function (response) {
                    $scope.managerList = response;
                }
            )
            $("#projectModel").modal('show');
        }

        // 项目弹出窗口的保存按钮
        $scope.save = function () {
            if ($scope.entity.projectId != null) {//如果有ID
                projectService.update($scope.entity).success(
                    function (response) {
                        if (response.signal) {
                            stepService.update($scope.projectStepList).success(
                                function (response) {
                                    if (response.signal) {
                                        alert(response.message);
                                        $scope.reloadList();
                                    } else {
                                        alert(response.message);
                                    }
                                }
                            );
                        } else {
                            alert(response.message);
                        }
                    }
                );
            } else {
                projectService.insert($scope.entity).success(
                    function (response) {
                        if (response.signal) {
                            // 项目保存成功了再保存步骤
                            var id = response.id
                            for (var i = 0; i < $scope.projectStepList.length; i++) {
                                $scope.projectStepList[i].projectId = id;
                            }
                            stepService.insert($scope.projectStepList).success(
                                function (response) {
                                    if (response.signal) {
                                        alert(response.message);
                                        $scope.reloadList();
                                    } else {
                                        alert(response.message);
                                    }
                                }
                            );
                        }
                        $("#projectModel").modal('hide');
                        $scope.clearModel()
                    }
                )
            }
        }

        // 任务创建窗口打开
        $scope.taskCreation = function (projectId, projectName) {
            $scope.taskEntity = new Object();
            $scope.projectStepList = [$scope.step];
            var serviceObject;//服务层对象
            if (projectId != null) {//如果有ID
                serviceObject = projectService.getOne(projectId); //根据id查找项目信息
                serviceObject.success(
                    function (response) {
                        //将项目信息绑定给任务
                        $scope.entity = response;
                        $scope.taskEntity.projectId = projectId;
                        $scope.taskEntity.projectName = projectName;
                        $scope.taskEntity.username = "lizhe";

                        if (response.stepCount > 0) {
                            var taskStepStatus = new Array(response.stepCount);
                            for (var i = 0; i < taskStepStatus.length; i++) {
                                taskStepStatus[i] = 0;
                            }
                        }
                        $scope.taskEntity.taskStepStatus = JSON.stringify(taskStepStatus);
                    }
                );
            }
            $("#newTaskModel").modal('show');
        }

        //提交任务申请
        $scope.submitApplication = function () {
            if ($scope.taskEntity.taskName != null) {
                taskService.insert($scope.taskEntity).success(
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
            } else {
                alert("未输入任务名!")
            }
        }

        // 添加步骤
        $scope.addStep = function () {
            // $scope.projectStepList.push($scope.step);
            $scope.projectStepList.push({"stepName": ""});
            $scope.entity.stepCount++;
        }
        // 删除指定步骤
        $scope.deleStep = function (id) {
            $scope.projectStepList.splice($scope.projectStepList.indexOf(id), 1);
            $scope.entity.stepCount--;
        }

        $scope.clearModel = function () {
            $scope.entity = null;
            $scope.projectStepList = [$scope.step];
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
        $scope.searchByProjectId = function (projectId) {
            taskService.searchByProjectId(projectId).success(function (response) {
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

    }
)
