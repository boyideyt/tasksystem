app.service('projectService',function($http){

    // 项目列表
    this.getAll=function(){
        return $http.get('../ProjectController/getAll');
    }
    // 项目查询
    this.getOne=function(projectId){
        return $http.get('../ProjectController/getOne?projectId='+projectId);
    }
    // 新建项目
    this.insert=function(entity){
        return $http.post('../ProjectController/insert',entity);
    }
    // 删除项目
    this.dele=function(selectIds){
        if(confirm()){
        return $http.get('../ProjectController/delete?ids='+selectIds);
        }
    }
    // 更新项目信息
    this.update=function(entity){
        return $http.post('../ProjectController/update',entity);
    }
})