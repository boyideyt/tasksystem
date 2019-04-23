app.service('stepTaskService',function($http){

    // 任务步骤列表
    this.getAll=function(){
        return $http.get('../StepTaskController/getAll');
    }
    // 任务步骤
    this.getOne=function(taskId){
        return $http.get('../StepTaskController/getOne?taskId='+taskId);
    }
    // 待处理列表
    this.searchByUsername=function(username){
        return $http.get('../StepTaskController/searchByUsername?username='+username);
    }
    // 任务下的列表
    this.searchByProjectId=function(taskId){
        return $http.get('../StepTaskController/searchByTaskId?taskId='+taskId);
    }
    // 新建任务
    this.insert=function(entity){
        return $http.post('../StepTaskController/insert',entity);
    }
    // 删除用户
    this.dele=function(selectIds){
        return $http.get('../StepTaskController/delete?ids='+selectIds);
    }
    // 更新任务信息
    this.update=function(entity){
        return $http.post('../StepTaskController/update',entity);
    }
})