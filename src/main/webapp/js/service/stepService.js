app.service('stepService',function($http){

    // 任务列表
    this.getAll=function(){
        return $http.get('../StepController/getAll');
    }
    // 任务列表
    this.getOne=function(taskId){
        return $http.get('../StepController/getOne?taskId='+taskId);
    }
    // 任务列表
    this.searchByUsername=function(username){
        return $http.get('../StepController/searchByUsername?username='+username);
    }
    // 任务列表
    this.searchByProjectId=function(projectId){
        return $http.get('../StepController/searchByProjectId?projectId='+projectId);
    }
    // 新建任务
    this.insert=function(entity){
        return $http.post('../StepController/insert',entity);
    }
    // 删除用户
    this.dele=function(selectIds){
        return $http.get('../StepController/delete?ids='+selectIds);
    }
    // 更新任务信息
    this.update=function(entity){
        return $http.post('../StepController/update',entity);
    }
})