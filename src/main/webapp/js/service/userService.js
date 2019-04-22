app.service('userService',function($http){

    // 用户列表
    this.getAll=function(){
        return $http.get('../UserController/getAll');
    }
    // 用户查询
    this.getOne=function(username){
        return $http.get('../UserController/getOne?username='+username);
    }
    // 新建用户
    this.insert=function(entity){
        return $http.post('../UserController/insert',entity);
    }
    // 删除用户
    this.dele=function(selectIds){
        return $http.get('../UserController/delete?ids='+selectIds);
    }
    // 更新用户信息
    this.update=function(entity){
        return $http.post('../UserController/update',entity);
    }
})