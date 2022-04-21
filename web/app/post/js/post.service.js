'use strict';

let PostService = function ($rootScope) {
    this.posts = [];
    this.setPosts = function (posts) {
        this.posts = posts;
        $rootScope.$emit('PostEvent', this.posts);
    }
};

export default PostService;