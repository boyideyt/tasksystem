app.service('taskService',function($http){

    // 任务列表
    this.getAll=function(){
        return $http.get('../TaskController/getAll');
    }
    // 任务列表
    this.getOne=function(taskId){
        return $http.get('../TaskController/getOne?taskId='+taskId);
    }
    // 任务列表
    this.searchByUsername=function(username){
        return $http.get('../TaskController/searchByUsername?username='+username);
    }
    // 任务列表
    this.searchByProjectName=function(projectName){
        return $http.get('../TaskController/searchByProjectName?projectName='+projectName);
    }
    // 新建任务
    this.insert=function(entity){
        return $http.get('../TaskController/insert',entity);
    }
    // 删除用户
    this.dele=function(selectIds){
        return $http.get('../TaskController/delete?ids='+selectIds);
    }
    // 更新用户信息

})