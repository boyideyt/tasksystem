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
    this.searchByProjectId=function(projectId){
        return $http.get('../TaskController/searchByProjectId?projectId='+projectId);
    }
    // 新建任务
    this.insert=function(entity){
        return $http.post('../TaskController/insert',entity);
    }
    // 删除任务
    this.dele=function(selectIds){
        if(confirm("你确认要删除么")) {
            return $http.get('../TaskController/delete?ids=' + selectIds);
        }
    }
    // 更新任务信息
    this.update=function(entity){
        return $http.post('../TaskController/update',entity);
    }
})